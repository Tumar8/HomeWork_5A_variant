package com.company;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(10);
        CountDownLatch cdl2 = new CountDownLatch(10);
        Semaphore sem = new Semaphore(3);
        UpLoader uploader = new UpLoader(cdl);
        uploader.start();
        try {
            cdl.await();
            for (int i = 1; i <= 10; i++) {
                DownLoader downloader = new DownLoader(sem, cdl2, i);
                downloader.start();
            }
            cdl2.await();
            System.out.println("__________________________________");
            System.out.println("Загрузка невозможна \n" +
                    "Файл не найден на сервере");

        } catch (InterruptedException e) {

        }
    }

}