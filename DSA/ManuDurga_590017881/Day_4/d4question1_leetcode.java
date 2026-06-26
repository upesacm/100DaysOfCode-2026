package Day_4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class d4question1_leetcode{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();          //this is the size of the input array
        int m = sc.nextInt();
        int[][]matrix = new int[m][n];
        for (int i = 0; i <m; i++) {
            for(int j = 0; j<n;j++) 
            matrix[i][j] = sc.nextInt();}     //elements of that array
        int [][]copy = new int [n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copy[i][j]=matrix[j][i];
            }
        }for(int []i:copy){for(int j:i){}
        System.out.println(Arrays.toString(i));}
        
    }
}