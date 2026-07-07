public class Question1_Leetcode {
     public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // Sort the array of children's greed factors in ascending order
        Arrays.sort(s); // Sort the array of cookie sizes in ascending order
        int child=0; // Initialize a pointer for the children greed array
        int cookie=0; // Initialize a pointer for the cookies array

// Loop through both arrays until we reach the end of either array
        while(child < g.length && cookie < s.length){ 
            // If the current cookie can satisfy the current child's greed factor, move to the next child
            if(g[child]<=s[cookie]){
                child++;
            }
            cookie++; // Move to the next cookie regardless of whether the current cookie satisfied the current child or not
        }
        return child;// Return the total number of children that can be satisfied 
    }
    
}