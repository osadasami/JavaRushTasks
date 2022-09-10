package com.javarush.task.task14.task1420;

import java.util.Scanner;

/* 
НОД
*/

public class Solution {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd(a, b));
  }

  public static int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }
}
