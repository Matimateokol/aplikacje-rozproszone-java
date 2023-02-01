package com.universityofgdansk.lessons.lesson1;

public class Main {

	public static void main(String[] args) {

      // Exercise 1:
      Exercise1 exercise1 = new Exercise1();
      exercise1.getSolution();

      // Exercise 2:
      Exercise2 exercise2 = new Exercise2();
      exercise2.getSolution();

      // Exercise 3:
      Exercise3 exercise3 = new Exercise3();
      exercise3.getSolution(args[0]);

      // Exercise 4:
      Exercise4 exercise4 = new Exercise4();
      exercise4.getSolutionSequencially("www.wp.pl");
      exercise4.getSolutionConcurrently("www.wp.pl");

	}

}
