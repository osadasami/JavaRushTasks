package com.javarush.task.pro.task15.task1523;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/* 
Получение информации по API
*/

public class Solution {
  public static void main(String[] args) throws IOException {
    URL url = new URL("http://httpbin.org/post");
    URLConnection connection = url.openConnection();
    connection.setDoOutput(true);
    OutputStream out = connection.getOutputStream();
    out.write(1);
    InputStream input = connection.getInputStream();
    System.out.println(new String(input.readAllBytes()));
  }
}
