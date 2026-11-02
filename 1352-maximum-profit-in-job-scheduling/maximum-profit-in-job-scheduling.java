import java.util.Arrays;

class Solution {
    
   
    static class Job {
        int start, end, profit;
        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        
        Arrays.sort(jobs, (a, b) -> Integer.compare(a.end, b.end));

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
           
            int maxProfitWithoutCurrent = dp[i - 1];

          
            int currentProfit = jobs[i - 1].profit;
            int lastNonOverlappingIndex = findLastNonOverlapping(jobs, i - 1);
            
            if (lastNonOverlappingIndex != -1) {
                currentProfit += dp[lastNonOverlappingIndex + 1];
            }

            
            dp[i] = Math.max(maxProfitWithoutCurrent, currentProfit);
        }

        return dp[n];
    }

  
    private int findLastNonOverlapping(Job[] jobs, int currentIndex) {
        int low = 0, high = currentIndex - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid].end <= jobs[currentIndex].start) {
                result = mid;    
                low = mid + 1;
            } else {
                high = mid - 1;     
            }
        }

        return result;
    }
}