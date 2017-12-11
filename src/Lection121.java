import java.util.concurrent.*;

class MyMath121 {
    public static int add(int a, int b) {
        return a + b;
    }
}




public class Lection121 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int aa = 10;
        int bb = 20;

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(
                new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return MyMath121.add(aa,bb);
                    }
                });

        // do somthing else

        while (!future.isDone()) {
            // do nothing
        }
        int zzzz = future.get();
        System.out.println("2nd result is " + zzzz);
    }
}
