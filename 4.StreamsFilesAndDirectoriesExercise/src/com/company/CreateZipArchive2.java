package com.company;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class CreateZipArchive2 {
    public static void main(String[] args) {
        Path userdir = Path.of(System.getProperty("user.dir"));
        Path pathRes = Path.of(userdir + "\\res");

        File resFolder = pathRes.toFile();
        File f = new File(userdir + "\\res\\test.zip");
        try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f))) {
            File[] resFiles = resFolder.listFiles();
            for (File file : resFiles) {
                if (!file.isDirectory()) {
                    ZipEntry entry = new ZipEntry(file.getName());
                    out.putNextEntry(entry);
                    byte[] data = Files.newInputStream(file.toPath()).readAllBytes();
                    out.write(data, 0, data.length);
                }
            }

//            ZipEntry e1 = new ZipEntry("inputOne.txt");
//            out.putNextEntry(e1);
//            byte[] data1 = fis1.readAllBytes();
//            out.write(data1, 0, data1.length);
//            out.closeEntry();
//            ZipEntry e2 = new ZipEntry("inputTwo.txt");
//            out.putNextEntry(e2);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
