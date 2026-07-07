public class Q2 {
    
    public static void calculateScores(int[] cards) {
        int left = 0;
        int right = cards.length - 1;
        
        int player1Score = 0;
        int player2Score = 0;
        boolean player1Turn = true;
        
        while (left <= right) {
            int pickedCard;
            
            if (cards[left] > cards[right]) {
                pickedCard = cards[left];
                left++;
            } else {
                pickedCard = cards[right];
                right--;
            }
            
            if (player1Turn) {
                player1Score += pickedCard;
            } else {
                player2Score += pickedCard;
            }
            
            player1Turn = !player1Turn;
        }
        
        System.out.println(player1Score + " " + player2Score);
    }

    public static void main(String[] args) {
        int[] cards = {4, 1, 2, 10};
        System.out.print("Input: [4, 1, 2, 10] -> Output: ");
        calculateScores(cards);
    }
}
