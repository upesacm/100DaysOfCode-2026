int missingNumber(int* n, int b) {
    int a=b*(b+1)/2;
    int c=0;


    for(int i=0;i<b;i++)
    {
        c+=n[i];
    }

    return a-c;
}
