package com.universityofgdansk.lessons.lesson1;

import java.net.InetAddress;
import java.net.UnknownHostException;

final class Exercise3 {

  public void getSolution(String hostName) {

    try {

      InetAddress[] ips = InetAddress.getAllByName(hostName);

      insertSort(ips);

      for (InetAddress ip : ips) {
        System.out.println(ip.getHostAddress().toString());
      }

    } catch (UnknownHostException e) {

      System.out.println("Can't get address for host " + hostName);
      e.printStackTrace();

    }

  }

  private void insertSort(InetAddress[] ips) {

    for (int i = 1; i < ips.length; i++) {
      int j = i;
      InetAddress temp = ips[j];

      while ((j > 0) && (new InetAddressComparator().compare(ips[j - 1], temp) == 1)) {
        ips[j] = ips[j - 1];
        j--;
      }
      ips[j] = temp;

    }
  }

}
