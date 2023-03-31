package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class OrderCreator {
    private static Random _rnd = new Random();
    private static String generateSymbol() {
        char[] chars = "QWERTYUIOPASDFGHJKLMNBVCXZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 7; i++) {
            if(i == 4) {
                sb.append('.');
            } else {
                sb.append(chars[_rnd.nextInt(0, chars.length)]);
            }
        }
        return sb.toString();
    }

    public static Order generateOrder() {
        return new Order(_rnd.nextInt(1000), generateSymbol(), _rnd.nextFloat(10000), Order.Side.values()[_rnd.nextInt(0, Order.Side.values().length)]);
    }

    public static ArrayList<Order> generateMultipleOrders(int howMany) {
        ArrayList<Order> orders = new ArrayList<>();
        for(int i = 0; i < howMany; i++) {
            orders.add(generateOrder());
        }
        return orders;
    }
}
