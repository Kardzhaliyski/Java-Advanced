package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class DeSerializeArrayList {
    public static void main(String[] args) {
        Path userDir = Path.of(System.getProperty("user.dir"));

        ArrayList<Double> nums = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(
                Files.newInputStream(Path.of(userDir + "\\res\\nums.zarr")))) {
            nums = (ArrayList<Double>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println();
    }
}
