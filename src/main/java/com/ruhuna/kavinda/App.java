package com.ruhuna.kavinda;

import com.ruhuna.kavinda.database.inmemory.feeddata.FeedData;


/**
 * Hello world!
 * used java version :- Java SE 9
 */
public class App {
    public static void main(String[] args) {
//        System.setProperty("log4j.debug", "");
        new FeedData().init();

        TelecomBillingController telecomBillingController = new TelecomBillingController();
        int transactionNo = telecomBillingController.authorize(719669850);

        telecomBillingController.confirm(transactionNo);

        int transactionNo1 = telecomBillingController.authorize(719669250);

        telecomBillingController.cancel(transactionNo1);

        telecomBillingController.authorize(719669450);// this will automatically canceled after one minutes.

        telecomBillingController.authorize(715669250);// this number not in the list

        telecomBillingController.cancel(21515611);// incorrect transaction no

    }

}
