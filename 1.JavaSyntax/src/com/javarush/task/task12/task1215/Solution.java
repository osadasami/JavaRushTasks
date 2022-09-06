package com.javarush.task.task12.task1215;

/* 
Кошки не должны быть абстрактными!
*/

public class Solution {
  public static void main(String[] args) {

  }

  public static abstract class Pet {
    public abstract String getName();

    public abstract Pet getChild();
  }

  public static class Cat extends Pet {
    @Override
    public Cat getChild() {
      return new Cat();
    }

    @Override
    public String getName() {
      return "Vasya";
    }
  }

  public static class Dog extends Pet {

    @Override
    public String getName() {
      return "Petya";
    }

    @Override
    public Dog getChild() {
      return new Dog();
    }

  }

}
