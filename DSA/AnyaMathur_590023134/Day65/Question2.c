// Problem 2
// The Thermostat

#include <stdio.h>

double difference(double a, double b) {
    if (a > b)
        return a - b;
    return b - a;
}

int findClosest(int tree[], int n, double target) {
    int i = 0;
    int closest = -1;
    while (i < n && tree[i] != -1) {
        if (closest == -1 ||
            difference(tree[i], target) < difference(closest, target) ||
            (difference(tree[i], target) == difference(closest, target) && tree[i] < closest)) {
            closest = tree[i];
        }
        if (target < tree[i])
            i = 2 * i + 1;
        else if (target > tree[i])
            i = 2 * i + 2;
        else
            return tree[i];
    }
    return closest;
}

int main() {
    int T;
    printf("Enter number of test cases: ");
    scanf("%d", &T);
    while (T--) {
        int n;
        printf("Enter number of nodes: ");
        scanf("%d", &n);
        int tree[n];
        printf("Enter the BST array (-1 for NULL):\n");
        for (int i = 0; i < n; i++)
            scanf("%d", &tree[i]);
        double target;
        printf("Enter target temperature: ");
        scanf("%lf", &target);
        printf("Closest preset temperature: %d\n", findClosest(tree, n, target));
    }
    return 0;
}