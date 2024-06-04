package Helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDBToString {
    public static String DateToString(Date dateDB) {
        Date date = dateDB;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = formatter.format(date);
        return strDate;
    }
}

