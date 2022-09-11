package com.javarush.task.task15.task1529;

import java.util.Scanner;

/* 
Осваивание статического блока
*/

public class Solution {
  public static void main(String[] args) {

  }

  static {
    reset();
  }

  public static CanFly result;

  public static void reset() {
    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.nextLine();

    if (userInput.equals("helicopter")) {
      result = new Helicopter();
    }

    if (userInput.equals("plane")) {
      int passangers = scanner.nextInt();
      result = new Plane(passangers);
    }
    scanner.close();
  }
}
