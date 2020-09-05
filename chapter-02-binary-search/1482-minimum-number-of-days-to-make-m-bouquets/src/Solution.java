public class Solution {

    public int minDays(int[] bloomDay, int m, int k) {
        int len = bloomDay.length;
        if (m * k > len) {
            return -1;
        }

        // 二分等待天数 waitingDays
        int left = 0;
        int right = 0;

        for (int day : bloomDay) {
            right = Math.max(right, day);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 找大于等于 m 的最少天数
            int currentWaitingDays = calculateDays(bloomDay, mid, k);
            // System.out.println("mid => " + mid + " 结果 => " + currentWaitingDays);
            if (currentWaitingDays < m) {
                // 小于 m 的时候，一定不是解
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间是 [left, mid]
                right = mid;
            }
        }
        return left;

    }

    /**
     * 可以制作多少束花
     *
     * @param bloomDay
     * @param waitingDays
     * @param k
     * @return
     */
    private int calculateDays(int[] bloomDay, int waitingDays, int k) {
        int currentCount = 0;
        int days = 0;

        for (int needDays : bloomDay) {
            if (needDays <= waitingDays) {
                currentCount++;
            } else {
                currentCount = 0;
                continue;
            }

            if (currentCount == k) {
                days++;
                currentCount = 0;
            }
        }
        return days;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] bloomDay = new int[]{1, 10, 3, 10, 2};
//        int m = 3;
//        int k = 1;

        int[] bloomDay = new int[]{1, 10, 3, 10, 2};
        int m = 3;
        int k = 2;

//        int[] bloomDay = new int[]{7, 7, 7, 7, 12, 7, 7};
//        int m = 2;
//        int k = 3;

//        int[] bloomDay = new int[]{1000000000, 1000000000};
//        int m = 1;
//        int k = 1;
        int res = solution.minDays(bloomDay, m, k);
        System.out.println(res);
    }
}
