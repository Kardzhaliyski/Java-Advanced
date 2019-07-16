package com.company;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializeCustomObject {
    public static void main(String[] args) {
        Path userDir = Paths.get(System.getProperty("user.dir"));
        Path pathOut = Path.of(userDir + "\\res\\course.ser");
        Course math = new Course("mathematic", 734);
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(pathOut))){
            oos.writeObject(math);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Course test = null;
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(pathOut))) {
            test = (Course) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println();
    }

      static class Course implements java.io.Serializable {
        Course(String name, int students){
            this.name = name;
            this.numOfStudents = students;
        }
        String name;
        int numOfStudents;
    }
}
