package com.javarush.task.task13.task1319;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
  public static void main(String[] args) {
    try (
        Scanner scanner = new Scanner(System.in);
        FileWriter fw = new FileWriter(scanner.nextLine());
        BufferedWriter bw = new BufferedWriter(fw);) {

      String userInput = "";
      List<String> strings = new ArrayList<>();

      while (!userInput.equals("exit")) {
        userInput = scanner.nextLine();
        strings.add(userInput);
      }

      for (String str : strings) {
        bw.write(str);
        bw.newLine();
      }
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}
