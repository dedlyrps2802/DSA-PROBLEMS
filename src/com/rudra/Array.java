package com.rudra;

public class Array {
    public static void main(String[] args) {
        int [] arr = {1,3,2,7,8,6,9};
        int s=0;
        for (int i = 0; i <arr.length ; i++) {
            s=s+arr[i];
        }
        System.out.println("The sum of all elments are :"+s);

        int a =0;
        for (int j = 0; j <arr.length ; j=j+2) {
            a=a+arr[j];

        }
        System.out.println("The sum of all elements at even indices are :"+a);

        int b=0;
        for (int k = 1; k <arr.length ; k=k+2) {
            b=b+arr[k];
        }
        System.out.println("The sum of all elements at odd indices are :"+b);
    }

}
