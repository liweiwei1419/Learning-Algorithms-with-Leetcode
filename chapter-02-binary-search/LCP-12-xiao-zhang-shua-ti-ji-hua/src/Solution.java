public class Solution {

    public int minTime(int[] time, int m) {
        int sum = 0;
        for (int num : time) {
            sum += num;
        }

        int left = 0;
        int right = sum;

        while (left < right) {
            int mid = (left + right) >>> 1;
            // mid 是 T 值的意思
            int splits = split(time, mid);
            if (splits > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int split(int[] nums, long maxSum) {
        int splits = 1;

        int len = nums.length;
        int curMax = nums[0];
        int tempSum = nums[0];

        for (int i = 1; i < len; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (tempSum + nums[i] - curMax > maxSum) {
                tempSum = 0;
                curMax = nums[i];
                splits++;
            }
            tempSum += nums[i];
        }
        return splits;
    }
}
