package com.javarush.task.task18.task1828;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Прайсы
*/

public class Solution {

  public static class Product {
    int id;
    String name;
    String price;
    String quantity;

    public Product(int id, String name, String price, String quantity) {
      this.id = id;
      this.name = name;
      this.price = price;
      this.quantity = quantity;
    }

    @Override
    public String toString() {
      return String.format("%-8d%-30s%-8s%-4s", id, name, price, quantity);
    }
  }

  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      return;
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String fileName = reader.readLine();
    List<Product> products = new ArrayList<>();

    try (
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
      while (fileReader.ready()) {
        Product product = getProduct(fileReader.readLine());
        products.add(product);
      }
    }

    switch (args[0]) {
      case "-u":
        update(args, products, fileName);
        break;
      case "-d":
        delete(args, products, fileName);
        break;
    }
  }

  private static void delete(String[] args, List<Product> products, String fileName) throws IOException {
    int id = Integer.parseInt(args[1]);
    String newProducts = products.stream().filter((Product product) -> product.id != id).map(Object::toString)
        .collect(Collectors.joining("\n"));
    try (FileWriter fileWriter = new FileWriter(fileName)) {
      fileWriter.write(newProducts.toString());
    }
  }

  private static void update(String[] args, List<Product> products, String fileName) throws IOException {
    int id = Integer.parseInt(args[1]);

    String name = "";
    for (int i = 2; i < args.length - 2; i++) {
      name += args[i] + " ";
    }
    if (name.length() > 30) {
      name = name.substring(0, 30);
    }
    String price = args[args.length - 2];
    if (price.length() > 8) {
      price = price.substring(0, 8);
    }
    String quantity = args[args.length - 1];
    if (quantity.length() > 4) {
      quantity = quantity.substring(0, 4);
    }

    Product editingProduct = products.stream().filter((Product product) -> product.id == id)
        .collect(Collectors.toList()).get(0);

    editingProduct.name = name;
    editingProduct.price = price;
    editingProduct.quantity = quantity;

    try (FileWriter fileWriter = new FileWriter(fileName)) {
      for (Product product : products) {
        fileWriter.write(product.toString() + "\n");
      }
    }

  }

  public static Product getProduct(String line) {
    String id = line.substring(0, 8).trim();
    String name = line.substring(8, 38).trim();
    String price = line.substring(38, 46).trim();
    String quantity = line.substring(46, 50).trim();
    return new Product(Integer.parseInt(id), name, price, quantity);
  }
}
