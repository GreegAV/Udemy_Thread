
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CopyTask implements Runnable{

    String sourceFile;
    String destFile;

    public CopyTask(String sourceFile, String destFile) {
        this.sourceFile = sourceFile;
        this.destFile = destFile;
    }

    @Override
    public void run() {
        try {
            Lection5.IOUtils.copyFile(sourceFile,destFile);
            System.out.println("Copied from "+sourceFile+" to "+destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Lection6 {
    public static void main(String[] args) throws IOException {
        String sourceFile= "a.txt";
        String sourceFile2= "b.txt";
        String destFile="c.txt";
        String destFile2="d.txt";

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i <100 ; i++) {
            String destFile3=destFile+String.valueOf(i);
            executor.execute(new CopyTask(sourceFile, destFile3));

        }

//        executor.execute(new CopyTask(sourceFile2, destFile2));

    }
}
