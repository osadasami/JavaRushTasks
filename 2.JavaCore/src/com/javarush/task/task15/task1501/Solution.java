package com.javarush.task.task15.task1501;

/* 
ООП - Расставить интерфейсы
*/

public class Solution {
  public static void main(String[] args) {

  }

  public interface Movable {
    boolean isMovable();
  }

  public interface Sellable {
    Object getAllowedAction(String name);
  }

  public interface Discountable {
    Object getAllowedAction();
  }

  public static class Clothes implements Sellable, Movable, Discountable {

    @Override
    public Object getAllowedAction() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public boolean isMovable() {
      // TODO Auto-generated method stub
      return false;
    }

    @Override
    public Object getAllowedAction(String name) {
      // TODO Auto-generated method stub
      return null;
    }
  }
}
