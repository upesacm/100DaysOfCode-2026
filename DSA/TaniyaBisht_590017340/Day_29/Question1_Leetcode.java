
class Solution {
    Map<Character,Character> map= new HashMap<>();
    public boolean isValid(String s) {
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        int top=-1;
        for(int i=0; i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsValue(c)){
                top=i;
            }
            else{
                if(top==-1 || map.get(c)!=s.charAt(top)){
                    return false;
                }
                else{
                    top=getTop(s,top-1);
                }
            }
        }
        return top==-1;
    }
    int getTop(String s, int ind){
        int right=0;
        while(ind>=0){
            char ch=s.charAt(ind);
            if(map.containsKey(ch)){
                right++;
            }
            else{
                right--;
            }
            if(right<0){
                return ind;
            }
            ind--;
        }
        return -1;
    }
}