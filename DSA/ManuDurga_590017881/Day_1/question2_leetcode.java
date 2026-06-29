import java.util.Scanner;

class question2_leetcode{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();          //this is the size of the input array
        int [] a = new int[n];
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();}     //elements of that array
        int arr1=0;
        int arr2=0;
        for(int i =0;i<n;i++){a[i]=i+1;
        arr1=arr1^a[i];}
        for (int j:nums){arr2=arr2^j;}
        System.out.println(arr1^arr2); 
        sc.close();

     }}