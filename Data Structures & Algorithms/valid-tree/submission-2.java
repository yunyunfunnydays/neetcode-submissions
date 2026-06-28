class Solution {
    class DSJ {
        private int[] parent;
        private int[] rank;

        public DSJ(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int findParent(int i){
            if (parent[i] != i) {
                parent[i] = findParent(parent[i]);
            }
            return parent[i];
        }

        public boolean union(int i, int j) {
            int rootI = findParent(i);
            int rootJ = findParent(j);

            if (rootI == rootJ) {
                return false;
            }

            if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else {
                parent[rootJ] = rootI;
                rank[rootI]++;
            }

            return true;
        }

    }

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        DSJ dsj = new DSJ(n);

        for (int[] edge : edges) {
            if (!dsj.union(edge[0], edge[1])) {
                return false;
            }
        }

        return true;

    }
}
