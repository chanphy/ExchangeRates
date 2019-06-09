package by.viktor.exchangerates.presenter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateVariettyDey {
    public String dateDate() {
        DateFormat df =
                new SimpleDateFormat("MM.dd.yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        return date;


    }

    public String dateTomorrow() {
        DateFormat dateFormat =
                new SimpleDateFormat("MM.dd.yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +1);
        String date = dateFormat.format(cal.getTime());
        return date;

    }

    public String dateYesterday() {
        DateFormat dateFormat =
                new SimpleDateFormat("MM.dd.yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String date = dateFormat.format(cal.getTime());
        return date;

    }
}
