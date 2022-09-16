package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/* 
Сортировка байт
*/

public class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    try (
        FileInputStream stream = new FileInputStream(reader.readLine());) {
      Set<Integer> bytes = new TreeSet<Integer>();

      while (stream.available() > 0) {
        bytes.add(stream.read());
      }

      List<Integer> bytessorted = bytes.stream().sorted((a, b) -> a - b).collect(Collectors.toList());

      for (int item : bytessorted) {
        System.out.print(item + " ");
      }
    }
  }
}
