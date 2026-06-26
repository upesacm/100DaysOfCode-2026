class Solution 
{
    public boolean isIsomorphic(String s, String t) 
    {
        if(s.length() != t.length())
        {
            return false;
        }

    Map<Character,Character> charMappingMap = new HashMap<>();

    for(int i=0 ; i < s.length(); i++)
    {
        char org=s.charAt(i);
        char replc=t.charAt(i);

        if(!charMappingMap.containsKey(org))
        {
            if(!charMappingMap.containsValue(replc))
            {
                charMappingMap.put(org,replc);
            }
            else
            {
                return false;
            }
        }
        else
        {
            char mappedch = charMappingMap.get(org);
            if(mappedch != replc)
            {
                return false;
            }
        }
    }
    return true;
    }
}