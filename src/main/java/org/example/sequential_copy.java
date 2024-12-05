package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class sequential_copy {

    public static void main(String[] args) {
        String sourceFile1 = "src\\source.txt";
        String sourceFile2 = "src\\source1.txt";
        String destFile1 = "src\\dest.txt";
        String destFile2 = "src\\dest1.txt";

        long startTime = System.nanoTime(); // замер времени

        copyFile(sourceFile1, destFile1);
        copyFile(sourceFile2, destFile2);

        long endTime = System.nanoTime();
        System.out.println("Последовательное копирование заняло: " + (endTime - startTime) / 1_000_000 + " мс");
    }

    private static void copyFile(String source, String destination) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }

            System.out.println("Копирование файла " + source + " завершено.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
