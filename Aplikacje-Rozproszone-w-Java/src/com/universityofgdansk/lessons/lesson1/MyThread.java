package com.universityofgdansk.lessons.lesson1;

public class MyThread extends Thread {

  private int delay;

  public MyThread(String name, int delay) {
    super(name);
    this.delay = delay;
  }

  public void run() {

    for (int i = 0; i < 5; i++) {
      System.out.println(this.getName());
    }

    try {
      sleep(delay);
      // if (this.getName() == "Drugi wątek") {
      // throw (new InterruptedException("test interruption"));
      // }
    } catch (InterruptedException e) {
      // System.out.println("The following exception has been catched: " + e.getMessage());
    }
  }

  public static void main(String[] args) {

    new MyThread("Pierwszy wątek", 200).start();
    new MyThread("Drugi wątek", 100).start();
  }

}
