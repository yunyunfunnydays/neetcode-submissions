class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        if (hasCycle(adj, 0, visited, -1)) {
            return false;
        }

        return visited.size() == n;      

    }

    private boolean hasCycle(List<List<Integer>> adj, int curr, Set<Integer> visited, int parent){
        if (visited.contains(curr)) return true;
        visited.add(curr);

        for (int i : adj.get(curr)) {
            if (i == parent) continue;    
            if (hasCycle(adj, i, visited, curr)) return true;
        }

        return false;
    }
}
