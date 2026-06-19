package Day_4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class d4question2_technical{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a=0;
        int n = sc.nextInt();          //this is the size of the input array
        int k = sc.nextInt();
        int[] Arr = new int[n];
        for (int i = 0; i < n; i++) {
            Arr[i] = sc.nextInt();}     //elements of that array
        int[] copy = new int[n];
        for(int i=Arr.length-k;i<2*(Arr.length)-k;i++){
            if(i>Arr.length-1){copy[a]=Arr[i%Arr.length];a++;}
            else{
            copy[a]=Arr[i];a++;}
            
        }
        System.out.println(Arrays.toString(copy));
        }
    }