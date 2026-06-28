class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        seen = set()
        return any(x in seen or seen.add(x) for x in nums)

        