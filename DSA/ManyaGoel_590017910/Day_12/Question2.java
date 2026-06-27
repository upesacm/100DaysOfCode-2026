import java.util.*;
public class Question2 {
    public static int smallest_window(String s){
        if(s.length()==0) return 0;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        int window_length=set.size();
        HashMap<Character,Integer> map = new HashMap<>();
        int i=0;int j=0;int window=0;
        int min=Integer.MAX_VALUE;
        for(i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.get(c)==1) window++;
            while(window==window_length){
                min=Math.min(min,i-j+1);
            char left=s.charAt(j);
            map.put(left,map.get(left)-1);
            if(map.get(left)==0){
                map.remove(left);
                window--;
            }
            j++;
            }
        }
    return min;
 }
public static void main(String args[]){
    System.out.println("Enter the string:");
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    System.out.println("Length of Smallest Distinct Window is: "+smallest_window(s));
    sc.close();
    }   
}