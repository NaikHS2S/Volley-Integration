package com.telstra.imagelist.common.util;

public class TxStringUtils {

  // Used to validate a String an empty or null
    public boolean isStringDataAValid(String stringValue) {
        return stringValue != null && !stringValue.equalsIgnoreCase("null") && !stringValue.trim().equalsIgnoreCase("");
    }

}
