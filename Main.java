package com.example.mypackage;


import java.io.*;
import java.util.Scanner;
/* Caesar cipher is one of the simplest encryption technique. It is also known as the shift cipher,
 Caesar's cipher, Caesar shift or Caesar's code. Caesar cipher is a type of substitution cipher.
By using this cipher technique we can replace each letter in the plaintext with different one
a fixed number of places up or down the alphabet.*/
public class Main {
    Scanner scanner = new Scanner( System.in );
    int offset = scanner.nextInt();

    //That method will encrypt the message using the Caesar cipher.
    public String encrypt(String s) throws IOException
    {

        StringBuilder sb=new StringBuilder();
        // if alphabet lies between 'A'and 'Z'

        for(int i=0;i<s.length();i++)
        {
            char t=s.charAt(i);
            if(t>='A' && t<='Z')
            {
                int t1=t-'A'+offset;
                //
                t1=t1%26;
                sb.append((char)(t1+'A'));
            }
            // if alphabet lies between a and z
            else if(t>='a' && t<='z')
            {
                int t1=t-'a'+offset;
                t1=t1%26;
                sb.append((char)(t1+'a'));
            }
        }
        return sb.toString();
    }


//That method will decrypt the message using the Caesar cipher.

    public String decrypt(String s) throws IOException
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char t=s.charAt(i);
            if(t>='A' && t<='Z')
            {
                int t1=t-'A'-offset;
                if(t1<0)t1=26-t1;
                sb.append((char)(t1+'A'));
            }
            else if(t>='a' && t<='z')
            {
                int t1=t-'a'-offset;
                if(t1<0)t1=26-t1;
                sb.append((char)(t1+'a'));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        try
        {
            System.out.println("Կեսարի գաղտնագիր");
            BufferedReader b;
            String oriTxt,encTxt,decTxt;
            System.out.println("Ներմուծիր տեքստը:");
            b=new BufferedReader(new InputStreamReader(System.in));
            oriTxt=b.readLine();
            System.out.println("Գաղտանագրում եք թե՞ վերծանում");
            String k=b.readLine();
            System.out.println("Ներմուծիր բանալին");
            Main c=new Main();
            encTxt=c.encrypt(oriTxt);
            switch (k){
                case "g":
                    System.out.println("Encoded :"+encTxt);
                case "v": {
                    decTxt = c.decrypt(encTxt);
                    System.out.println("Decrypted :" + decTxt);
                }
            }}
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}