package com.tts;

// #1
public class BadThreads {
    static String message;

    private static class CorrectorThread extends Thread {
        public void run() {
            try{
                sleep(1000);
            }catch (InterruptedException e) {}
            //Key statement 1:
            message = "Mares do eat oats";
        }
    }
    public static void main(String args[])
	    throws InterruptedException {

            (new CorrectorThread()).start();
            message = "Mares do not eat oats.";
            Thread.sleep(2000);
            //Key Statement 2:
            System.out.println(message);
    }
}

// #2 The application should print out "Mares do eat oats." Is it guaranteed to always do this?
//- If not, why not?

// A. It is not guaranteed to always do this because there is no happens-before relationship between the key statements

// #3 Would it help to change the parameters of the two invocations of Sleep?

// A. Changing the parameters of the Sleep invocations would not help because there would still be no happens-before relationship

// #4 How would you guarantee that all changes to message will be visible in the main thread?

// A. I would guarantee these changes to be visible by including the happens-before relationship using synchronization methods.

