class Solution {
    class DSU {
        private int[] parent;
        private int[] rank;

        public DSU (int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int findParent(int i) {
            if (parent[i] != i) {
                 parent[i] = findParent(parent[i]);
            } 
            return parent[i];
        }

        public void union(int x, int y) {
            int rootX = findParent(x);
            int rootY = findParent(y);
            
            System.out.println(x +","+ y +","+ rootX +","+ rootY);
            
            if (rootX == rootY) return;
            if (rank[x] > rank[y]) {
                parent[rootY] = rootX;
                
            } else if (rank[x] < rank[y]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[x]++;
            }
            System.out.println("-->>  "+ x +","+ y +","+  parent[x] +","+ parent[y]);
        }
    }

    public int countComponents(int n, int[][] edges) {
        
        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        for (int i = 0; i < n; i++) {
            dsu.findParent(i);
        }
        int[] parent = dsu.parent;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            System.out.println(parent[i]);
            set.add(parent[i]);
        }
        
        return set.size();
    }
}
