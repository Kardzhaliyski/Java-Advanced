package com.company;


import java.io.*;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class CreateZipArchive {
    public static void main(String[] args) {
        Path userdir = Path.of(System.getProperty("user.dir"));
        Path pathRes = Path.of(userdir + "\\res");
        StringBuilder sb = new StringBuilder();
        sb.append("Test String");

        File f = new File(userdir + "\\res\\test.zip");
        try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
             FileInputStream fis1 = new FileInputStream(new File(pathRes + "\\inputOne.txt"));
             FileInputStream fis2 = new FileInputStream(new File(pathRes + "\\inputTwo.txt"))) {
            ZipEntry e1 = new ZipEntry("inputOne.txt");
            out.putNextEntry(e1);
            byte[] data1 = fis1.readAllBytes();
            out.write(data1, 0, data1.length);
            out.closeEntry();
            ZipEntry e2 = new ZipEntry("inputTwo.txt");
            out.putNextEntry(e2);
            byte[] data2 = fis2.readAllBytes();
            out.write(data2, 0, data2.length);
            out.closeEntry();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
