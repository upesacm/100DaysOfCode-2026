#include <stdio.h>
#include <string.h>

int main() {
    char user[1000];
    printf("Enter the username: ");
    fgets(user, sizeof(user), stdin);
    user[strcspn(user, "\r\n")] = '\0';

    int arr[26] = {0};
    int ans = 0;

    for(int i = 0; user[i] != '\0'; i++){
        int id = user[i] - 'a';

        if (!arr[id]) {
            arr[id] = 1;
            ans++;
        }
    }
    if (ans%2 == 0){
        printf("CHAT WITH HER!");
    }
    else printf("IGNORE HIM!");

    return 0;
}