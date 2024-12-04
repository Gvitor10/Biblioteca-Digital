package myApp.literalura.model;

import myApp.literalura.service.ColorFont;

public class BigTitle {
    private static String title = " _       _  _                       _\n" +
            "| |     (_)| |                     | |\n" +
            "| |      _ | |_   ___  _ __   __ _ | | _   _  _ __   __ _\n" +
            "| |     | || __| / _ \\| '__| / _` || || | | || '__| / _` |\n" +
            "| |____ | || |_ |  __/| |   | (_| || || |_| || |   | (_| |\n" +
            "|______||_| \\__| \\___||_|    \\__,_||_| \\__,_||_|    \\__,_|\n" +
            "\n" +
            "\n";

    public static void showBigTitle() {
        System.out.println(ColorFont.BoldColoredText(ColorFont.ANSI_BLUE, title));
    }
}
