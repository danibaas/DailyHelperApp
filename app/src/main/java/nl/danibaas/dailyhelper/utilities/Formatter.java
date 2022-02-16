package nl.danibaas.dailyhelper.utilities;

public class Formatter {

    /**
     * Formats double to a normal amount as seen in your own bank account (2 decimals).
     * If the number does not contain a formattable part, this method will throw a MissingFormatWidthException.
     *
     * @param amount Amount to format
     * @return returns formatted amount
     */
    public static String formatDouble(double amount) {
        String total = amount + "";
        String[] split = total.split("\\.");
        StringBuilder complete = new StringBuilder();
        StringBuilder decimals = new StringBuilder();
        if (split[1].length() < 2) {
            decimals.append(split[1]).append("0");
        } else {
            decimals.append(split[1].substring(0, 2));
        }
        complete.append(split[0]).append(".").append(decimals.toString());
        return complete.toString();
    }

    /**
     * Checks if the entered amount can be formatted.
     *
     * @param amount Value to check.
     * @return true if formattable, otherwise false.
     */
    public static boolean canFormat(double amount) {
        String total = amount + "";
        String[] split = total.split("\\.");
        try {
            int i = Integer.parseInt(split[0]);
            int j = Integer.parseInt(split[1]);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static double parseDouble(String parse) {
        double parsed = 0;
        String money = makeMonetary(parse);
        try {
            parsed = Double.parseDouble(money);
        } catch (NumberFormatException e) {
            CustomToast.NOT_A_NUMBER.showToast();
        }
        return parsed;
    }

    public static boolean isParsable(String parse) {
        String money = makeMonetary(parse);
        try {
            Double.parseDouble(money);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Replaces a comma with a point so we can use this as a monetary value
     * @param money String to make monitary
     * @return String with a point
     */
    public static String makeMonetary(String money) {
        return money.replace(',', '.');
    }
}
