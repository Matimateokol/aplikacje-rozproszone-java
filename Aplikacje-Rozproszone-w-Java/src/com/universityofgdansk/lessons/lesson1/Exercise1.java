package com.universityofgdansk.lessons.lesson1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

final class Exercise1 {

  String[] hosts =
      new String[] {"www.wp.pl", "www.ug.edu.pl", "www.onet.pl", "www.interia.pl", "www.helion.pl"};

  public void displayHostConnectionDetails(String host) {

    try {

      Socket socket = new Socket(host, 80);
      InetAddress inetAddress = socket.getInetAddress();
      String ip = inetAddress.getHostAddress();
      String hostName = inetAddress.getHostName();
      int hostPort = socket.getPort();
      int localPort = socket.getLocalPort();

      System.out.println("Host: " + hostName + " Ip: " + ip + " hostPort: " + hostPort
          + " localPort: " + localPort);

      socket.close();

    } catch (UnknownHostException e) {

      System.out.println("Couldn't connect to the specified host on port 80: " + host);
      e.printStackTrace();

    } catch (IOException e) {

      System.out.println("Input-Output error!!!");
      e.printStackTrace();

    }

  }

  public void getSolution() {

    Random rnd = new Random();
    int startIndex = rnd.nextInt(hosts.length);

    String[] part1 = Arrays.copyOfRange(hosts, startIndex, hosts.length);
    String[] part2 = Arrays.copyOfRange(hosts, 0, startIndex);
    List<String> randomizedHostList = new LinkedList<>();
    Collections.addAll(randomizedHostList, part1);
    Collections.addAll(randomizedHostList, part2);

    for (int i = 0; i < randomizedHostList.size(); i++) {
      displayHostConnectionDetails(randomizedHostList.get(i));
    }

  }
}
