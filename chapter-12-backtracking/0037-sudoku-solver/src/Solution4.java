public class Solution4 {

    // 与本题无关，请忽略

    // [5,5,1,7,2,3,|5] x = 3

    public int solution(int X, int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (true) {
            while (left <= right && A[left] != X) {
                left++;
            }
            // left 来到第一个等于 X 的地方
            while (left <= right && A[right] == X) {
                right--;
            }
            // right 来到第一个不等于 X 的地方
            if (left >= right) {
                return left;
            }
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        // [5,5,1,7,2,3,| 5] x = 3
//        int[] A = {5, 5, 1, 7, 2, 3, 5};
//        int X = 3;

//        int[] A = {6, 5, 4, 3, 2, 1};
//        int X = 7;

        int[] A = {2, 6, 100, 1, 2, 3, 4};
        int X = 30;

        int index = solution4.solution(X, A);
        System.out.println("X = " + X);
        System.out.println("index = " + index);
        print(A, index);
    }

    private static void print(int[] A, int index) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < A.length; i++) {
            if (i == index) {
                stringBuilder.append("|");
            }
            stringBuilder.append(A[i]);
            stringBuilder.append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        if (index == A.length) {
            stringBuilder.append("|");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }
}
