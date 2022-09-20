package com.javarush.task.task18.task1818;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Два в одном
*/

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String fileOutputName = reader.readLine();
    String fileSource1Name = reader.readLine();
    String fileSource2Name = reader.readLine();

    FileWriter writerWithoutAppend = new FileWriter(fileOutputName);
    FileWriter writerWithAppend = new FileWriter(fileOutputName, true);

    BufferedReader reader2 = new BufferedReader(new FileReader(fileSource1Name));
    BufferedReader reader3 = new BufferedReader(new FileReader(fileSource2Name));

    while (reader2.ready()) {
      writerWithoutAppend.write(reader2.read());
    }
    writerWithoutAppend.close();

    while (reader3.ready()) {
      writerWithAppend.write(reader3.read());
    }
    writerWithAppend.close();

    reader.close();
    reader2.close();
    reader3.close();
  }
}
