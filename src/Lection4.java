class MyThead extends Thread{
   public void   run(){
       for (int i = 0; i <1500 ; i++) {
           if (i%100==0) System.out.println();
           System.out.print("1");
       }
   }
}

class myTask implements Runnable{

    @Override
    public void run(){
        for (int i = 0; i <1500 ; i++) {
            if (i%100==0) System.out.println();
            System.out.print("2");
        }
    }
}

public class Lection4 {
    public static void main(String[] args) {
        MyThead myThead=new MyThead();
        myThead.start();

        myTask myTask = new myTask();
        Thread thread = new Thread(myTask);
        thread.start();

        for (int i = 0; i <1500 ; i++) {
            if (i%100==0) System.out.println();
            System.out.print("M");
        }

    }
}
