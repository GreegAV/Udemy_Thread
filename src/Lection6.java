

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class IOUtils {
    public static void copy(InputStream src, OutputStream dest) throws IOException {
        int value;
        while ((value=src.read())!=-1){
            dest.write(value);

        }
    }

    public static void copyFile(String srcFile, String destFile) throws IOException{
        FileInputStream fin = new FileInputStream(srcFile);
        FileOutputStream fout = new FileOutputStream(destFile);

        IOUtils.copy(fin,fout);
        System.out.println("Done");

        fin.close();
        fout.close();
    }
}

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
            IOUtils.copyFile(sourceFile,destFile);
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
