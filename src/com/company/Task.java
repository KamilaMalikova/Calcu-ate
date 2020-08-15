package com.company;

import java.util.HashMap;
import java.util.Map;

public class Task {
    private int a;
    private int b;
    private char operation;
    private Map<String, Integer> numMap = new HashMap<>();
    private boolean isArabic;
    private int mid;

    //    Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b.
//    Данные передаются в одну строку (смотрите пример)! Решения, в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными.
//
//    Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.
//
//    Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по величине и могут быть любыми.
//
//    Калькулятор умеет работать только с целыми числами.
//
//    Калькулятор умеет работать только с арабскими или римскими цифрами одновременно, при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу.
//
//    При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.
//
//    При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, приложение выбрасывает исключение и завершает свою работу.
//

    public Task(String task) {
        this.setNumMap();
        setOperation(task);
        setA(task);
        setB(task);

    }

    private void setNumMap() {
        numMap.put("I", 1);
        numMap.put("II", 2);
        numMap.put("III", 3);
        numMap.put("IV", 4);
        numMap.put("V", 5);
        numMap.put("VI", 6);
        numMap.put("VII", 7);
        numMap.put("VIII", 8);
        numMap.put("IX", 9);
        numMap.put("X", 10);
    }

    private void setA(String task) {
        String value = task.substring(0, mid);
        try{
            if (numMap.containsKey(value)) {this.a = numMap.get(value); isArabic = false;}
            else if(numMap.containsValue(Integer.parseInt(value))){
                this.a = Integer.parseInt(value);
                isArabic = true;
            }
            else {
                System.out.print("Error! A is not found or out of range!"); System.exit(0);
            }
        }catch (Exception ex){
            ex.getStackTrace();
            System.out.print("Error! A is not found or out of range! "); System.exit(0);
        }
    }

    private void setB(String task) {
        String value = task.substring(mid+1, task.length());
        if (numMap.containsKey(value) && !isArabic) this.b = numMap.get(value);
        else if(numMap.containsValue(Integer.parseInt(value)) && isArabic){
            this.b = Integer.parseInt(value);
        }
        else {
            System.out.print("Error! B is not found or out of range!"); System.exit(0);
        }
    }

    private void setOperation(String task) {
        if (task.contains("+")) this.operation(task, '+');
        else if (task.contains("-")) this.operation(task, '-');
        else if (task.contains("*")) this.operation(task, '*');
        else if (task.contains("/")) this.operation(task, '/');
        else {System.out.print("Error! Operator is not found!"); System.exit(0);}

    }
    private void operation(String task, char oper){
        this.operation = oper;
        mid = task.indexOf(oper);
    }

    public String doOperation(){
        int result = 0;
        switch (operation){
            case '-':
                result = Arithmetic.sub(a, b);
                break;
            case '+':
                result = Arithmetic.add(a, b);
                break;
            case '*':
                result = Arithmetic.multiply(a, b);
                break;
            case '/':
                result = Arithmetic.divide(a, b);
                System.out.println(result);
                break;
            default:
                System.out.println("Operation isn't recognized");
                System.exit(1);
                break;
        }
        String stringResult = Integer.toString(result);
        if(!isArabic){
            stringResult = RomanNumerals.ConvertToRoman((int)result);
        }
        return stringResult;
    }
}
