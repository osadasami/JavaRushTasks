package com.javarush.task.pro.task14.task1414;

/* 
Готовим коктейли
*/

public class Solution {

  public static final String OUTPUT_FORMAT = "Метод %s вызван из строки %d класса %s в файле %s.\n";

  public static void main(String[] args) {
    makeScrewdriver();
  }

  public static void printStackTrace(StackTraceElement[] stackTrace) {
    for (StackTraceElement el : stackTrace) {
      String method = el.getMethodName();
      int line = el.getLineNumber();
      String className = el.getClassName();
      String fileName = el.getFileName();

      System.out.println(
          String.format("Метод %s вызван из строки %d класса %s в файле %s.", method, line, className, fileName));
    }

  }

  static void makeScrewdriver() {
    addJuice();
  }

  static void addJuice() {
    addVodka();
  }

  static void addVodka() {
    printStackTrace(Thread.currentThread().getStackTrace());
  }
}
