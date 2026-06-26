import java.util.Scanner;
class Question2 {
    public void rotate(int[] nums, int k){
        int size=nums.length;
        k=k%size;
        reverse(nums,0,size-1);
        reverse(nums,0,k-1);
        reverse(nums,k,size-1);
    }
    public void reverse(int[] nums,int start,int last){
        while(start<last){
        int temp=nums[start];
        nums[start]=nums[last];
        nums[last]=temp;
        start++;
        last--;
    }        
    }
    public static void main(String[] args) {
        Question2 object=new Question2();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size=sc.nextInt();
        int[] nums=new int[size];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<size;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println("Enter the number of positions to rotate");
        int k=sc.nextInt();
        object.rotate(nums,k);
        System.out.println("Array after rotation:");
        for(int i=0;i<size;i++){
            System.out.print(nums[i]+" ");
        }
    }
}