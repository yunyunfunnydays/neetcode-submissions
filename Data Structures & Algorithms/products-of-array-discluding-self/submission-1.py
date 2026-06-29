class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        productR = [1] * len(nums)
        curr = 1
        for i in range(len(nums) - 1, -1, -1):
            productR[i] = curr
            curr = curr * nums[i]
        
        result = []
        productL = 1
        for i, n in enumerate(productR):
            result.append(productL * n)
            productL = productL * nums[i]
        
        return result
