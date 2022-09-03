package com.javarush.task.pro.task16.task1604;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
День недели рождения твоего
*/

public class Solution {

  static Calendar birthDate = new GregorianCalendar(1996, 5, 14);

  public static void main(String[] args) {
    System.out.println(getDayOfWeek(birthDate));
  }

  static String getDayOfWeek(Calendar calendar) {
    return new SimpleDateFormat("EEEE", new Locale("ru")).format(calendar.getTime());
  }
}