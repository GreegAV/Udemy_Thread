class Sample {
    private int x=10;

    public synchronized void incr(){
        int y=getX();
        y++;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setX(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}

class MyThread9 extends Thread {

    Sample11 obj;
    public MyThread9(Sample11 obj){
        this.obj=obj;
    }

    public void run(){
        obj.incr();
    }

}


public class Lection9 {
    public static void main(String[] args) {
        Sample11 obj = new Sample11();
        MyThread11 t1= new MyThread11(obj);
        MyThread11 t2= new MyThread11(obj);

        t1.start();
        t2.start();


//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(obj.getX());

    }
}
