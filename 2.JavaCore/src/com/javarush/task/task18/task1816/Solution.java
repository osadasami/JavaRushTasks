package com.javarush.task.task18.task1816;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/* 
Английские буквы
*/

public class Solution {
  public static void main(String[] args) throws FileNotFoundException, IOException {
    if (args.length == 0) {
      return;
    }
    String filepath = args[0];
    int letters = 0;
    try (
        BufferedReader stream = new BufferedReader(new FileReader(filepath));) {

      while (stream.ready()) {
        String letter = String.valueOf((char) stream.read());
        boolean isLetter = Pattern.compile("[a-zA-Z]").matcher(letter).matches();
        if (isLetter) {
          letters++;
        }
      }

      System.out.println(letters);
    }

  }
}
