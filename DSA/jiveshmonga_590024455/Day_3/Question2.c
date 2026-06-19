int abc(int arr[],int n,int target )

{
    int count=0;
    for(int i=0;i<n;i++)
    {
        if(arr[i]==target)
        {
            count++;
        }
    }
    return count;
}
