package ru.protomorphine.helpers;

public class MathHelper {

    /**
     *
     * Calculates (number mod power)
     *
     * @param number Number
     * @param power Power
     * @return Value of (number mod power)
     */
    public static int mod(int number, int power){
        if (number < power) return number;
        return number % power;
    }

}
