package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String fileName = br.readLine();
    Scanner scanner = new Scanner(new FileInputStream(fileName));
    List<Integer> data = new ArrayList<>();

    while (scanner.hasNext()) {
      int n = scanner.nextInt();
      if (n % 2 == 0)
        data.add(n);
    }

    Collections.sort(data);

    for (int n : data) {
      System.out.println(n);
    }

    scanner.close();
  }
}
