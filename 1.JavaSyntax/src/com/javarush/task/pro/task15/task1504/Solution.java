package com.javarush.task.pro.task15.task1504;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
  public static void main(String[] args) {
    try (
        Scanner userInput = new Scanner(System.in);
        InputStream input = Files.newInputStream(Path.of(userInput.nextLine()));
        OutputStream output = Files.newOutputStream(Path.of(userInput.nextLine()));) {

      byte[] inputBytes = input.readAllBytes();
      byte[] outputBytes = new byte[inputBytes.length];

      for (int i = 0; i < inputBytes.length; i += 2) {
        if (i < inputBytes.length - 1) {
          outputBytes[i] = inputBytes[i + 1];
          outputBytes[i + 1] = inputBytes[i];
        } else {
          outputBytes[i] = inputBytes[i];
        }
      }

      output.write(outputBytes);

    } catch (IOException e) {
      System.out.println(e);
    }
  }
}