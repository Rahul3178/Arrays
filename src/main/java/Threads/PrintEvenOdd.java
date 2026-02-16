package Threads;

class CheckEvenAndOdd implements Runnable {


   private  int max;
   private boolean isEvenNumber;
    private Printer print;
    public CheckEvenAndOdd(int max, boolean isEvenNumber,Printer print) {
        this.max = max;
        this.isEvenNumber = isEvenNumber;
        this.print=print;
    }

    @Override
    public void run() {
        int number = isEvenNumber ? 2 : 1;
        while (number < max) {
            if (isEvenNumber) {
                // print even
                print.printEven(number);
            } else {
                // print odd
                print.printOdd(number);
            }

            number += 2;
        }
    }


}

class Printer {
    private volatile boolean isOdd;

    synchronized void printEven(int number) {
        while (!isOdd) {
            try {

                wait();
            } catch (InterruptedException ex) {
                Thread.currentThread()
                      .interrupted();
            }
        }
        System.out.println(Thread.currentThread()
                                 .getName() + ":" + number);
        isOdd = false;
        notify();
    }

    synchronized void printOdd(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Thread.currentThread()
                      .interrupt();
            }
        }
        System.out.println(Thread.currentThread()
                                 .getName() + ":" + number);
        isOdd = true;
        notify();
    }
}

public class PrintEvenOdd {
    public static void main(String[] args) {

        Printer print = new Printer();
        Thread even = new Thread(new CheckEvenAndOdd(20, true,print), "Even");
        Thread odd = new Thread(new CheckEvenAndOdd(20, false,print), "Odd");

        even.start();
        odd.start();
    }
}
