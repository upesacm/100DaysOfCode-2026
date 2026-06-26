import java.util.Scanner;
public class Question2 {
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the length of array num1:");
    int n=sc.nextInt();
    System.out.println("Enter the length of array num2:");
    int m=sc.nextInt();
    int num1[]=new int[n];
    int num2[]=new int[m];
    System.out.println("Enter the elements of array num1:");
    for(int i=0;i<n;i++){
        num1[i]=sc.nextInt();
    }
    System.out.println("Enter the elements of array num2:");
    for(int i=0;i<m;i++){
        num2[i]=sc.nextInt();
    }
    Question2 q=new Question2();
    if(q.Identical(num1, num2)){
        System.out.println("The two arrays are identical.");
    }
    else{
        System.out.println("The two arrays are not identical.");
    }

}
   public boolean Identical(int num1[],int num2[]){
        if(num1.length!=num2.length){
            return false;
        }
        for(int i=0;i<num1.length;i++){
            if(num1[i]!=num2[i]){
                return false;
            }
        }
        return true;
    }
}