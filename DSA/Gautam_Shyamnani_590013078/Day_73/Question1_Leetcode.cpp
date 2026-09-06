class Solution {
public:
    int n;

    void bfs(vector<int>& edges,int node,vector<int>& dist){
        queue<int> que;

        dist[node] = 0;
        vector<bool> visited(n,false);
        que.push(node);
        visited[node] = true;

        while(!que.empty()){
            int u = que.front();
            que.pop();
            
            int v = edges[u];

            if(v != -1 && !visited[v]){
                visited[v] = true;
                dist[v] = 1 + dist[u];
                que.push(v);
            }
        }
    }
    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        n = edges.size();

        vector<int> dist1(n,INT_MAX);
        vector<int> dist2(n,INT_MAX);

        bfs(edges,node1,dist1);
        bfs(edges,node2,dist2);

        int minDistNode = -1;
        int minDistanceTillNow = INT_MAX;

        for(int i = 0; i < n;i++){
            int maxD = max(dist1[i],dist2[i]);

            if(minDistanceTillNow > maxD){
                minDistanceTillNow = maxD;
                minDistNode = i;
            }
        }
        return minDistNode;
    }
};