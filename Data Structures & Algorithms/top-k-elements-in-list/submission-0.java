class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //count frequent, key = nums, value = freq
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.merge(n, 1, Integer::sum);
        }

        //build bucket, index = freq , value = nums[]
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (var entry : freq.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }

        //build top k, start from most freq's ArrayList
        int[] result = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            for (int n : bucket[i]) {
                result[index++] = n;
            }
        }
        return result;

    }
}
