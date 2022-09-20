package com.javarush.task.task18.task1821;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* 
Встречаемость символов
*/

public class Solution {
  public static void main(String[] args) throws IOException {
    if (args.length == 0)
      return;

    HashMap<Character, Integer> counts = new HashMap();

    String filename = args[0];
    BufferedReader fileReader = new BufferedReader(new FileReader(filename));

    while (fileReader.ready()) {
      Character ch = (char) fileReader.read();

      if (counts.containsKey(ch)) {
        counts.put(ch, counts.get(ch) + 1);
      } else {
        counts.put(ch, 1);
      }
    }

    counts
        .entrySet()
        .stream()
        .sorted(
            Map.Entry.comparingByKey((a, b) -> {
              return (int) a - (int) b;
            }))
        .forEach((Map.Entry<Character, Integer> item) -> {
          System.out.println(item.getKey() + " " + item.getValue());
        });

    fileReader.close();
  }
}
