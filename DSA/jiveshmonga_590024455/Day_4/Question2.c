void rotate(int arr[],int n,int k)
{
    k=k%n;
    for(int i=0;i<k;i++)
    {
        int last=arr[n-1];
            for(int j=n-1;j>0;j++)
            {
                arr[j]=arr[j-1];
            }
        arr[0]=last;
    }
}
