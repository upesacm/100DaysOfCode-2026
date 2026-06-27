import java.util.*;
class Question2 
{
    public static int smallestWindow(String str) 
    {
        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) 
        {
            set.add(ch);
        }

        int req = set.size();
        int[] freq = new int[256];

        int start = 0, c = 0;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) 
        {
            char ch = str.charAt(i);

            freq[ch]++;
            if (freq[ch] == 1) 
            {
                c++;
            }

            while (c == req) 
            {
                minLen = Math.min(minLen, i - start + 1);
                char leftChar = str.charAt(start);
                freq[leftChar]--;
                if (freq[leftChar] == 0)
                {
                    c--;
                }
                start++;
            }
        }

        return minLen;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.next();
        System.out.println(smallestWindow(str));

        sc.close();
    }
}
