import java.util.Scanner;
public class question1_technical {
    public static void main(String[] args){
        int totalNumberSum=0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();          //this is the size of the input array
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();totalNumberSum=totalNumberSum+nums[i];}
            System.out.println(totalNumberSum);
            sc.close();
}}
