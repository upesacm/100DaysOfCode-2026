
class Strategy{
    public static void main(String[] args){
        int[] cards = {4, 1, 2, 10};
        int left = 0;
        int right = cards.length - 1;
        int p1 = 0;
        int p2 = 0;
        boolean turn = true;  
        while(left <= right){
            int picked;
            if(cards[left] >= cards[right]){
                picked = cards[left];
                left++;
            } 
            else{
                picked = cards[right];
                right--;
            }
            if(turn){
                p1 += picked;
            } 
            else{
                p2 += picked;
            }
            turn = !turn;
        }
        System.out.println("Player 1 Score : " + p1);
        System.out.println("Player 2 Score : " + p2);
    }
}