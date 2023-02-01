package com.universityofgdansk.lessons.lesson1;

import java.util.Random;

class MyClass implements Runnable {

  private Random rnd;
  private String str;

  public MyClass(String str) {
    this.str = str;
    rnd = new Random();
  }

  public void run() {

    for (int i = 0; i < 5; i++) {
      String name = "";
      try {
        name = Thread.currentThread().getName();
        Thread.sleep(rnd.nextInt(2500) + 500);
      } catch (InterruptedException e) {

      }

      System.out.println(name + " " + str + " " + i);
    }
  }

  public static void main(String[] args) {

    MyClass mc1 = new MyClass("Pierwszy");
    MyClass mc2 = new MyClass("Drugi");
    Thread thread1 = new Thread(mc1, "Pierwszy");
    Thread thread2 = new Thread(mc2, "Drugi");
    thread1.start();
    thread2.start();

  }

}
