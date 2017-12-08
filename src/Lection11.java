import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Sample11 {
    private int x=10;

    ReadWriteLock rw_lock = new ReentrantReadWriteLock();

    public void incr(){

        Lock lock = rw_lock.writeLock();

        lock.lock();

        try {
            int y = getX();
            y++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setX(y);
        } finally {
            lock.unlock();
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}

class MyThread11 extends Thread {

    Sample11 obj;
    public MyThread11(Sample11 obj){
        this.obj=obj;
    }

    public void run(){
        obj.incr();
    }

}


public class Lection11 {
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
