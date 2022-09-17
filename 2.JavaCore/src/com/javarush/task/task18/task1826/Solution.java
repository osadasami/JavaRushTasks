package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
  public static void main(String[] args) throws IOException {
    if (args[0].equals("-e")) {
      encode(args[1], args[2]);
    } else if (args[0].equals("-d")) {
      decode(args[1], args[2]);
    }
  }

  public static void encode(String inputFileName, String outputFileName) throws IOException {
    try (
        FileInputStream fileIn = new FileInputStream(inputFileName);
        FileOutputStream fileOut = new FileOutputStream(outputFileName);) {

      while (fileIn.available() > 0) {
        int newByte = (fileIn.read() + 1) % 255;
        fileOut.write(newByte);
      }
    }
  }

  public static void decode(String inputFileName, String outputFileName) throws FileNotFoundException, IOException {
    try (
        FileInputStream fileIn = new FileInputStream(inputFileName);
        FileOutputStream fileOut = new FileOutputStream(outputFileName);) {

      while (fileIn.available() > 0) {
        int byteValue = fileIn.read();
        System.out.println(byteValue);
        int newByte = (byteValue - 1) < 0 ? 255 : byteValue - 1;
        fileOut.write(newByte);
      }
    }
  }

}
