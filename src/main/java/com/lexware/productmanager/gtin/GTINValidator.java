package com.lexware.productmanager.gtin;

public class GTINValidator {
    public static boolean isValidGTIN8(String gtin) {
        String regex = "[0-9]{8}$";
        return gtin.matches(regex);
    }

    public static boolean isValidGTIN12(String gtin) {
        String regex = "[0-9]{12}$";
        return gtin.matches(regex);
    }

    public static boolean isValidGTIN13(String gtin) {
        String regex = "[0-9]{13}$";
        return gtin.matches(regex);
    }

    public static boolean isValidGTIN(String gtin) {
        switch (gtin.length()) {
            case 8:
                return isValidGTIN8(gtin);
            case 12:
                return isValidGTIN12(gtin);
            case 13:
                return isValidGTIN13(gtin);
            default:
                return false;
        }
    }

}