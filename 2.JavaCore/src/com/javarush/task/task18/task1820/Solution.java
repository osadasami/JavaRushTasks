package com.javarush.task.task18.task1820;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/* 
Округление чисел
*/

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String filename1 = reader.readLine();
    String filename2 = reader.readLine();

    reader.close();

    BufferedReader file1Reader = new BufferedReader(new FileReader(filename1));
    String file1Content = file1Reader.lines().collect(Collectors.joining());
    file1Reader.close();
    String[] nums = file1Content.split(" ");

    FileWriter file2Writer = new FileWriter(filename2);

    for (String n : nums) {
      Float parsedN = Float.parseFloat(n);
      int roundedN = Math.round(parsedN);
      file2Writer.write(roundedN + " ");
    }

    file2Writer.close();
  }
}
