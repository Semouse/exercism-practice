package com.github.semouse.exercises.secrethandshake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandshakeCalculator {
    public List<Signal> calculateHandshake(int number) {
        String code = String.format("%5s", Integer.toBinaryString(number)).replaceAll(" ", "0");
        return convertCodeToHandshake(code);
    }

    private List<Signal> convertCodeToHandshake(String code) {
        List<Signal> handshake = new ArrayList<>();
        int i = code.length() - 1;
        int j = Signal.values().length;
        for (Signal signal : Signal.values()) {
            String mask = switch (signal) {
                case WINK -> "00001";
                case DOUBLE_BLINK -> "00010";
                case CLOSE_YOUR_EYES -> "00100";
                case JUMP -> "01000";
            };
            if (code.charAt(i) == mask.charAt(j) && code.charAt(i) == '1') {
                handshake.add(signal);
            }
            i--;
            j--;
        }

        if (code.charAt(i) == '1') {
            Collections.reverse(handshake);
        }

        return handshake;
    }
}
