package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/* 
Нити и байты
*/

public class Solution {
  public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String fileName;
    while (!(fileName = reader.readLine()).startsWith("exit")) {
      new ReadThread(fileName).start();
    }

  }

  public static class ReadThread extends Thread {
    String fileName;

    public ReadThread(String fileName) throws IOException {
      this.fileName = fileName;
    }

    @Override
    public void run() {
      try (
          BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {

        HashMap<Integer, Integer> byteCounts = new HashMap<>();

        while (fileReader.ready()) {
          int currentByte = fileReader.read();
          if (byteCounts.containsKey(currentByte)) {
            byteCounts.put(currentByte, byteCounts.get(currentByte) + 1);
          } else {
            byteCounts.put(currentByte, 1);
          }
        }

        Entry<Integer, Integer> item = byteCounts
            .entrySet()
            .stream()
            .sorted(
                Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toList())
            .get(0);

        resultMap.put(fileName, item.getKey());

      } catch (IOException e) {
        throw new RuntimeException(e);
      }

    }
  }
}
