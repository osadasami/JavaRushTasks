package com.javarush.task.pro.task14.task1415;

import java.util.LinkedList;
import java.util.List;

/* 
Стек в домашних условиях
*/

public class MyStack {

  private final List<String> storage = new LinkedList<>();

  public void push(String s) {
    storage.add(0, s);
  }

  public String pop() {
    String firstEl = storage.get(0);
    storage.remove(firstEl);
    return firstEl;
  }

  public String peek() {
    return storage.get(0);
  }

  public boolean empty() {
    return storage.size() == 0;
  }

  public int search(String s) {
    return storage.indexOf(s);
  }
}
