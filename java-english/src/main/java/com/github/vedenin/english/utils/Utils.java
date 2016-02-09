package com.github.vedenin.english.utils;

/**
 * Created by vedenin on 09.02.16.
 */
public class Utils {

    public static void println() {
        System.out.println();
    }

    public static void println(String title) {
        System.out.println(title);
    }

    public static void println(String title, String text) {
        String trimmedText = text.trim();
        String withFirstUpperCaseChar = Character.toUpperCase(trimmedText.charAt(0)) + trimmedText.substring(1);
        System.out.println(title + ": " + withFirstUpperCaseChar.replaceAll("  ", " "));
    }
}
