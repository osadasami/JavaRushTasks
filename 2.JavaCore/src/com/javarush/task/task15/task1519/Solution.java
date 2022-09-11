package com.javarush.task.task15.task1519;

import java.io.IOException;
import java.util.Scanner;

/* 
Разные методы для разных типов
*/

public class Solution {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    String input;

    while (!(input = scanner.nextLine()).equals("exit")) {
      try {

        if (input.contains(".")) {
          double n = Double.parseDouble(input);
          print(n);
        } else {
          int n = Integer.parseInt(input);
          if (n > 0 && n < 128) {
            print((short) n);
          } else if (n <= 0 || n >= 128) {
            print((Integer) n);
          }
        }
      } catch (Exception e) {
        print(input);
      }
    }

    scanner.close();
  }

  public static void print(Double value) {
    System.out.println("Это тип Double, значение " + value);
  }

  public static void print(String value) {
    System.out.println("Это тип String, значение " + value);
  }

  public static void print(short value) {
    System.out.println("Это тип short, значение " + value);
  }

  public static void print(Integer value) {
    System.out.println("Это тип Integer, значение " + value);
  }
}
