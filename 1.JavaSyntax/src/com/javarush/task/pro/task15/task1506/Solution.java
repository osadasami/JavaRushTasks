package com.javarush.task.pro.task15.task1506;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
  public static void main(String[] args) {
    try (
        Scanner scanner = new Scanner(System.in);) {
      List<String> lines = Files.readAllLines(Path.of(scanner.nextLine()));
      for (String line : lines) {
        String newLine = line.replaceAll("(\\s|\\.|\\,)", "");
        System.out.println(newLine);
      }
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}
