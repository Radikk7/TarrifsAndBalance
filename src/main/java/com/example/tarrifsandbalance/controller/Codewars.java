package com.example.tarrifsandbalance.controller;

import java.util.Arrays;

public class Codewars {
    public static void main(String[] args) {
        System.out.println(pigIt("Hello world !").equals("elloHay orldway !"));
    }

    //Переместите первую букву каждого слова в конец, а затем добавьте «ay» в конец слова.
    // Оставьте знаки препинания нетронутыми.

        public static String pigIt(String str) {
          String [] array= str.split(" ");
            String a ="";
            for (int i = 0; i < array.length; i++) {
                if (array[i].matches("[a-zA-Z]+")) {
                    array[i] = conveertWord(array[i]);
                   a = a + " " + array[i];
                } else {
                    a = a + " " + array[i];
                }
            }
            return a.substring(1);
        }

        public static String conveertWord(String str){
            char first= str.charAt(0);
            str= str.substring(1) + first + "ay";
            return str;
        }


}


