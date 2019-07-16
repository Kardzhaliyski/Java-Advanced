package com.company;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class SerializeArrayList {
    public static void main(String[] args) {
        Path userDir = Path.of(System.getProperty("user.dir"));

        ArrayList<Double> nums = new ArrayList<>();

        for (int i = 1; i < 1000; i++) {
            nums.add(i * i / 100.0);
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Path.of(userDir.toString() + "\\res\\nums.zarr")))) {
            oos.writeObject(nums);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
