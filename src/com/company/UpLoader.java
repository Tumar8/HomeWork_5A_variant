package com.company;



import java.util.concurrent.CountDownLatch;

public class UpLoader extends Thread {
    CountDownLatch cdl;
    public UpLoader(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    @Override
    public void run() {
        System.out.println("Загрузка файла на сервер..");
        for (int i = 1; i <= 10; i++) {
            System.out.print(".");
            try {
                sleep(2000);

            } catch (InterruptedException e) {
                System.out.print(System.lineSeparator());
                e.printStackTrace();
            }try {
                sleep(2000);
                cdl.countDown();

            } catch (InterruptedException e) {
            }
        }
        System.out.println(" Загрузка завершена ");
        super.run();
    }
}