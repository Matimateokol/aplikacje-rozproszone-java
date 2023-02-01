package com.universityofgdansk.lessons.lesson1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

final class Exercise4 {

  public void getSolutionSequencially(String hostname) {

    long millisActualTime = System.currentTimeMillis();
    System.out.println("Starting scanning ports sequencially.");

    // perform task sequencially
    scanPortsSequencially(hostname);

    long executionTime = System.currentTimeMillis() - millisActualTime;
    System.out.println("Task completed. Total execution time: " + executionTime);

  }

  public void getSolutionConcurrently(String hostname) {

    // perform task concurrently
    scanPortsConcurrently(hostname);

  }

  private void scanPortsConcurrently(String hostname) {

    final int numberOfPorts = 65536;
    ExecutorService executorService = Executors.newFixedThreadPool(numberOfPorts / 100 + 1);
    
    // Start measuring the time:
    long millisActualTime = System.currentTimeMillis();
    System.out.println("Starting scanning ports concurrently.");

    for (int i = 0; i < numberOfPorts; i += 100) {
      final int start = i;
      executorService.execute(() -> {
        int end = start + 100;
        if (end > numberOfPorts) {
          end = numberOfPorts;
        }
        for (int j = start; j < end; ++j) {

          try {

            Socket socket = new Socket();
            SocketAddress address = new InetSocketAddress(hostname, j);
            socket.connect(address, 1500);
            System.out.println("Successfully connected with host: " + hostname + " on port: " + j);
            socket.close();

          } catch (IOException e) {

            System.out.println("Weren't able to connect with host: " + hostname + " on port: " + j);
            // e.printStackTrace();

          }
        }
      });
    }

    try {
      executorService.shutdown();
      executorService.awaitTermination(3, TimeUnit.MINUTES);

      // Stop measuring the time:
      long executionTime = System.currentTimeMillis() - millisActualTime;
      System.out.println("Task completed. Total execution time: " + executionTime);

    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  public void scanPortsSequencially(String hostname) {

    for (int i = 0; i < 65536; i++) {

      try {

        Socket socket = new Socket();
        SocketAddress address = new InetSocketAddress(hostname, i);
        socket.connect(address, 1500);
        System.out.println("Successfully connected with host: " + hostname + " on port: " + i);
        socket.close();

      } catch (IOException e) {

        System.out.println("Weren't able to connect with host: " + hostname + " on port: " + i);
        // e.printStackTrace();

      }
    }

  }

}
