package com.javarush.task.task18.task1819;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/* 
Объединение файлов
*/

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String filename1 = reader.readLine();
    String filename2 = reader.readLine();

    reader.close();

    BufferedReader file1Reader = new BufferedReader(new FileReader(filename1));
    String file1Lines = file1Reader.lines().collect(Collectors.joining());

    file1Reader.close();

    BufferedReader file2Reader = new BufferedReader(new FileReader(filename2));
    String file2Lines = file2Reader.lines().collect(Collectors.joining());

    file2Reader.close();

    FileWriter file1Writer = new FileWriter(filename1);

    file1Writer.write(file2Lines);
    file1Writer.write(file1Lines);

    file1Writer.close();
  }
}
