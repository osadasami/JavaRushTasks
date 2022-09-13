package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/* 
Последовательный вывод файлов
*/

public class Solution {
  public static String firstFileName;
  public static String secondFileName;

  static {
    Scanner scanner = new Scanner(System.in);
    firstFileName = scanner.nextLine();
    secondFileName = scanner.nextLine();
    scanner.close();
  }

  public static void main(String[] args) throws InterruptedException {
    systemOutPrintln(firstFileName);
    systemOutPrintln(secondFileName);
  }

  public static void systemOutPrintln(String fileName) throws InterruptedException {
    ReadFileInterface f = new ReadFileThread();
    f.setFileName(fileName);
    f.start();
    f.join();
    System.out.println(f.getFileContent());
  }

  public interface ReadFileInterface {

    void setFileName(String fullFileName);

    String getFileContent();

    void join() throws InterruptedException;

    void start();
  }

  public static class ReadFileThread extends Thread implements ReadFileInterface {
    private String fullFileName;
    private String fileContent = "";

    @Override
    public void run() {
      try {
        BufferedReader fr = new BufferedReader(new FileReader(fullFileName));
        Iterator<String> iterator = fr.lines().iterator();

        while (iterator.hasNext()) {
          fileContent += iterator.next() + " ";
        }

        fr.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    @Override
    public void setFileName(String fullFileName) {
      this.fullFileName = fullFileName;
    }

    @Override
    public String getFileContent() {
      return fileContent;
    }

  }
}
