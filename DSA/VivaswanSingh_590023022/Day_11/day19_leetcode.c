bool isIsomorphic(char* s, char* t)
{
    int mapST[256];
    int mapTS[256];

    for (int i = 0; i < 256; i++)
    {
        mapST[i] = -1;
        mapTS[i] = -1;
    }

    for (int i = 0; s[i] != '\0'; i++)
    {
        unsigned char chS = (unsigned char)s[i];
        unsigned char chT = (unsigned char)t[i];

        if (mapST[chS] == -1 && mapTS[chT] == -1)
        {
            mapST[chS] = chT;
            mapTS[chT] = chS;
        }
        else if (mapST[chS] != chT || mapTS[chT] != chS)
        {
            return false;
        }
    }

    return true;
}