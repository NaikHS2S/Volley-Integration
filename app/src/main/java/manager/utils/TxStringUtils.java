package manager.utils;

/**
 * Created by computer on 2/18/2016.
 */
public class TxStringUtils {

  // Used to validate a String an empty or null
    public boolean isStringDataAValid(String stringValue) {
        return stringValue != null && !stringValue.equalsIgnoreCase("null") && !stringValue.trim().equalsIgnoreCase("");
    }

}
