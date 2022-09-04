package com.javarush.task.pro.task16.task1612;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* 
Синтезируем LocalDateTime
*/

public class Solution {

  public static void main(String[] args) {
    Map<LocalDate, List<LocalTime>> dateMap = DateTimeGenerator.generateDateMap();
    printCollection(dateMap.entrySet());

    Set<LocalDateTime> dateSet = convert(dateMap);
    printCollection(dateSet);
  }

  static Set<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> sourceMap) {
    Set<LocalDateTime> dataSet = new HashSet<>();

    for (Map.Entry<LocalDate, List<LocalTime>> entry : sourceMap.entrySet()) {
      for (LocalTime time : entry.getValue()) {
        LocalDateTime datetime = LocalDateTime.of(entry.getKey(), time);
        dataSet.add(datetime);
      }
    }

    return dataSet;
  }

  static void printCollection(Collection<?> collection) {
    System.out.println("-----------------------------------------------------");
    collection.forEach(System.out::println);
  }
}
