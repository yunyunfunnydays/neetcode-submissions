class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                count++;
                bfs(adj, i, visited);
            }
        }

        return count;
    }

    private void bfs(List<List<Integer>> adj, int i, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>(); 
        queue.add(i);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited[curr] = true;

            for (int j : adj.get(curr)) {
                if (!visited[j]) {
                    queue.offer(j);
                }
            }

        }

    }
}
