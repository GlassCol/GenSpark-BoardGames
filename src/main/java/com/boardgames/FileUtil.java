package com.boardgames;

import java.io.*;
import java.nio.file.Path;

public class FileUtil {


    public static void writeToAFile(String data, String fileName) {
        File file = new File(fileName);
        boolean append = false;

        if (file.exists()) { append = true; }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath(), append);
            fileOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readAFile(String fileName) {
        StringBuilder data =  new StringBuilder();;

        try {
            FileInputStream fileInputStream = new FileInputStream(Path.of(fileName).toString());
            int byteData = fileInputStream.read();
            data.append( (char) byteData);

            while (byteData != -1) {
                byteData = fileInputStream.read();
                data.append((char) byteData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data.toString();
    }

}
