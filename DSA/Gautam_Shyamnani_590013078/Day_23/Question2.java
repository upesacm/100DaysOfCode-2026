import java.util.*;

class Question2{

    public static int getNextValidIndex(String s,int i){
    int skip = 0;

    while(i >= 0){
        if(s.charAt(i) == '#'){
            skip++;
            i--;
        }else if(skip > 0){
            skip--;
            i--;
        }else{
            return i;
        }
    }
    return -1;
}

public static boolean backspaceCompare(String s, String t){
    int i = s.length() - 1;
    int j = t.length() - 1;

    while(i >= 0 || j >= 0){
        i = getNextValidIndex(s,i);
        j = getNextValidIndex(t,j);

        if(i < 0 && j < 0) return true;
        if(i < 0 || j < 0) return false;

        if(s.charAt(i) != t.charAt(j)) return false;

        i--;
        j--;
    }
    return true;
}

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string s: ");
        String s = sc.next();

        System.out.print("Enter string t: ");
        String t = sc.next();

        if(backspaceCompare(s,t))
            System.out.println("true");
        else
            System.out.println("false");

        sc.close();
    }
}