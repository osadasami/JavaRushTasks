package com.javarush.task.pro.task16.task1601;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

  static Date birthDate = new Date(96, 05, 14);

  public static void main(String[] args) {
    System.out.println(getDayOfWeek(birthDate));
  }

  static String getDayOfWeek(Date date) {
    return new SimpleDateFormat("EEEE", new Locale("ru")).format(date);
  }
}
