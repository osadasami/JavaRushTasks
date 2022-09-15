package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/* 
CRUD
*/

public class Solution {
  public volatile static List<Person> allPeople = new ArrayList<Person>();

  static {
    allPeople.add(Person.createMale("Иванов Иван", new Date())); // сегодня родился id=0
    allPeople.add(Person.createMale("Петров Петр", new Date())); // сегодня родился id=1
  }

  public static void add(String[] args) throws ParseException {
    List<List<String>> chunks = splitToChunks(args, 3);

    for (List<String> chunk : chunks) {
      String name = chunk.get(0);
      String sex = chunk.get(1);
      Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(chunk.get(2));
      Person person;

      if (sex.equals("м")) {
        person = Person.createMale(name, birthDate);
      } else {
        person = Person.createFemale(name, birthDate);
      }

      allPeople.add(person);
      System.out.println(allPeople.size() - 1);
    }
  }

  public static void list(String[] args) {
    List<List<String>> chunks = splitToChunks(args, 1);

    for (List<String> chunk : chunks) {
      int id = Integer.parseInt(chunk.get(0));
      Person person = allPeople.get(id);
      String birthDate = new SimpleDateFormat("dd-MMM-yyyy").format(person.getBirthDate());
      String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
      System.out.println(String.format("%s %s %s", person.getName(), sex,
          birthDate));
    }
  }

  public static void update(String[] args) throws ParseException {
    List<List<String>> chunks = splitToChunks(args, 4);

    for (List<String> chunk : chunks) {
      int id = Integer.parseInt(chunk.get(0));
      String name = chunk.get(1);
      Sex sex = chunk.get(2).equals("м") ? Sex.MALE : Sex.FEMALE;
      Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(chunk.get(3));
      Person person;

      if (sex.equals(Sex.MALE)) {
        person = Person.createMale(name, birthDate);
      } else {
        person = Person.createFemale(name, birthDate);
      }

      allPeople.set(id, person);
    }
  }

  public static void delete(String[] args) {
    List<List<String>> chunks = splitToChunks(args, 1);
    for (List<String> chunk : chunks) {
      int id = Integer.parseInt(chunk.get(0));
      Person person = Person.createFemale(null, null);
      person.setSex(null);
      allPeople.set(id, person);
    }
  }

  public static void main(String[] args) throws ParseException {

    switch (args[0]) {
      case "-c":
        synchronized (allPeople) {
          add(args);
          break;
        }
      case "-u":
        synchronized (allPeople) {
          update(args);
          break;
        }
      case "-i":
        synchronized (allPeople) {
          list(args);
          break;
        }
      case "-d":
        synchronized (allPeople) {
          delete(args);
          break;
        }
    }
  }

  public static List<List<String>> splitToChunks(String[] args, int chunkSize) {
    String[] params = Arrays.copyOfRange(args, 1, args.length);
    List<List<String>> chunks = new ArrayList<>();

    for (int i = 0; i < params.length; i += chunkSize) {
      ArrayList<String> chunk = new ArrayList<String>();

      for (int j = 0; j < chunkSize; j++) {
        chunk.add(params[i + j]);
      }

      chunks.add(chunk);
    }

    return chunks.stream().filter((List<String> item) -> item.size() == chunkSize).collect(Collectors.toList());
  }
}
