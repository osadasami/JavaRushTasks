package com.javarush.task.task18.task1817;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
  public static void main(String[] args) throws FileNotFoundException, IOException {
    if (args.length == 0) {
      return;
    }

    int chars = 0;
    int spaces = 0;

    String filename = args[0];
    try (
        BufferedReader stream = new BufferedReader(new FileReader(filename))) {

      while (stream.ready()) {
        chars++;
        Character ch = (char) stream.read();
        if (Character.isWhitespace(ch)) {
          spaces++;
        }
      }
    }

    float result = (float) spaces / chars * 100;

    System.out.println(String.format("%.2f", result));
  }
}
