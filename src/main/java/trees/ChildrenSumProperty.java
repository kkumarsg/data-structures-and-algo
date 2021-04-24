package trees;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ChildrenSumProperty {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

    public static void main(String[] args) {
        Date date = timeMultipleReadableToTimestamp("2021-04-16T15:09:12+05:30");
        String dateString = convertDateToStandard("2021-04-16T15:09:12+05:30", dateFormat);
        Date date1 = addDays(date, 10);

        Map<String, String> map = new HashMap<>();
        map.put("customer_promise_date", "null");
        map.put("dispatchedDate", "\"2021-04-16T15:09:12+05:30\"");
        convertDateToStandard("2021-04-16T15:09:12+05:30", dateFormat);
    }

    private static void setCustomerPromiseDate(Map<String, String> map) {
        // Will return null if empty
        Date cpd = convertDateToSpecificFormat(map.get("customer_promise_date"));
        if (cpd == null || cpd.getTime() < System.currentTimeMillis()) {
            Date defaultBaseDate = convertDateToSpecificFormat(trimQuotesAtExtremes(map.get("dispatchedDate")));
            if (defaultBaseDate != null) {
                cpd = addDays(defaultBaseDate, 10);
            }
        }
        String customerPromiseDate = dateFormat.format(cpd);
        map.put("customerPromiseDate", "\"" + customerPromiseDate + "\"");
    }

    private static String trimQuotesAtExtremes(String str) {
        return stringStartsAndEndsWithQuotes(str) ? str.substring(1, str.length() - 1) : str;
    }

    private static boolean stringStartsAndEndsWithQuotes(String str) {
        if (str == null) {
            return false;
        } else {
            return str.startsWith("\"") && str.endsWith("'");
        }
    }

    public static Date convertDateToSpecificFormat(String str) {
        if(str!=null) {
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                return format.parse(str);
            } catch (ParseException e) {
            }
        }
        return null;
    }

    // 2021-02-03 => 2nd mar, 3rd feb 2021
    public static String convertDateToStandard(String inputString, DateFormat dateFormat){
        String[] DATE_FORMATS = {"dd-MM-yyyy", "dd/MM/yyyy","dd/MM/yyyy","yyyy-MM-dd", "dd/MM/yyyy HH:mm:ss", "dd-MM-yyyy hh:mma", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss a"};
        for (String formatString : DATE_FORMATS) {
            SimpleDateFormat format = new SimpleDateFormat(formatString);
            try {
                Date date = format.parse(inputString);
                return dateFormat.format(date);
            } catch (ParseException e) {

            }
        }
        return null;
    }

    public static Date addDays(Date date, int days) {
        //2021-04-16T15:09:12+05:30
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    public static Date timeMultipleReadableToTimestamp(String str) {
        String[] DATE_FORMATS = {"dd-MM-yyyy", "dd/MM/yyyy","dd/MM/yyyy","yyyy-MM-dd", "dd/MM/yyyy HH:mm:ss", "dd-MM-yyyy hh:mma", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss a"};
        for (String formatString : DATE_FORMATS) {
            try {
                SimpleDateFormat format = new SimpleDateFormat(formatString);
                return format.parse(str);
            } catch (ParseException e) {
            }
        }
        return null;
    }




    public boolean checkForChildrenSum(TreeNode node){
        if(node==null){
            return true;
        }
        int childrenSum =
                (node.getLeft()!=null ? node.getLeft().getKey() : 0)
                + (node.getRight()!=null ? node.getRight().getKey() : 0);
        if(node.getKey()!=childrenSum){
            return false;
        }
        return checkForChildrenSum(node.getLeft()) && checkForChildrenSum(node.getRight());
    }
}
