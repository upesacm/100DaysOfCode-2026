int closestMeetingNode(int* edges,int edgesSize,int node1,int node2){
    int dist1[edgesSize],dist2[edgesSize];
    for(int i=0;i<edgesSize;i++) dist1[i]=dist2[i]=-1;
    int curr=node1,d=0;
    while(curr!=-1&&dist1[curr]==-1){
        dist1[curr]=d++;
        curr=edges[curr];
    }
    curr=node2;
    d=0;
    while(curr!=-1&&dist2[curr]==-1){
        dist2[curr]=d++;
        curr=edges[curr];
    }
    int ans=-1,minDist=1000000000;
    for(int i=0;i<edgesSize;i++){
        if(dist1[i]!=-1&&dist2[i]!=-1){
            int x=dist1[i]>dist2[i]?dist1[i]:dist2[i];
            if(x<minDist){
                minDist=x;
                ans=i;
            }
        }
    }
    return ans;
}
