package com.javarush.task.pro.task15.task1523;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;

/* 
Получение информации по API
*/

public class SolutionV2 {
  public static void main(String[] args) throws IOException {
    URL url = new URL("http://httpbin.org/post");
    URLConnection connection = url.openConnection();
    connection.setDoOutput(true);

    try (OutputStream output = connection.getOutputStream();
        PrintStream sender = new PrintStream(output)) {
      sender.println("Привет");
    }

    try (InputStream input = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
      while (reader.ready()) {
        System.out.println(reader.readLine());
      }
    }
  }
}
