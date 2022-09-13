class SocialNetworkConnectivity{
    private static final int N;
    private int[] id;
    private int[] size;
    private Log[] logs;
    private int numOfTrees;
    public SocialNetworkConnectivity() {
        id = new int[N];
        numOfTrees = N;
        for(int i=0; i&lt;N; i++){
            id[i] = i;
            size[i] = 1;
        }
    }
    private int root(int i) {
        while(id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    private boolean connected(int p, int q) {
        return root(p) == root(q);
    }
    private void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if(i == j) return;
        if(size[i] &gt; size[j]){
            id[j] = i;
            size[i] += size[j]
        } else {
            id[i] = j;
            size[j] += size[i];
        }
    }
    public int earliestTime() {
        for(log in logs) {
            if(!connected(log.p, log.q)) {
                union(log.p, log.q);
                numOfTrees--;
            }
            if(numOfTrees == 1) {
                return log.timestamp;
            }
        }
        return -1;
    }
}