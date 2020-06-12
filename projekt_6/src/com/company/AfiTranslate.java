package com.company;
class Afi
{

    // Podstawowę wartości a i b
    static int a = 3;
    static int b = 12;

    static String encryptMessage(char[] msg)
    {

        String Afiniczny = "";
        for (int i = 0; i < msg.length; i++)
        {
            /* pomijanie pustych znaków
             zastosowywanie wzoru ( a x + b ) mod m
            m =  26 (ilosc liter andl alfabetu)
            */
            if (msg[i] != ' ')
            {
                Afiniczny = Afiniczny
                        + (char) ((((a * (msg[i] - 'A')) + b) % 26) + 'A');
            } else
            {
                Afiniczny += msg[i];
            }
        }
        return Afiniczny;
    }

    static String decryptCipher(String cipher)
    {
        String msg = "";
        int a_inv = 0;
        int flag = 0;

        for (int i = 0; i < 26; i++)
        {
            flag = (a * i) % 26;
            // Równanie to ma dokładnie jedno rozwiązanie dla każdego a ∈ Zm  wtedy i tylko wtedy, gdy  największy wspólny dzielnik a i m = 1
            if (flag == 1)
            {
                a_inv = i;
            }
        }
        for (int i = 0; i < cipher.length(); i++)
        { 
            //stosowanie wzoru  a^-1 ( x - b ) mod m

            if (cipher.charAt(i) != ' ')                //znów pomijamy białe znaki
            {
                msg = msg + (char) (((a_inv * ((cipher.charAt(i) + 'A' - b)) % 26)) + 'A');
            }
            else
            {
                msg += cipher.charAt(i);
            }
        }

        return msg;
    }


    public String AfiTranlate(String str, boolean x, int a2, int b2)
    {
        boolean bol = x;
        a =a2;
        b=b2;
        String msg = str;
    if(bol==true) {
        String cipherText = encryptMessage(msg.toCharArray());

        return cipherText;
    }

        return decryptCipher(msg);
    }
} 
  