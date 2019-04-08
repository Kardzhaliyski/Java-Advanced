//package com.company;
//
//import java.security.Timestamp;
//import java.sql.Time;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//
//public class Tests {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        var robotsData = sc.nextLine().split(";");
//        var timeInput = sc.nextLine().split(":");
//        var hours = Integer.parseInt(timeInput[0]);
//        var mins = Integer.parseInt(timeInput[1]);
//        var secs = Integer.parseInt(timeInput[2]);
//        var robots = new LinkedHashMap<String, LocalTime[]>();
//        LocalTime time = LocalTime.of(hours,mins,secs);
//
//        ArrayDeque<String> workingRobots = new ArrayDeque<>();
//
//        for (String robot : robotsData) {
//            String[] data = robot.split("-");
//            String name = data[0];
//            int processTime = Integer.parseInt(data[1]);
//            robots.put(name, new LocalTime[2]);
//            var currRobot = robots.get(name);
//            currRobot[0] = time;
//            currRobot[1] = LocalTime.ofSecondOfDay(processTime);
//            workingRobots.offer(name);
//        }
//
//        var productsQueue = new ArrayDeque<String>();
//
//        var inputProduct = sc.nextLine();
//        while(!inputProduct.equals("End")){
//            productsQueue.offer(inputProduct);
//            inputProduct = sc.nextLine();
//        }
//
//        while(!productsQueue.isEmpty()){
//            time = time.plusSeconds(1);
//            for (Map.Entry<String, LocalTime[]> entry : robots.entrySet()) {
//                var currRobotTimes = entry.getValue();
//                if(currRobotTimes[0].equals(time)){
//                    workingRobots.offer(entry.getKey());
//                }
//            }
//
//            if (workingRobots.isEmpty()) {
//                productsQueue.offer(productsQueue.poll());
//            } else {
//                String robot = workingRobots.poll();
//                String product = productsQueue.poll();
////                System.out.println(robot + " - " + product + " [" + time + "]");
//                printTookProduct(robot, product, time);
//                var currRobot = robots.get(robot);
//                currRobot[0] = time.plusSeconds(currRobot[1].toSecondOfDay());
//            }
//
//
//
//        }
//
//    }
//
//    public static void printTookProduct(String robot, String product, LocalTime time){
//        DateTimeFormatter formater = DateTimeFormatter.ofPattern("HH:mm:ss");
//        System.out.printf("%s - %s [%s]%n", robot, product, time.format(formater));
//    }
//}
