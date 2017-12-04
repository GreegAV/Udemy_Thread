/**
 * Created by avg-m on 04/12/2017.
 */

class Task2 extends Thread {

    public void run() {
        doTask();
    }

    public void doTask() {
        for(int i=1; i <= 15; i++) {
            System.out.print("T");
            if (i%5==0)
                System.out.println();
        }
    }
}

public class Thread_Ch2 {

    public static void main(String[] args) {

        Task2 t1 = new Task2();
        t1.start();

        for(int i=1; i <= 15; i++) {
            System.out.print("M");
            if (i%5==0)
                System.out.println();
        }

    }

}
