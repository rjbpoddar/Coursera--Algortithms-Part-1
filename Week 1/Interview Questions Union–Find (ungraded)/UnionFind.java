class UnionFind{
    private static final int N;
    private int[] id;
    private int[] size;
    private Map&lt;Integer, Integer&gt; components = new HashMap&lt;&gt;();// (root, maxElement)
    public UnionFind() {
        id = new int[N];
        for(int i=0; i&lt;N; i++){
            id[i] = i;
            size[i] = 1;
            components.put(i, i);
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
            int maxJ = components.get(j);
            maxJ &gt; components.get(i) &amp;&amp; components.put(i, maxJ);
        } else {
            id[i] = j;
            size[j] += size[i];
            int maxI = components.get(i);
            maxI &gt; components.get(j) &amp;&amp; components.put(j, maxI);
        }
    }
    public int find(int i) {
        int root = root(i);
        return components.get(root);
    }
}