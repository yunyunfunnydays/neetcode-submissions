class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build adj record pair
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        
        int[] inDegree = new int[numCourses];


        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            adj.get(pair[0]).add(pair[1]);
            inDegree[pair[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();
            numCourses--;
            for (int j : adj.get(i)) {
                inDegree[j]--;
                if (inDegree[j] == 0) queue.add(j);
            }
        }

        return numCourses == 0;

    }   

}
