class Solution {
    public int strStr(String haystack, String needle) 
    {
        int size=haystack.length();
        int size1=needle.length();

        if(size1 > size)
        {
            return -1;
        }

        for(int i=0 ; i <= size-size1 ; i++)
        {
            if(haystack.substring(i,i+size1).equals(needle))
            {
                return i;
            }
        }
        return -1;  
    }
}