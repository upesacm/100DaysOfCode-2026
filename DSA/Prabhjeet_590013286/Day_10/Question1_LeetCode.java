//Find First Occurrence in String
//Return starting index of needle in haystack

class Solution {

    public int strStr(String haystack, String needle) {

        return haystack.indexOf(needle);
    }
}

//logic: use built-in indexOf().
//returns first index if found.
//returns -1 if substring is not present.