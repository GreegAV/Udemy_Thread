class Task {
    public void doTask(){
        for (int i = 0; i <1500 ; i++) {
            if (i%100==0) System.out.println();
            System.out.print("T");
        }
    }
}
public class Lection2 {
    public static void main(String[] args) {
        Task t1 = new Task();
        t1.doTask();

        System.out.println();
        for (int i = 0; i <1500 ; i++) {
            if (i%100==0) System.out.println();
            System.out.print("M");
        }
    }

}
