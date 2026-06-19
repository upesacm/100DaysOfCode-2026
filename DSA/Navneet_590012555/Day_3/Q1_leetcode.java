class Solution 
{
    public int[] plusOne(int[] d) 
    {
    for (int i = d.length - 1; i >= 0; i--)
        if (d[i] < 9) { d[i]++; return d; }
        else d[i] = 0;
    int[] a = new int[d.length + 1];
    a[0] = 1;
    return a;
}
}