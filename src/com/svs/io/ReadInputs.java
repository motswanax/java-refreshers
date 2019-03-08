package com.svs.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author baike
 */
public class ReadInputs {

    public static void readFromKeyboard() throws IOException {
        byte[] data = new byte[10];

        System.out.println("Enter some characters: ");
        System.in.read(data);
        System.out.print("You entered: ");

        for (int i = 0; i < data.length; i++) {
            System.out.print((char) data[i]);
        }
    }

    public static void readFile(String pathname) {
        File file = new File(pathname);

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            System.out.println("Total size to read in bytes is " + fileInputStream.available());

            int content;
            while ((content = fileInputStream.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
//        ReadInputs.readFromKeyboard();
        ReadInputs.readFile("src/test.txt");
    }
}
