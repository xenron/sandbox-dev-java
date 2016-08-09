package com.baselogic.chapter05.utils

import groovy.util.GroovyTestCase
import java.util.Calendar
import java.text.SimpleDateFormat

class DateUtilitiesTest extends GroovyTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    public void testGetYesterdayDate() {
        Calendar calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -1)
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd")
        String expected = format.format(calendar.getTime());

        String result = DateUtilities.getYesterdayDate()
        println(result)
        assertEquals(expected, result)
    }

    void testGetUnixDayFromDate() {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = (java.util.Date) formatter.parse("2011-03-03 23:59:59");
        assertEquals(DateUtilities.getUnixDayFromDate(date), 15037);
    }

    void testGetDateDifferenceInDays() {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date1 = (java.util.Date) formatter.parse("2011-03-03 23:59:59");
        java.util.Date date2 = (java.util.Date) formatter.parse("2011-03-10 23:59:59");
        assertEquals(DateUtilities.getDateDifferenceInDays(date1, date2), 7);
    }
} // The End...