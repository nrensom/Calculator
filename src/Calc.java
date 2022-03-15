import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Calc {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        String str = a.nextLine();
        String array[] = str.split(" ");
        if(array.length==3) {
            String str1 = array[0];
            String str3 = array[2];
            int num1;
            int num2 ;
            char myChar = array[1].charAt(0);
            Calculator result = new Calculator();

            if(isNumeric(str1, str3)) {
            num1 = parseInt(array[0]);
            num2 = parseInt(array[2]);
            if (num1 > 0 && num1 <= 10 && num2 > 0 && num2 <= 10) {
            int z = result.calculator(num1, num2, myChar);
            System.out.println(z);
        }
            else {
                System.out.println("throws Exception!");
            }}
            else {
            num1  = RomanToDecimal.romanToDecimal(array[0]);
            num2  = RomanToDecimal.romanToDecimal(array[2]);
                if (num1 > 0 && num1 <= 10 && num2 > 0 && num2 <= 10){
                    int z = result.calculator(num1, num2, myChar);
                    if ( z>0){
                        String l = DecimalToRoman.intToRoman(z);
                        System.out.println(l);
                    }
                    else {
                        System.out.println("throws Exception");
                    }
                }
                else {
                System.out.println("throws Exception");}
            }
        }
        else {
            System.out.println("throws Exception");
        }
    }


    public static boolean isNumeric(String str1, String str3) {
        int intValue;
        int intValue2;
        try {
            intValue = Integer.parseInt(str1) ;
            intValue2 = Integer.parseInt(str3);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }}
    class Calculator {
        public static int calculator(int num1, int num2, char myChar) {

            int x = num1;
            int y = num2;
            int result1 = 0;
                switch (myChar) {
                    case '+':
                        result1 = x + y;
                        break;

                    case '-':
                        result1 = x - y;
                        break;

                    case '*':
                        result1 = x * y;
                        break;

                    case '/':
                        result1 = x / y;
                        break;

                    default: System.out.println("throws Exception");

                        break;}
            return result1;}
        }
class DecimalToRoman {
    static int [] numbers = {100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] str = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public static String intToRoman(int num){
        StringBuilder st = new StringBuilder();
        for(int i = 0; i<numbers.length && num > 0; i++){
            while (num >= numbers[i]) {
                num -= numbers[i];
                st.append(str[i]);
            }
        }
        return st.toString();
    }
}

class RomanToDecimal {
    public static int romanToDecimal(String romanNumber) {
        int decimal = 0;
        int lastNumber = 0;
        String romanNumeral = romanNumber;

        for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
            char convertToDecimal = romanNumeral.charAt(x);

            switch (convertToDecimal) {
                case 'M':
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;

                case 'D':
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;

                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;

                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;

                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;

                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;

                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
        }
        return decimal;
    }

    public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }

    public static void main(java.lang.String args[]) {
        romanToDecimal("XIV");
    }}

