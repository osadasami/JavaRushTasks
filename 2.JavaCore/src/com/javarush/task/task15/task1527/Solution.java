package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String url = reader.readLine();
    String queryString = url.split("\\?")[1];
    String[] params = queryString.split("\\&");

    for (String param : params) {
      String[] keyValue = param.split("\\=");
      String key = keyValue[0];
      System.out.print(key + " ");
    }

    System.out.println();

    for (String param : params) {
      String[] keyValue = param.split("\\=");
      String key = keyValue[0];
      if (key.equals("obj")) {
        String value = keyValue[1];
        try {
          double n = Double.parseDouble(value);
          alert(n);
        } catch (Exception e) {
          alert(value);
        }
      }
    }

  }

  public static void alert(double value) {
    System.out.println("double: " + value);
  }

  public static void alert(String value) {
    System.out.println("String: " + value);
  }
}
