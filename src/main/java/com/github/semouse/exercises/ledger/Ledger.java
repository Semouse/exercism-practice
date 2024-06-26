package com.github.semouse.exercises.ledger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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

    public String format(String currency, String locale, LedgerEntry[] entries) {
        validateParams(currency, locale);

        LedgerEntryFormat ledgerFormat = LedgerEntryFormat.getLedgerFormat(locale, currency);
        String header = ledgerFormat.getHeader();
        String curSymb = ledgerFormat.getCurSymb();
        String decSep = ledgerFormat.getDecSep();

        if (entries.length == 0) {
            return header;
        }

        List<LedgerEntry> all = ledgerEntriesSortedByChangeDate(entries);

        StringBuilder builder = new StringBuilder(header);
        for (LedgerEntry entry : all) {
            String[] parts = getIntegerAndFractionalParts(entry);

            String amount = applyThousandsSeparator(parts[0], ledgerFormat);
            if (locale.equals(NL_LOCALE)) {
                amount = curSymb + " " + amount + decSep + parts[1];
            } else {
                amount = curSymb + amount + decSep + parts[1];
            }


            if (entry.change() < 0 && locale.equals(US_LOCALE)) {
                amount = "(" + amount + ")";
            } else if (entry.change() < 0 && locale.equals(NL_LOCALE)) {
                amount = curSymb + " -" + amount.replace(curSymb, "").trim() + " ";
            } else if (locale.equals(NL_LOCALE)) {
                amount = " " + amount + " ";
            } else {
                amount = amount + " ";
            }

            builder.append("\n");

            String date = formatLedgerDate(entry, ledgerFormat.getDatPat());
            String description = formatLedgerDescription(entry);
            builder.append(buildLedgerRow(date, description, amount));
        }


        return builder.toString();
    }

    private String buildLedgerRow(String date, String description, String amount) {
        return String.format("%s | %-25s | %13s", date, description, amount);
    }

    private String formatLedgerDate(LedgerEntry entry, String datePattern) {
        return entry.localDate().format(DateTimeFormatter.ofPattern(datePattern));
    }

    private String formatLedgerDescription(LedgerEntry entry) {
        String description = entry.description();
        if (description.length() > 25) {
            description = description.substring(0, 22);
            description = description + "...";
        }

        return description;
    }

    private String applyThousandsSeparator(String integerPart, LedgerEntryFormat ledgerEntryFormat) {
        StringBuilder amount = new StringBuilder();
        int count = 1;
        for (int ind = integerPart.length() - 1; ind >= 0; ind--) {
            if (((count % 3) == 0) && ind > 0) {
                amount.insert(0, ledgerEntryFormat.getThSep() + integerPart.charAt(ind));
            } else {
                amount.insert(0, integerPart.charAt(ind));
            }
            count++;
        }

        return amount.toString();
    }

    private String[] getIntegerAndFractionalParts(LedgerEntry entry) {
        String converted = entry.change() < 0 ? String.format("%.02f", (entry.change() / 100) * -1) :
                String.format("%.02f", entry.change() / 100);

        return converted.split("\\.");
    }

    private void validateParams(String currency, String locale) {
        if (!USD_CURRENCY.equals(currency) && !EUR_CURRENCY.equals(currency)) {
            throw new IllegalArgumentException("Invalid currency");
        } else if (!US_LOCALE.equals(locale) && !NL_LOCALE.equals(locale)) {
            throw new IllegalArgumentException("Invalid locale");
        }
    }

    private List<LedgerEntry> ledgerEntriesSortedByChangeDate(LedgerEntry[] entries) {
        Map<Boolean, List<LedgerEntry>> changeMap = Arrays.stream(entries)
                .collect(Collectors.partitioningBy(ledgerEntry -> ledgerEntry.change >= 0));
        changeMap.values()
                .forEach(value -> value.sort(Comparator.comparing(LedgerEntry::localDate)));

        return changeMap.values().stream()
                .flatMap(List::stream)
                .toList();
    }

    public record LedgerEntry(LocalDate localDate, String description, double change) {

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
}
