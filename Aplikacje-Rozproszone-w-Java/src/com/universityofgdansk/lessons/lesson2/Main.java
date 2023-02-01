package com.universityofgdansk.lessons.lesson2;

import java.io.IOException;

public class Main {

  public static void main(String[] args) {

    // Exercise 1
    try {
      Exercise1.scrapCurrencies();
      Exercise1.readCurrencies();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
