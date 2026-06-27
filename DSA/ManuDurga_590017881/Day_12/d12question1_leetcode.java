package Day_12;
    import java.util.*;
    public class d12question1_leetcode {
    public static int linecount = 0;

    public static int Lines(int[] width, String S) {
        int linewidth = 0;
        for (int i = 0; i < S.length(); i++) {
            int w = width[S.charAt(i) - 'a'];
            if (linewidth + w > 100) {
                linecount++;
                linewidth = w;
            } else {
                linewidth = linewidth + w;
            }
        }
        if (linewidth > 0) linecount++;
        return linewidth;
    }

    public static void main () {
        Scanner sc = new Scanner(System.in);
        System.out.println("String first: ");
        String s = sc.nextLine();   
        System.out.println("Length of Array");   
        int n = sc.nextInt();          // size of the input array
        int[] widths = new int[n];
        for (int i = 0; i < n; i++) {
            widths[i] = sc.nextInt();     // elements of the array
        }
        linecount = 0;
        int[] c = new int[2];
        c[1] = Lines(widths, s);
        c[0] = linecount;
    System.out.println(Arrays.toString(c));    }}