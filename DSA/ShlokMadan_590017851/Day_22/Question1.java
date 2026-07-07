public class Question1 {
    public static void moveZeroes(int[] nums)
    {
        int index=0;
        for(int i=0;i<nums.length;i++)
            {
            if(nums[i]!=0)
                {
                int temp=nums[index];
                nums[index]=nums[i];
                nums[i]=temp;
                index++;
            }
        }
    }
    public static void main(String[] args)
    {
        int[] nums={0,1,0,3,12};
        moveZeroes(nums);
        System.out.print("[");
        for(int i=0;i<nums.length;i++)
            {
            System.out.print(nums[i]);
            if(i!=nums.length-1)
                System.out.print(",");
        }
        System.out.println("]");
    }
}