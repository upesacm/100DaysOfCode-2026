#include <stdio.h>
int main(){
  int n,ans1=0,ans2=0,turn=0;
  printf("Enter the size:");
  scanf("%d",&n);
  int arr[n];
  for(int i=0;i<n;i++){
     printf("Enter element:");
    scanf("%d",&arr[i]);
  }
  int l=0,r=n-1;
  while(l<=r){
    if(turn==0){
      if(arr[r]>arr[l]){
      ans1=ans1+arr[r--];
    }
    else{
      ans1=ans1+arr[l];
      l++;
    }
    turn=1;
    }
    else{
        if(arr[r]>arr[l]) ans2=ans2+arr[r--];
    else{
      ans2=ans2+arr[l++];
    }
    turn=0;
    }  
  }

  printf("%d %d",ans1,ans2);

  return 0;
}
