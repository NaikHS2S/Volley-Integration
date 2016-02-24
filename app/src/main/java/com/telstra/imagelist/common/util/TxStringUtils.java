package com.telstra.imagelist.common.util;

public class TxStringUtils {

    /**
     * @param stringValue
     * @return false if string a null or contains empty or null as value
     */
    public static boolean isStringDataAValid(String stringValue) {
        return stringValue != null && !stringValue.equalsIgnoreCase("null") && !stringValue.trim().equalsIgnoreCase("");
    }

}
