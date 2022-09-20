package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/* 
Поиск данных внутри файла
*/

public class Solution {
  public static void main(String[] args) throws IOException {
    if (args.length == 0)
      return;

    String id = args[0];

    try (
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))) {

      System.out.println(
          fileReader
              .lines()
              .filter(line -> line.split(" ")[0].equals(id))
              .collect(Collectors.toList())
              .get(0));
    }
  }
}
