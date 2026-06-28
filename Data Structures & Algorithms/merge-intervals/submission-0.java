class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1 ) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        var merged = new LinkedList<int[]>();
        merged.add(intervals[0]);
        
        for (int[] interval : intervals) {
            if (merged.getLast()[1] >= interval[0]) {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            } else {
                merged.add(interval);
            }
        }  
        return merged.toArray(new int[0][]);
    }
}
