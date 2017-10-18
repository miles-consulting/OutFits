package com.outfittery.assignment.utils;

import java.util.Random;

public class RandomDataGenerator {
    public static String generateRandomNumber() {
        Random rand = new Random();
        return String.valueOf(Math.abs(rand.nextInt()));
    }
}
