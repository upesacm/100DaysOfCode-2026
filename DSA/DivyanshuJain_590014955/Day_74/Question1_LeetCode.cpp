#include<iostream>
using namespace std;
#include<list>
#include<unordered_set>
class Solution {
public:
    long long count = 0;
    int nodes;
    vector<list<int>>graph;
    void add_edge(int src,int dest,bool bi_dir=true){
        graph[src].push_back(dest);
        if(bi_dir) graph[dest].push_back(src);
    }
    void bfs(int src,unordered_set<int>&visited){
        int size=0;
        queue<int>qu;
       
        qu.push(src);
        visited.insert(src);
        size++;
        while(!qu.empty()){
            int curr = qu.front();
            qu.pop();
            for(auto neighbor : graph[curr]){
                if(not visited.count(neighbor)){
                    qu.push(neighbor);
                    visited.insert(neighbor);
                    size++;
                }
            }
        }
        for(int i=1;i<=size;i++){
            count+= nodes - size;
        }
    }
    void fun(){
        unordered_set<int>visited;
        for(int i=0;i<nodes;i++){
            if(not visited.count(i)){
                bfs(i,visited);
            }
        }
    }
    long long countPairs(int n, vector<vector<int>>& edges) {
        nodes=n;
        graph.resize(n);
        for(int i=0;i<edges.size();i++){
            add_edge(edges[i][0],edges[i][1]);
        }
        
        fun();
        return count/2;
    }
};