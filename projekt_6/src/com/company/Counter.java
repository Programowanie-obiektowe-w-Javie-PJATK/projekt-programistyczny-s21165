package com.company;



class Counter {
    String answer="Wystepowanie: ";
    public String licznik (String str)
    {

        int count[] = new int[256];
        int leng= str.length();

        //tablica z znakami
        for (int i = 0; i < leng; i++)
            count[str.charAt(i)]++;

        //iniciowanie pętli o długości Striing
        char ch[] = new char[str.length()];
        for (int i = 0; i < leng; i++) {
            ch[i] = str.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {

                //jeżeli się powtarza
                if (str.charAt(i) == ch[j])
                    find++;
            }

            if (find == 1)  answer = answer + str.charAt(i) + " jest " + count[str.charAt(i)]+ " ";
        }  return answer;
    }



} 