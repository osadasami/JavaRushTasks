package com.javarush.task.task16.task1632;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {
  public static List<Thread> threads = new ArrayList<>(5);

  static {
    threads.add(new MyThread1());
    threads.add(new MyThread2());
    threads.add(new MyThread3());
    threads.add(new MyThread4());
    threads.add(new MyThread5());
  }

  public static void main(String[] args) {
  }

  public static class MyThread1 extends Thread {
    @Override
    public void run() {
      while (true) {
      }
    }
  }

  public static class MyThread2 extends Thread {
    @Override
    public void run() {
      try {
        throw new InterruptedException();
      } catch (InterruptedException e) {
        System.out.println("InterruptedException");
      }
    }
  }

  public static class MyThread3 extends Thread {
    @Override
    public void run() {
      while (true) {
        System.out.println("Ура");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
        }
      }
    }
  }

  public static class MyThread4 extends Thread implements Message {
    @Override
    public void run() {
      while (!isInterrupted()) {
      }
    }

    @Override
    public void showWarning() {
      interrupt();
    }
  }

  public static class MyThread5 extends Thread {
    @Override
    public void run() {
      int sum = 0;
      Scanner scanner = new Scanner(System.in);
      String input;

      while (!(input = scanner.nextLine()).equals("N")) {
        try {
          int n = Integer.parseInt(input);
          sum += n;
        } catch (Exception e) {
        }
      }

      System.out.println(sum);
    }
  }

}
