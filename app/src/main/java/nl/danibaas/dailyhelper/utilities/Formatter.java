package nl.danibaas.dailyhelper.utilities;

public class Formatter {

    /**
     * Formats double to a normal amount as seen in your own bank account (2 decimals).
     * If the number does not contain a formattable part, this method will throw a NullPointer.
     * @param amount Amount to format
     * @return returns formatted amount
     */
    public static String formatDouble(double amount) {
        String total = amount + "";
        String[] split = total.split("\\.");
        if (split[1].length() < 2) throw new NullPointerException();
        return split[0] + "." + split[1].substring(0, 2);
    }
}
