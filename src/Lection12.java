import java.util.concurrent.*;

class MyMath {
    public static int add(int a, int b) {
        return a + b;
    }
}

class MyTask12 implements Callable<Integer> {
    int x;
    int y;

    public MyTask12(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer call() throws Exception {
        int result = MyMath.add(x, y);
        return result;
    }

}


public class Lection12 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int x = 10;
        int y = 20;

        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(new MyTask12(x, y));
        Future<Integer> future = executor.submit(new MyTask12(x, y));

        // do somthing else

        while (!future.isDone()) {
            // do nothing
        }
        int z = MyMath.add(x, y);
        int zz = future.get();
        System.out.println("1st result is " + z);
        System.out.println("2nd result is " + zz);
    }
}
