class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        low = 1
        high = max(piles)
        res = high
        while low <= high:
            mid = low + (high - low) // 2   
            if self.check(piles, mid, h):
                res = mid
                high = mid - 1
            else:
                low = mid + 1
        return res
    def check(self, arr, mid, h):
        totalHours = 0
        for pile in arr:
            totalHours += (pile + mid - 1) // mid  
        return totalHours <= h