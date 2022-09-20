package com.javarush.task.task18.task1824;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Файлы и исключения
*/

public class Solution {
  public static void main(String[] args) throws IOException {
    try (
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {

      while (true) {
        String filename = reader.readLine();

        try (
            BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {

        } catch (FileNotFoundException e) {
          System.out.println(filename);
          break;
        }
      }
    }

  }
}
