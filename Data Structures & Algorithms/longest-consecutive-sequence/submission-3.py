class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) <= 0: return 0

        nums.sort()
        max_l = 1

        curr = nums[0]
        curr_l = 1
        print(nums)
        for i, num in enumerate(nums, start = 1):
            if num == curr + 1:
                curr_l += 1
            elif num == curr:
                continue
            else:
               curr_l = 1

            max_l = max_l if max_l > curr_l else curr_l
            curr = num 

        return max_l    