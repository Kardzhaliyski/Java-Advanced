package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var currTimeInSecounds = 0;
        var robotsInfo = sc.nextLine().split(";");
        var robotsArr = new Robot[robotsInfo.length];
        for (int i = 0; i < robotsArr.length; i++) {
            robotsArr[i] = new Robot(robotsInfo[i]);
        }

        var startTimeString = sc.nextLine();
        currTimeInSecounds = getTimeInSec(startTimeString);

        var inputProduct = "";
        var productQueue = new ArrayDeque<String>();

        while (!"end".equalsIgnoreCase(inputProduct = sc.nextLine())){
            productQueue.offer(inputProduct);
        }

        while (!productQueue.isEmpty()) {
            currTimeInSecounds++;

            var productProcessed = false;
            for (Robot robot : robotsArr) {
                if(robot.freeFrom <= currTimeInSecounds) {
                    productProcessed = true;
                    addEntryToRobotLog(robot, productQueue.poll(), currTimeInSecounds);
                    robot.freeFrom = currTimeInSecounds + robot.processTime;
                    break;
                }
            }

            if(!productProcessed) {
                productQueue.offer(productQueue.poll());
            }
        }


    }

    private static void addEntryToRobotLog(Robot robot, String product, int currTimeInSecounds) {
        var hours = (currTimeInSecounds / 3600) % 24;
        currTimeInSecounds %= 3600;
        var mins = currTimeInSecounds / 60;
        currTimeInSecounds %= 60;
        var secs = currTimeInSecounds;

        System.out.printf("%s - %s [%02d:%02d:%02d]%n", robot.name, product, hours, mins, secs);
    }

    private static int getTimeInSec(String startTimeString) {
        var timeDataArr = startTimeString.split(":");
        var hours = Integer.parseInt(timeDataArr[0]);
        var mins = Integer.parseInt(timeDataArr[1]);
        var secs = Integer.parseInt(timeDataArr[2]);

        return (hours * 60 * 60) + (mins * 60) + secs;
    }

    private static class Robot {

        private Robot(String robotInfo) {
            var robotData = robotInfo.split("-");
            name = robotData[0];
            processTime = Integer.parseInt(robotData[1]);
        }

        private String name;
        private int processTime;
        private int freeFrom = 0;
    }

}
