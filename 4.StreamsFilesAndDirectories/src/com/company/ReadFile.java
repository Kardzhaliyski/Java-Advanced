package com.company;

        import java.io.FileInputStream;
        import java.io.IOException;
        import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String userDir = System.getProperty("user.dir");
        String path = userDir + "/res/input.txt";
        System.out.println();

        try (FileInputStream fis = new FileInputStream(path)) {

            int oneByte = fis.read();
            StringBuilder text = new StringBuilder();
            while (oneByte >= 0) {
                text.append(Integer.toBinaryString(oneByte));
                text.append(" ");
                oneByte = fis.read();
            }
            System.out.println(text);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
