package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String fileName = reader.readLine();

    int minByte = 255;

    try (
        FileInputStream stream = new FileInputStream(fileName)) {
      while (stream.available() > 0) {
        int currentByte = stream.read();
        if (currentByte < minByte) {
          minByte = currentByte;
        }
      }
    }

    System.out.println(minByte);
  }
}
