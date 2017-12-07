package Lection5;

import java.io.*;

public  class IOUtils {
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
