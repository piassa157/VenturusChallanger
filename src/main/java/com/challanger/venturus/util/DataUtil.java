package com.challanger.venturus.util;


import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

@Component
public class DataUtil {

    public DataUtil() {

    }
    public static String generatedValidaty(Date date1, Date date2) throws ParseException {
        if(date2==null || date1==null){
            return "-";
        }
        Calendar m_calendar=Calendar.getInstance();
        m_calendar.setTime(date1);
        int nMonth1=12*m_calendar.get(Calendar.YEAR)+m_calendar.get(Calendar.MONTH);
        m_calendar.setTime(date2);
        int nMonth2=12*m_calendar.get(Calendar.YEAR)+m_calendar.get(Calendar.MONTH);
        int result = Math.abs(nMonth2-nMonth1);

        String months = "" + result + " Months";

        return months;
    }

}
