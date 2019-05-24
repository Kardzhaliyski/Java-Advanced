package com.company;

import java.security.Timestamp;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RoboticsWay2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var robotsData = sc.nextLine().split(";");
        var timeInput = sc.nextLine().split(":");
        var hours = Integer.parseInt(timeInput[0]);
        var mins = Integer.parseInt(timeInput[1]);
        var secs = Integer.parseInt(timeInput[2]);
        var robots = new LinkedHashMap<String, LocalDateTime[]>();
        LocalDateTime time = LocalDateTime.of(
                1900,
                1,
                1,
                hours,
                mins,
                secs);


        for (String robot : robotsData) {
            String[] data = robot.split("-");
            String name = data[0];
            int processTime = Integer.parseInt(data[1]);
            robots.put(name, new LocalDateTime[2]);
            var currRobot = robots.get(name);
            currRobot[0] = time;
            currRobot[1] = LocalDateTime.of(
                    1900,
                    1,
                    1,
                    0,
                    0,
                    0)
                    .plusSeconds(processTime);
            //workingRobots.offer(name);
        }

        var productsQueue = new ArrayDeque<String>();

        var inputProduct = sc.nextLine();
        while (!inputProduct.equals("End")) {
            productsQueue.offer(inputProduct);
            inputProduct = sc.nextLine();
        }

        while (!productsQueue.isEmpty()) {
            time = time.plusSeconds(1);


            boolean productProcessed = false;
            for (Map.Entry<String, LocalDateTime[]> entry : robots.entrySet()) {
                var currRobotTimes = entry.getValue();
                if (currRobotTimes[0].isBefore(time) || currRobotTimes[0].equals(time)) {
                    productProcessed = true;
                    String robot = entry.getKey();
                    String product = productsQueue.poll();
                    printTookProduct(robot, product, time);
                    var currRobot = robots.get(robot);
                    currRobot[0] = time
                            .plusSeconds(currRobot[1].getSecond()
                                    + currRobot[1].getMinute()
                                    * 60
                                    + currRobot[1].getHour()
                                    * 3600);
                    break;
                }
            }

            if(!productProcessed){
                productsQueue.offer(productsQueue.poll());
            }
        }
    }

    public static void printTookProduct(String robot, String product, LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.printf("%s - %s [%s]%n", robot, product, time.format(formatter));
    }

}