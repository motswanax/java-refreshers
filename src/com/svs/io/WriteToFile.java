package com.svs.io;

import java.io.*;

/**
 * Demo of reading and writing to file.
 * @author baike
 */
public class WriteToFile {

    public static void writeToFile(String pathname) {
        File file = new File(pathname);

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("Hell yeah! PSG bottlers.");
            fileWriter.close();

            ReadInputs.readFile(pathname);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileBuffer(String pathname) {
        File file = new File(pathname);

        try(FileReader fileReader = new FileReader(file)) {
            // read files efficiently
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        WriteToFile.writeToFile("src/myFile.txt");
        WriteToFile.readFileBuffer("src/bufferedTest.txt");
    }
}
