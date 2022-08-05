package com.boardgames;

import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class FileUtil {


    public static void writeToAFile(String data, File fileName) {
        boolean append = false;

        if (fileName.exists()) { append = true; }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName.getAbsolutePath(), append);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();

        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", fileName.getAbsolutePath());
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", fileName.getAbsolutePath());
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
        }
    }


    public static String readAFile(File fileName) {
        String data =  "";

        try {

            if (fileName.exists()) {
                FileInputStream fileInputStream = new FileInputStream(fileName.getAbsolutePath());
                int byteData = fileInputStream.read();
                data += (char) byteData;

                while (byteData != -1) {
                    byteData = fileInputStream.read();
                    data += (char) byteData;
                }

                fileInputStream.close();
            }
        }  catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", fileName.getAbsolutePath());
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", fileName.getAbsolutePath());
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
        }

        return data;
    }

}
