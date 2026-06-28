/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;
        if (intervals.size() == 1) return 1;

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        
        var minEndTime = new PriorityQueue<Integer>();
        minEndTime.offer(intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++){
            if (minEndTime.peek() <= intervals.get(i).start) {
                minEndTime.poll();
            }
            minEndTime.offer(intervals.get(i).end);
        }
        return minEndTime.size();
    }
}
