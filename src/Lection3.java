class Task3 extends Thread{

    public void run(){
        doTask();
    }

    public void doTask(){
        for (int i = 0; i <1500 ; i++) {
            if (i%100==0) System.out.println();
            System.out.print("T");
        }
    }
}
public class Lection3 {
    public static void main(String[] args) {
        Task3 t1 = new Task3();
        t1.doTask();

        System.out.println();
        for (int i = 0; i <1500 ; i++) {
            if (i%100==0) System.out.println();
            System.out.print("M");
        }
    }

}
