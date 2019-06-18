package by.viktor.exchangerates.presenter;

import android.annotation.SuppressLint;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import by.viktor.exchangerates.views.ViewDate;

public class GetDateDey implements ViewDate {
    public String dateToday() {
        @SuppressLint("SimpleDateFormat") DateFormat df =
                new SimpleDateFormat("MM.dd.yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        return date;


    }

    public String dateTomorrow() {
        @SuppressLint("SimpleDateFormat") DateFormat dateFormat =
                new SimpleDateFormat("MM.dd.yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String date = dateFormat.format(cal.getTime());
        return date;

    }

    public String dateYesterday() {
        @SuppressLint("SimpleDateFormat") DateFormat dateFormat =
                new SimpleDateFormat("MM.dd.yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String date = dateFormat.format(cal.getTime());
        return date;

    }
}
