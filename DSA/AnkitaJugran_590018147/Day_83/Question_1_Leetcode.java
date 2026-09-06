class Solution {
    public int singleNumber(int[] nums) {

        int result = 0;

        for( int bit = 0 ; bit < 32 ; bit ++ ){

            int count = 0;

            for( int num : nums ){

                //check whether the bit at position is 1 or not
                if( (num & ( 1 << bit )) != 0 ){
                    count++;
                }
            }

            if( count % 3 != 0 ){

                result = result | ( 1 << bit );
            }
        }
        return result;
    }
}