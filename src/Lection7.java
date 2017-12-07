class MyThread7 extends Thread{

    public void run(){
        int i=0;
        for (;;) {
            if (interrupted()) {
                System.out.println("Interrupted!");
                break;
            }
            System.out.print(" "+i++);
            if (i%10==0) System.out.println();
        }
    }
}


public class Lection7 {

    public static void main(String[] args) {

//        System.out.println("Line 1");

        MyThread7 thr = new MyThread7();
        thr.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        thr.stop();
        thr.interrupt();
//        System.out.println("Line 2");
    }
}
