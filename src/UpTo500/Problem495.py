class Solution:
    def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
        ans = duration if len(timeSeries) != 0 else 0
        for i in range(len(timeSeries) - 1):
            if timeSeries[i] + duration >= timeSeries[i + 1]:
                ans += timeSeries[i + 1] - timeSeries[i]
            else:
                ans += duration
        return ans
        