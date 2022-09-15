package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/* 
Транзакционность
*/

public class Solution {
  public static List<String> allLines = new ArrayList<String>();
  public static List<String> forRemoveLines = new ArrayList<String>();

  public static void main(String[] args) throws FileNotFoundException, CorruptedDataException {
    Scanner scanner = new Scanner(System.in);
    BufferedReader file1 = new BufferedReader(new FileReader(scanner.nextLine()));
    BufferedReader file2 = new BufferedReader(new FileReader(scanner.nextLine()));

    scanner.close();

    file1.lines().forEach((String line) -> allLines.add(line));
    file2.lines().forEach((String line) -> forRemoveLines.add(line));

    Solution solution = new Solution();
    solution.joinData();
  }

  public void joinData() throws CorruptedDataException, FileNotFoundException {

    boolean allMatch = forRemoveLines.stream().allMatch((String line) -> {
      return allLines.contains(line);
    });

    if (allMatch) {
      allLines = allLines.stream().filter((String line) -> !forRemoveLines.contains(line)).collect(Collectors.toList());
    } else {
      allLines.clear();
      throw new CorruptedDataException();
    }

  }
}
