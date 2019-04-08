package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var shopsCatalogue = new TreeMap<String, LinkedHashMap<String, Double>>();

        while (true) {
            String[] inputData = sc.nextLine().split(", ");

            if (inputData[0].equals("Revision")) {
                break;
            }

            var shopName = inputData[0];
            var productName = inputData[1];
            var productPrice = Double.parseDouble(inputData[2]);

            shopsCatalogue.putIfAbsent(shopName, new LinkedHashMap<>());
            shopsCatalogue.get(shopName)
                    .put(productName, productPrice);
        }

        for (Map.Entry<String, LinkedHashMap<String, Double>> shop : shopsCatalogue.entrySet()) {
            System.out.printf("%s->%n", shop.getKey());
            for (Map.Entry<String, Double> product : shop.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n",
                        product.getKey(),
                        product.getValue());
            }
        }
    }
}
