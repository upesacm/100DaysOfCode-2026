package DSA.Mugdha_590015431.Day_4;
import java.util.*;
public class Question1_LeetCode {
    public static int[][] transpose(int[][] matrix){
        int rows=matrix.length;
        int cols=matrix[0].length;
        int[][] result=new int [cols][rows];
                for (int i = 0; i < rows; i++){
            for(int j=0;j<cols;j++){
                result[j][i]=matrix[i][j];
            }
        }
        return result;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        int[][] matrix=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        int[][] ans=transpose(matrix);
        for(int i=0;i<ans.length;i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
        sc.close();
    }
}

