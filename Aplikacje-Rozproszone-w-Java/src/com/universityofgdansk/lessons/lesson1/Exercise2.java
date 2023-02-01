package com.universityofgdansk.lessons.lesson1;

import java.net.InetAddress;
import java.net.UnknownHostException;

final class Exercise2 {

  public void getSolution() {

    try {

      InetAddress inetAddress = InetAddress.getLocalHost();
      String localhostIp = inetAddress.getHostAddress();
      String localhostName = inetAddress.getHostName();

      System.out.println(localhostIp + " " + localhostName);

    } catch (UnknownHostException e) {

      System.out.println("Localhost couldn't be reached...");
      e.printStackTrace();

    }

  }

}
