bool equalArray(vector<int>& arr1, vector<int>& arr2){
    map<int, int> mp1, mp2;
    for(auto i:arr1){
        mp1[i]++;
    }
    for(auto i:arr2){
        mp2[i]++;
    }
    if(mp1==mp2) return true;
    return false;
}
