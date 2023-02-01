package com.universityofgdansk.lessons.lesson6;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Server {
    static String polybiusCipher(String s)
    {
        int row, col;
        String result = "";

        // convert each character
        // to its encrypted code
        for (int i = 0;i < s.length(); i++)
        {
            row = (int)Math.ceil((s.charAt(i) - 'a') / 5) + 1;
            col = ((s.charAt(i) - 'a') % 5) + 1;
            if (s.charAt(i) == 'k')
            {
                row = row - 1;
                col = 5 - col + 1;
            }
            else if (s.charAt(i) >= 'j')
            {
                if (col == 1)
                {
                    col = 6;
                    row = row - 1;
                }
                col = col - 1;
            }
            result=result+Integer.toString(row)+""+Integer.toString(col);
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
      System.out.print("Input some text: ");
        Scanner scanner = new Scanner(System.in);
        String text=scanner.nextLine();
        DatagramSocket ds = new DatagramSocket();
        String str = polybiusCipher(text);
        InetAddress ip = InetAddress.getByName("127.0.0.1");

        DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 3000);
        ds.send(dp);
        ds.close();
    }
}