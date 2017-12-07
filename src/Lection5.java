
class  MyThread extends Thread{
    public void run(){

        for (int i = 0; i < 1500; i++) {
            System.out.print("T");
            if (i%100==0) System.out.println();
        }
    }
}

class MyTask implements Runnable {
    @Override
    public void run(){
        for (int i = 0; i < 1500; i++) {
            System.out.print("!");
            if (i%100==0) System.out.println();
        }
    }
}

public class Lection5 {
    public static void main(String[] args) {
        MyThread thr = new MyThread();

        thr.start();

        MyTask task = new MyTask();
        Thread thr2 = new Thread(task);
        thr2.start();

        for (int i = 0; i <1500 ; i++) {
            System.out.print("M");
            if (i%100==0) System.out.println();
        }

    }
}


