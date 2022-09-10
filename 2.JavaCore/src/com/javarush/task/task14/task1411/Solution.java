package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Person person = null;
    String key = null;
    List<String> availableKeys = new ArrayList<>() {
      {
        add("user");
        add("loser");
        add("coder");
        add("proger");
      }
    };

    while (availableKeys.contains(key = reader.readLine())) {
      switch (key) {
        case "user":
          person = new Person.User();
          break;
        case "coder":
          person = new Person.Coder();
          break;
        case "proger":
          person = new Person.Proger();
          break;
        default:
          person = new Person.Loser();
      }
      doWork(person);
    }
  }

  public static void doWork(Person person) {
    if (person instanceof Person.User) {
      Person.User user = (Person.User) person;
      user.live();
    }
    if (person instanceof Person.Coder) {
      Person.Coder coder = (Person.Coder) person;
      coder.writeCode();
    }
    if (person instanceof Person.Proger) {
      Person.Proger proger = (Person.Proger) person;
      proger.enjoy();
    }
    if (person instanceof Person.Loser) {
      Person.Loser loser = (Person.Loser) person;
      loser.doNothing();
    }
  }
}
