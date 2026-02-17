class Solution:
    def aggressiveCows(self, stalls, k):
        # code here
            
        stalls.sort()
        res = 0 

        low = 1
        high = stalls[-1] - stalls[0] 

        while low <= high:
            mid = low + (high - low) // 2
        
            if self.check(stalls, k, mid):
                res = mid
                low = mid + 1
            else:
                high = mid - 1
    
        return res
        
    def check(self,stalls, k, dist):
    
        count = 1  
        prev = stalls[0] 
        for i in range(1, len(stalls)):
        
            if stalls[i] - prev >= dist:
                prev = stalls[i] 
                count += 1
        return count >= k
        