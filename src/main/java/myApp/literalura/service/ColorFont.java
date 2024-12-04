package myApp.literalura.service;

public class ColorFont {
    public final static String ANSI_RESET = "\u001B[0m";
    public final static String ANSI_RED = "\u001B[31m";
    public final static String ANSI_ORANGE = "\033[38;5;208m";
    public final static String ANSI_GREEN = "\u001B[32m";
    public final static String ANSI_YELLOW = "\u001B[33m";
    public final static String ANSI_BLUE = "\u001B[34m";
    public final static String ANSI_PURPLE = "\033[38;5;129m";
    public final static String ANSI_GRAY = "\033[90m";

    public static String colorText(String color, String text) {
        return color + text + ANSI_RESET;
    }

    public static String boldText(String text) {
        return "\033[1m" + text + "\033[0m";
    }

    public static String BoldColoredText(String color, String text) {
        return "\033[1m" + color + text + "\033[0m";
    }
}
