/*Rotate Array by K Steps
Explanation
Given an integer array and an integer k, rotate the array to the right by k steps.

Example
Input:nums = [1,2,3,4], k = 3. Output:[2,3,4,1] */
import java.util.Scanner;
public class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int length = scanner.nextInt();
        int[] array = new int[length];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Enter value: ");
        int value = scanner.nextInt();
        Question2 question2 = new Question2();
       
        question2.rotate(array, value);
        System.out.println("Rotated array: ");
        for (int num : array) { 
            System.out.print(num + " ");
        }
        System.out.println();       

    }
    public void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] array, int value) {
       reverse(array, 0, array.length - 1);
       reverse(array, 0, value - 1);
       reverse(array, value, array.length - 1);
    }
}