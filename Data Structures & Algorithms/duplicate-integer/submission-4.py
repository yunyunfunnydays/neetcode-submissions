class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool: 
        seen = set()
        return len(nums) != len(set(nums))
        
        