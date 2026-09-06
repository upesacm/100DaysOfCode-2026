
class PT{
    public static boolean isPowerOfTwoOrZero(int n){
        if(n == 0){
            return true;
        }
        return(n & (n - 1)) == 0;
    }
    public static void main(String[] args){
        int n = 0;
        boolean answer = isPowerOfTwoOrZero(n);
        System.out.println(answer);
    }
}