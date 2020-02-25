package familytree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> inputData = new ArrayList<>();

            var line = bfr.readLine();
            var mainPersonData = line;

            line = bfr.readLine();
            while (!line.equals("End")) {
                inputData.add(line);

                line = bfr.readLine();
            }

            Map<String, Person> people = new HashMap<>();
            Map<String, String> peopleDataByBirthday = new HashMap<>();

            for (String data : inputData) {
                if(!data.contains("-")) {
                    var tokens = data.split("\\s+");
                    var name = tokens[0] + " " + tokens[1];
                    var birthday = tokens[2];
                    peopleDataByBirthday.putIfAbsent(birthday, name);
                    people.putIfAbsent(name, new Person(name, birthday));
                }
            }

            for (Map.Entry<String, String> nameBirthdayPair : peopleDataByBirthday.entrySet()) {
                var name = nameBirthdayPair.getValue();
                var birthday = nameBirthdayPair.getKey();

                people.putIfAbsent(name, new Person(name, birthday));
            }



            for (String data : inputData) {
                if(!data.contains("-")) {
                    continue;
                }

                Person parent;
                Person child;
                var tokens = data.split(" - ");

                if(tokens[0].contains("/")) {
                    var parentName = peopleDataByBirthday.get(tokens[0]);
                    parent = people.get(parentName);
                } else {
                    var parentName = tokens[0];
                    parent = people.get(parentName);
                }

                if(tokens[1].contains("/")) {
                    var childName = peopleDataByBirthday.get(tokens[1]);
                    child = people.get(childName);
                } else {
                    var childName = tokens[1];
                    child = people.get(childName);
                }

                people.get(parent.getName()).addChild(child);
                people.get(child.getName()).addParent(parent);
            }

            String mainPersonName;
            if(mainPersonData.contains("/")) {
                mainPersonName = peopleDataByBirthday.get(mainPersonData);
            } else {
                mainPersonName = mainPersonData;
            }

            people.get(mainPersonName).printFamilyTree();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
