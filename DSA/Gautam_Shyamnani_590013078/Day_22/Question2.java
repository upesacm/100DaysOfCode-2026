public class Question2 {
    public static int[] finalScores(int[] cards){
        int i = 0,j = cards.length - 1;
        int score1 = 0, score2 = 0;
        boolean turn1 = true;

        while(i <= j){
            int pick = (cards[i] > cards[j]) ? cards[i++] : cards[j--];

            if(turn1) score1 += pick;
            else score2 += pick;

            turn1 = !turn1;
        }
        return new int[]{score1,score2};
    }
    public static void main(String[] args){
        int[] cards = {1,2,3,4,5,6,7};
        
        int[] ans = finalScores(cards);
        
        for(int i = 0; i < ans.length;i++){
            System.out.print(ans[i] + " ");
        }
    }
}
