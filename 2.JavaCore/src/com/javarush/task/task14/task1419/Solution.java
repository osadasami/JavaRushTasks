package com.javarush.task.task14.task1419;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
  public static List<Exception> exceptions = new ArrayList<Exception>();

  public static void main(String[] args) {
    initExceptions();

    for (Exception exception : exceptions) {
      System.out.println(exception);
    }
  }

  private static void initExceptions() { // the first exception
    try {
      float i = 1 / 0;

    } catch (Exception e) {
      exceptions.add(e);
    }

    try {
      int[] arr = new int[] {};
      System.out.println(arr[1]);
    } catch (Exception e) {
      exceptions.add(e);
    }

    try {
      new FileReader("randomfile.txt");
    } catch (Exception e) {
      exceptions.add(e);
    }

    try {
      String.format("%d", "0");
    } catch (Exception e) {
      exceptions.add(e);
    }

    try {
      Class.forName("qwe");
    } catch (Exception e) {
      exceptions.add(e);
    }

    try {
      Object x = new Integer(0);
      System.out.println((String) x);
    } catch (Exception e) {
      exceptions.add(e);
    }

    try {
      System.out.println("q".charAt(1));
    } catch (Exception e) {
      exceptions.add(e);
    }

    try {
      int[] arr = new int[-1];
    } catch (Exception e) {
      exceptions.add(e);
    }

    try {
      List<Integer> arr = null;
      arr.add(1);
    } catch (Exception e) {
      exceptions.add(e);
    }

    try {
      Object x[] = new String[3];
      x[0] = new Integer(0);
    } catch (Exception e) {
      exceptions.add(e);
    }

  }
}
