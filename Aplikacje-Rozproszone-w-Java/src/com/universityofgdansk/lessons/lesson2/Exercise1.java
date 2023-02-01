package com.universityofgdansk.lessons.lesson2;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// Jsoup html scrapper
final class Exercise1 {

  volatile static LinkedHashMap<String, String> currencyToPLNExchangeRate = new LinkedHashMap<>();

  public synchronized static void scrapCurrencies() throws IOException {
    ReentrantLock reentrantLock = new ReentrantLock();
    reentrantLock.lock();

    try {
      Connection connect = Jsoup.connect("https://www.nbp.pl/home.aspx?f=/kursy/kursya.html");
      Document document = connect.get();
      Elements allH1 = document.select("td.left");

      for (Element ele : allH1) {
        String currency = ele.text();
        String value =
            ele.nextElementSibling().nextElementSibling() != null
                ? ele.nextElementSibling().nextElementSibling().text()
                : "";

        if (currency.contains("euro")) {
          currencyToPLNExchangeRate.put("Euro", value);
        } else if (currency.contains("dolar amerykański")) {
          currencyToPLNExchangeRate.put("Dolar amerykański", value);
        } else if (currency.contains("frank szwajcarski")) {
          currencyToPLNExchangeRate.put("Frank szwajcarski", value);
        }
      }

    } catch (Exception e) {
      System.out.println("Unexpected exception thrown...: " + e);
    } finally {
      reentrantLock.unlock();
    }

  }

  public static void readCurrencies() {
    currencyToPLNExchangeRate.forEach((k, v) -> System.out.println(k + " : " + v));
  }

}
