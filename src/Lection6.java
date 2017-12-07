
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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

//        FileInputStream fin = new FileInputStream(sourceFile);
//        FileOutputStream fout = new FileOutputStream(destFile);
//
//        IOUtils.copy(fin,fout);
//        System.out.println("Done");
//
//        fin.close();
//        fout.close();

//        IOUtils.copyFile(sourceFile,destFile);
//        IOUtils.copyFile(sourceFile2,destFile2);

        new Thread(new CopyTask(sourceFile, destFile)).start();
        new Thread(new CopyTask(sourceFile2, destFile2)).start();
    }
}
