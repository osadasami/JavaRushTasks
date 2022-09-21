package com.javarush.task.task18.task1825;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Собираем файл
*/

public class Solution {
  public static void main(String[] args) throws IOException {
    List<String> fileNames = new ArrayList<>();

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String fileName;
    while (!(fileName = reader.readLine()).equals("end")) {
      fileNames.add(fileName);
    }

    fileNames = fileNames.stream().sorted().collect(Collectors.toList());
    String[] outFileParts = fileNames.get(0).split("\\.");
    String outFileName = outFileParts[0] + "." + outFileParts[1];

    System.out.println(outFileName);

    BufferedWriter fileOutStream = new BufferedWriter(new FileWriter(outFileName));

    for (String file : fileNames) {
      try (
          BufferedInputStream fileReader = new BufferedInputStream(new FileInputStream(file))) {

        while (fileReader.available() > 0) {
          fileOutStream.write(fileReader.read());
        }

      }
    }
    fileOutStream.close();
  }
}
