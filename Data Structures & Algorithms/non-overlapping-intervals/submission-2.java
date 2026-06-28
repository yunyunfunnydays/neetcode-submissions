class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length < 2) return 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        
        int overlappingCount = 0;
        int currEnd = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (currEnd <= interval[0]) {
                currEnd = interval[1];
            } else {
                overlappingCount++;
            }
        }

        return overlappingCount;

    }
}
