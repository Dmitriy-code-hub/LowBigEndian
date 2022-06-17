package com.company;
import java.lang.Math;
import java.math.BigInteger;
import java.util.Random;

public class Main {

public static int [] toLowEndian (int x) {
    int [] result = new int[4];
    int k = x;
    int i = 0;
    while (k>0){result [i] = k%256;
    k/=256;
    i++;
    }
    return result;
    }

public static int [] toBigEndian (int x) {int [] result = new int[4];
    int k = x;
    int i = 3;
    while (k>0){result [i] = k%256;
        k/=256;
        i--;
    }
    return result;
}
    public static void showarray (int [] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a [i]);
        }
        System.out.println();
    }

    public static void showarray (byte [] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i]<0) {
                System.out.println(256+a[i]);
            } else
                System.out.println(a [i]);
        }
        System.out.println();
    }
    public static int fromBigEndian (int [] a) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result = result*256 + a[i];
        }
        return result;
    }

    public static int fromLowEndian (int [] a) {
    int m=1;
    int result = 0;
     //   for (int i = a.length-1; i >=0; i--) {
        for (int i = 0; i < a.length; i++) {
            result += a[i]*m;
            m*=256;
        }
        return result;
    }

    public static void main(String[] args) {
    int y=0;
    Random r = new Random();

        for (int i = 0; i < 10; i++) {
            System.out.println("-----------------------------------------");
         int x = r.nextInt();
         x= Math.abs(x);
            System.out.println("x=");
            System.out.println(x);
            int []a = toLowEndian(x);
            showarray(a);
            y = fromLowEndian(a);
            System.out.println("fromLowEndian");
            System.out.println(y);
            int []b = toBigEndian(x);
            showarray(b);
            System.out.println("fromBigEndian");
            y = fromBigEndian(b);
            System.out.println(y);
           /* int z1 = fromLowEndian(a);
            System.out.println(z1);
            System.out.println(x);
            int z2 = fromBigEndian(a);
            System.out.println(z2);*/
           // private byte[] bigIntToByteArray( final int i ) {
                BigInteger bigInt = BigInteger.valueOf(x);
                byte []f = bigInt.toByteArray();
            System.out.println("SystemFunction");
            showarray(f);

            //    return bigInt.toByteArray();}
                    }

    }
}
