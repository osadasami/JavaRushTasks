package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD
*/

public class Solution {
  public static List<Person> allPeople = new ArrayList<Person>();

  static {
    allPeople.add(Person.createMale("Иванов Иван", new Date())); // сегодня родился id=0
    allPeople.add(Person.createMale("Петров Петр", new Date())); // сегодня родился id=1
  }

  public static void main(String[] args) throws ParseException {
    String command = args[0];

    if (command.equals("-c")) {
      String name = args[1];
      String sex = args[2];
      Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(args[3]);
      Person person;

      if (sex.equals("м")) {
        person = Person.createMale(name, birthDate);
      } else {
        person = Person.createFemale(name, birthDate);
      }

      allPeople.add(person);
      System.out.println(allPeople.size() - 1);
    }

    if (command.equals("-r")) {
      int id = Integer.parseInt(args[1]);
      Person person = allPeople.get(id);
      String birthDate = new SimpleDateFormat("dd-MMM-yyyy").format(person.getBirthDate());
      String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
      System.out.println(String.format("%s %s %s", person.getName(), sex, birthDate));
    }

    if (command.equals("-u")) {
      int id = Integer.parseInt(args[1]);
      String name = args[2];
      Sex sex = args[3].equals("м") ? Sex.MALE : Sex.FEMALE;
      Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(args[4]);
      Person person;

      if (sex.equals(Sex.MALE)) {
        person = Person.createMale(name, birthDate);
      } else {
        person = Person.createFemale(name, birthDate);
      }

      allPeople.set(id, person);
    }

    if (command.equals("-d")) {
      int id = Integer.parseInt(args[1]);
      Person person = Person.createFemale(null, null);
      person.setSex(null);
      allPeople.set(id, person);
    }
  }
}
