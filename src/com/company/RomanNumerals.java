package com.company;

public class RomanNumerals {
    public static String ConvertToRoman(int number){
        if (number <= 10){
            return Units.values()[number].name();
        }
        else if (number == 100){
            return Dozens.C.name();
        }
        else {
            int dozen = number/10;
            int unit = number%10;
            if (unit == 0){
                return Dozens.values()[dozen-1].name();
            }
            else return Dozens.values()[dozen-1].name()+Units.values()[unit];
        }
    }
}
