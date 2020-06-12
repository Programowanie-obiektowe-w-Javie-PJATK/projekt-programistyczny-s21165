package com.company;
import java.io.IOException;


public class MorsTranslate {

    public String Mors(String str, Boolean bol) throws IOException {

boolean bolek=bol;

        String sentence = "", answer = "", answer1 = "";
        char[] english = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
                'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
                ',', '.', '?'};   // tablica zawierająca angiielski alfabet wraz z cyframi

        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--.."};  // tablica znaków morsa wypisywana w tej samej kolejności co powyższa


        if (bolek == true) {
            sentence = str;

            sentence = sentence.toLowerCase(); // zamiana na małe znaki, wielkość nie ma tutaj znaczenia ponieważ alfabet morsa zawiera tylko małe
            char[] morsec = sentence.toCharArray();
            for (int i = 0; i < morsec.length; i++)  // przechodzi przez wszystkie znaki morsa ponieważ każda literka musi znaleźć swoją parę morsa
            {
                for (int j = 0; j < english.length; j++) {
                    if (english[j] == morsec[i])  // jeżeli mają tą samą wartość literalną znaczy, że są odpowiadającę
                    {
                        answer = answer + morse[j] + " ";
                    }
                }
            }

            System.out.println(answer);
            return answer;
        } else if (bolek == false) {
            sentence = str;
            String[] morsec = sentence.split(" ");   // rozdzielanie poprzez biały znak
            for (int i = 0; i < morsec.length; i++) {

                for (int j = 0; j < morse.length; j++) {
                    if (morse[j].equals(morsec[i]))  // szukanie pary
                    {
                        answer1 = answer1 + english[j];  //jeżeli mają tą samą wartość literalną znaczy, że są odpowiadającę
                    }
                }
            }
        }
        return answer1;
        }





    }
