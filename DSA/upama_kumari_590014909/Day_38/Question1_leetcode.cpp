class Solution{
public:
    int countStudents(vector<int>&students,vector<int>&sandwiches){
        int zero = 0,one = 0;

        for(int s : students){
            if(s==0){
                zero++;
            }else{
                one++;
            }
        }

        for(int i=0;i<sandwiches.size();i++){
            if(sandwiches[i]==0){
                if(zero==0){
                    return sandwiches.size() -i;
                }
                zero--;
            }else{
                if(one==0){
                    return sandwiches.size() - i;
                }
                one--;
            }
        }
        return 0;
    }
};