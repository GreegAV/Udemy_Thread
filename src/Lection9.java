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

    Sample obj;
    public MyThread9(Sample obj){
        this.obj=obj;
    }

    public void run(){
        obj.incr();
    }

}


public class Lection9 {
    public static void main(String[] args) {
        Sample obj = new Sample();
        MyThread9 t1= new MyThread9(obj);
        MyThread9 t2= new MyThread9(obj);

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
