class Solution {
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character , Character> hm = new HashMap<>();

        if ( s.length() != t.length() ){
            return false;
        }

        for ( int i = 0 ; i < s.length() ; i++ ) 
        {
            char key = s.charAt(i) , value = t.charAt(i);

            //checking if key already exist or not
            if ( hm.containsKey(key) ) {
                //if key exist then value should be equal to value in Hashmap
                //otherwise it should return false. Mapping should be one to one.
                if ( hm.get(key) != value ){
                    return false;
                }
                
            }
            //if the key is unique then we will check whether the value is already assigned to any other key or not.
            else {
                // if value exist return false
                if ( hm.containsValue(value) ){
                return false;
                }
            //doesnt exist then put the pair in the hashMap.
            hm.put(key , value);
            }
                
        }
        return true;
    }
}