package DSA.MeghnaDhakad_590013960.Day_4;
import java.util.*;

public class Question1_Leetcode{
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6}};

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] ans = new int[n][m];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        System.gc();
        System.out.println(Arrays.deepToString(ans));
    }
}