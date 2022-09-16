package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые частые байты
*/

public class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String filepath = reader.readLine();

    try (FileInputStream stream = new FileInputStream(filepath)) {
      int[] bytes = new int[256];

      while (stream.available() > 0) {
        bytes[stream.read()] += 1;
      }

      int maxCount = 0;

      for (int byteCount : bytes) {
        if (byteCount > maxCount)
          maxCount = byteCount;
      }

      ArrayList<Integer> result = new ArrayList<>();

      for (int i = 0; i < bytes.length; i++) {
        if (bytes[i] == maxCount)
          result.add(i);
      }

      for (int item : result) {
        System.out.print(item + " ");
      }
    }
  }
}
