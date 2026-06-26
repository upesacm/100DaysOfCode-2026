# include <stdio.h>
int main(){
    int n,sum=0;
    printf("Enter number of elements in array : ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter elements of array: ");
    for( int i=0;i<n;i++)
    {scanf("%d", &arr[i]);
        sum+=arr[i];
    }
    printf("Sum of array : %d",sum);
}
