package com.roy.zerocopy;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileIODemo3 {
    public static void main(String[] args) throws IOException {
        File f = new File("/home/oper/test2.txt");
        if(!f.exists()){
            f.createNewFile();
        }
        RandomAccessFile raf = new RandomAccessFile(f,"rw");
        final FileChannel fc = raf.getChannel();

        fc.map(FileChannel.MapMode.READ_WRITE,0,5);
        final ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        for(int i = 0 ; i < 100; i ++){
            byteBuffer.put(i,(byte)'a');
        }
        System.out.println(byteBuffer.toString());
        fc.position(0).write(byteBuffer);
        fc.force(true);
        fc.close();
        raf.close();
    }
}
