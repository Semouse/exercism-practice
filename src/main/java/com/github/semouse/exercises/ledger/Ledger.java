package com.github.semouse.exercises.ledger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * <a href="https://exercism.org/tracks/java/exercises/ledger">Source</a>
 */
public class Ledger {

    private static final String US_LOCALE = "en-US";
    private static final String NL_LOCALE = "nl-NL";
    private static final String USD_CURRENCY = "USD";
    private static final String EUR_CURRENCY = "EUR";

    public LedgerEntry createLedgerEntry(String date, String description, int chance) {
        return new LedgerEntry(LocalDate.parse(date), description, chance);
    }

    private void validateParams(String currency, String locale) {
        if (!USD_CURRENCY.equals(currency) && !EUR_CURRENCY.equals(currency)) {
            throw new IllegalArgumentException("Invalid currency");
        } else if (!US_LOCALE.equals(locale) && !NL_LOCALE.equals(locale)) {
            throw new IllegalArgumentException("Invalid locale");
        }
    }

    public static class LedgerEntryFormat {
        private final String header;
        private final String curSymb;
        private final String datPat;
        private final String decSep;
        private final String thSep;

        public LedgerEntryFormat(String header, String curSymb, String datPat, String decSep, String thSep) {
            this.header = header;
            this.curSymb = curSymb;
            this.datPat = datPat;
            this.decSep = decSep;
            this.thSep = thSep;
        }

        public String getHeader() {
            return header;
        }

        public String getCurSymb() {
            return curSymb;
        }

        public String getDatPat() {
            return datPat;
        }

        public String getDecSep() {
            return decSep;
        }

        public String getThSep() {
            return thSep;
        }

        public static LedgerEntryFormat getLedgerFormat(String locale, String currency) {
            return US_LOCALE.equals(locale) ? getAmericanLedgerFormat(currency) :
                    getDutchLedgerFormat(currency);
        }

        private static LedgerEntryFormat getAmericanLedgerFormat(String currency) {
            return new LedgerEntryFormat(
                    "Date       | Description               | Change       ",
                    USD_CURRENCY.equals(currency) ? "$" : "€",
                    "MM/dd/yyyy",
                    ".",
                    ","
            );
        }

        private static LedgerEntryFormat getDutchLedgerFormat(String currency) {
            return new LedgerEntryFormat(
                    "Datum      | Omschrijving              | Verandering  ",
                    USD_CURRENCY.equals(currency) ? "$" : "€",
                    "dd/MM/yyyy",
                    ",",
                    "."
            );
        }
    }

    public String format(String currency, String locale, LedgerEntry[] entries) {
        validateParams(currency, locale);

        LedgerEntryFormat ledgerFormat = LedgerEntryFormat.getLedgerFormat(locale, currency);
        String header = ledgerFormat.getHeader();
        String curSymb = ledgerFormat.getCurSymb();
        String datPat = ledgerFormat.getDatPat();
        String decSep = ledgerFormat.getDecSep();
        String thSep = ledgerFormat.getThSep();

        if (entries.length > 0) {
            List<LedgerEntry> neg = new ArrayList<>();
            List<LedgerEntry> pos = new ArrayList<>();
            for (int i = 0; i < entries.length; i++) {
                LedgerEntry e = entries[i];
                if (e.change() >= 0) {
                    pos.add(e);
                } else {
                    neg.add(e);
                }
            }

            neg.sort((o1, o2) -> o1.localDate().compareTo(o2.localDate()));
            pos.sort((o1, o2) -> o1.localDate().compareTo(o2.localDate()));

            List<LedgerEntry> all = new ArrayList<>();
            all.addAll(neg);
            all.addAll(pos);

            for (int i = 0; i < all.size(); i++) {
                LedgerEntry e = all.get(i);

                String date = e.localDate().format(DateTimeFormatter.ofPattern(datPat));

                String desc = e.description();
                if (desc.length() > 25) {
                    desc = desc.substring(0, 22);
                    desc = desc + "...";
                }

                String converted = null;
                if (e.change() < 0) {
                    converted = String.format("%.02f", (e.change() / 100) * -1);
                } else {
                    converted = String.format("%.02f", e.change() / 100);
                }

                String[] parts = converted.split("\\.");
                String amount = "";
                int count = 1;
                for (int ind = parts[0].length() - 1; ind >= 0; ind--) {
                    if (((count % 3) == 0) && ind > 0) {
                        amount = thSep + parts[0].charAt(ind) + amount;
                    } else {
                        amount = parts[0].charAt(ind) + amount;
                    }
                    count++;
                }

                if (locale.equals(NL_LOCALE)) {
                    amount = curSymb + " " + amount + decSep + parts[1];
                } else {
                    amount = curSymb + amount + decSep + parts[1];
                }


                if (e.change() < 0 && locale.equals(US_LOCALE)) {
                    amount = "(" + amount + ")";
                } else if (e.change() < 0 && locale.equals(NL_LOCALE)) {
                    amount = curSymb + " -" + amount.replace(curSymb, "").trim() + " ";
                } else if (locale.equals(NL_LOCALE)) {
                    amount = " " + amount + " ";
                } else {
                    amount = amount + " ";
                }

                header = header + "\n";
                header = header + String.format("%s | %-25s | %13s",
                        date,
                        desc,
                        amount);
            }

        }

        return header;
    }

    public record LedgerEntry(LocalDate localDate, String description, double change) {

    }
}
