import java.util.Arrays;

public class Solution3 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        int rows = image.length;
        int cols = image[0].length;

        UnionFind unionFind = new UnionFind(rows * cols);
        int[][] directions = new int[][]{{1, 0}, {0, 1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果不是要染色的单元格，跳过
                if (image[i][j] != oldColor) {
                    continue;
                }

                for (int[] direction : directions) {
                    int newX = i + direction[0];
                    int newY = j + direction[1];
                    if (inArea(newX, newY, rows, cols) && image[newX][newY] == oldColor) {
                        unionFind.union(getIndex(newX, newY, cols), getIndex(i, j, cols));
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (unionFind.isConnected(getIndex(i, j, cols), getIndex(sr, sc, cols))) {
                    image[i][j] = newColor;
                }
            }
        }
        return image;
    }

    private boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private int getIndex(int x, int y, int cols) {
        return x * cols + y;
    }


    private class UnionFind {
        private int[] parent;
        private int[] rank;

        private int count;
        private int N;

        public int getCount() {
            return count;
        }

        public UnionFind(int N) {
            this.N = N;
            this.count = N;
            this.parent = new int[N];
            this.rank = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
            Arrays.fill(rank, 1);
        }

        public int find(int x) {
            while (x != parent[x]) {
                // 路径压缩：隔代压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] == rank[rootY]) {
                parent[rootX] = rootY;
                // 此时以 rootY 为根结点的树的高度仅加了 1
                rank[rootY] += 1;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
                // 此时以 rootY 为根结点的树的高度不变
            } else {
                // 同理，此时以 rootX 为根结点的树的高度不变
                parent[rootY] = rootX;
            }
            count--;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
