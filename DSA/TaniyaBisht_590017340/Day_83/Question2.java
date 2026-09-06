
class CB{
    public static int countBits(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 13;
        int result = countBits(n);
        System.out.println("Number of set bits:" + result);
    }
}