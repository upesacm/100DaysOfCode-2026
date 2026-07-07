#include <stdio.h>

int main(){

  int n;
  printf("Enter the size of array: ");
  scanf("%d",&n);
  int arr[n];
  printf("Enter array elements: ");
  for(int i=0;i<n;i++){
    scanf("%d",&arr[i]);
  }

  int score1=0,score2=0,turn=0;
  int left=0,right=n-1;
  while(left<=right){
    if(turn==0){
      if(arr[right]>arr[left]){
      score1=score1+arr[right];
      right--;
    }
    else{
      score1=score1+arr[left];
      left++;
    }
    turn=1;
    }
    else{
      if(arr[right]>arr[left]){
      score2=score2+arr[right];
      right--;
    }
    else{
      score2=score2+arr[left];
      left++;
    }
    turn=0;
    }  
  }

  printf("%d %d",score1,score2);

  return 0;
}
