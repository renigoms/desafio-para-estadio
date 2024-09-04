package org.example;

public class Question02 {
    static String isFibonacci(int number){
        int value = 0, nextValue = 1;
        if (number == 0)
            return "O valor %s faz parte da sequência de fibonacci".formatted(number);
        while (value < number){
            if (nextValue == number)
                return "O valor %s faz parte da sequência de fibonacci".formatted(number);
            int oldValue = nextValue;
            nextValue += value;
            value = oldValue;
        }
        return "O valor %s não faz parte da sequência de fibonacci".formatted(number);
    }
    public static void main(String[] args) {
        System.out.println(isFibonacci(1597));
    }
}