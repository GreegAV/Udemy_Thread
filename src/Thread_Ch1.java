class Task1 {
    public void doTask() {
        for(int i=1; i < 1500; i++) {
            if (i%500==0)
                System.out.println();
            System.out.print("T");
        }
    }
}

public class Thread_Ch1 {

    public static void main(String[] args) {

        for(int i=1; i < 1500; i++) {
            if (i%500==0)
                System.out.println();
            System.out.print("M");
        }
        System.out.println();
        System.out.println();
        Task1 t1 = new Task1();
        t1.doTask();
    }

}
