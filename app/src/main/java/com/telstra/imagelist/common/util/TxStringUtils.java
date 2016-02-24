package com.telstra.imagelist.common.util;

public class TxStringUtils {

    /**
     * @param stringValue argument to this method
     * @return false if string a null , contains empty data or null as value
     */
    public static boolean isStringDataAValid(String stringValue) {
        return stringValue != null && !stringValue.equalsIgnoreCase("null") && !stringValue.trim().equalsIgnoreCase("");
    }

}
