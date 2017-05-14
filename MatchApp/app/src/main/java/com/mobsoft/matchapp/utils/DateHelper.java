package com.mobsoft.matchapp.utils;

import android.widget.SimpleAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by varsi on 2017. 05. 14..
 */

public class DateHelper {
    public static class DateParseException extends RuntimeException {

    }

    public static String getDate(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd.");
        return df.format(date);
    }

    public static String getTime(Date date) {
        DateFormat df = new SimpleDateFormat("HH:mm");
        return df.format(date);
    }

    public static Date parseDate(String date, String time) {
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd. HH:mm");
        try {
            return df.parse(date + " " + time);
        } catch (Exception e) {
            System.err.println(date + " " + time + " " + e);
            throw new DateParseException();
        }
    }

    public static String formatDate(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd. HH:mm");
        return df.format(date);
    }
}
