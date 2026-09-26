package com.roy.zerocopy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIODemo1 {

    public static void main(String[] args) throws IOException {
        File f = new File("/home/oper/test1.txt");
        if(!f.exists()){
            f.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(f);
        for(int i = 0 ; i < 100 ; i ++){
            fos.write("a".getBytes("utf-8"));
            fos.flush();
        }
        fos.close();
    }
}
