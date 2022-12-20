package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

//        1) Напишите регулярное выражение, которое соответствует любому номеру телефона.
//        Телефонный номер состоит из 7 цифр подряд, 1234567, или из 3х цифр, пробела или тире, а затем из 4 цифр
//        (123-4567, 123 4567).

        String regex = "\\d{3}[\\- ]?\\d{4}";
        System.out.println(Pattern.matches(regex, "097-4567"));
        System.out.println(Pattern.matches(regex, "097 4567"));
        System.out.println(Pattern.matches(regex, "0974567"));
        System.out.println("--------------------------------");


//        2) Напишите регулярное выражение, которое соответствует URL-адресу сайта вида https://someaddress.someending

        String regex1 = "(https://)\\w+\\.[a-zA-Z]+";
        System.out.println(Pattern.matches(regex1, "https://someaddress.someending"));
        System.out.println("--------------------------------");


//        3) Напишите метод поиска в тексте всех слов, начинающихся с определенной буквы.

        String text = "My stay at Wishing Well Farm couldn't last forever, and one afternoon I spotted Dad's car in the " +
                "queue of vehicles in the farmyard.It was great to see Mum and Dad again.";
        findWords(text, 'M');
        findWords(text, 'a');
        System.out.println("--------------------------------");


        //       *4) Напишите метод проверки введенного пароля - от 8 до 15 символов, обязательно содержит цифры, буквы
        //       верхнего и нижнего регистра и спецсимволы.

        System.out.println(checkPassword("98Nata#horb"));
        System.out.println(checkPassword("Nata#horb"));
        System.out.println(checkPassword("nata#horb8"));
    }


    private static void findWords(String text, char ch) {
        Pattern pattern = Pattern.compile("^" + ch + "[a-zA-z]*" + "|\\b+" + ch + "[a-zA-z]*");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
        System.out.println();
    }


    private static boolean checkPassword(String pass) {

        if (pass.length() >= 8 && pass.length() <= 15) {

            Pattern pWordUpper = Pattern.compile("[A-Z]+");
            Pattern pWordLower = Pattern.compile("[a-z]+");
            Pattern pDigit = Pattern.compile("\\d+");
            Pattern pSpecialSymbol = Pattern.compile("\\W+");

            return (pWordUpper.matcher(pass).find() && pWordLower.matcher(pass).find() && pDigit.matcher(pass).find()
                    && pSpecialSymbol.matcher(pass).find());

        }
        return false;
    }

}