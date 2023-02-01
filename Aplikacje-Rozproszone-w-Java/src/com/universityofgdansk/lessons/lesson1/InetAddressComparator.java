package com.universityofgdansk.lessons.lesson1;

import java.net.InetAddress;
import java.util.Comparator;

final class InetAddressComparator implements Comparator<InetAddress> {

  @Override
  public int compare(InetAddress o1, InetAddress o2) {
    byte[] o1Address = o1.getAddress();
    byte[] o2Address = o2.getAddress();

    if (o1Address[0] > o2Address[0])
      return 1;
    if (o1Address[0] < o2Address[0])
      return -1;
    if (o1Address[1] > o2Address[1])
      return 1;
    if (o1Address[1] < o2Address[1])
      return -1;
    if (o1Address[2] > o2Address[2])
      return 1;
    if (o1Address[2] < o2Address[2])
      return -1;
    if (o1Address[3] > o2Address[3])
      return 1;
    if (o1Address[3] < o2Address[3])
      return -1;

    return 0;
  }

}
