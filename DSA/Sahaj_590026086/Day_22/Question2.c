#include <stdio.h>
int main(){
    int n;
    printf("Enter number of cards: ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter card values:\n");
    for(int i=0;i<n;i++){
        printf("Enter the value for card %d:",i+1);
        scanf("%d", &arr[i]);
    }
    int left=0, right=n-1;
    int p1=0,p2=0;
    int turn=0;
    while(left<=right){
        int pick;
        if(arr[left]>arr[right]){
            pick=arr[left++];
        }else{
            pick=arr[right--];
        }
        if(turn==0){
            p1+=pick;
        }else{
            p2+=pick;
        }
        turn=1-turn;
    }
    printf("%d %d\n", p1, p2);
    return 0;
}
