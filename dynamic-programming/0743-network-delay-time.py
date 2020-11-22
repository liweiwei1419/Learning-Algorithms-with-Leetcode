from typing import List


class Solution:
    def networkDelayTime(self, times: List[List[int]], N: int, K: int) -> int:
        inf = int(1e9)

        # 邻接矩阵
        graph = [[int(1e9)] * N for _ in range(N)]
        for item in times:
            # 注意：有 1 个单位的偏移
            graph[item[0] - 1][item[1] - 1] = item[2]

        size = len(graph)
        visited = [False for _ in range(size)]
        distance = [inf for _ in range(size)]

        start = K - 1
        for i in range(0, size):
            graph[i][i] = 0
            distance[i] = graph[start][i]

        visited[start] = True
        distance[start] = 0

        for _ in range(size):
            tmp = inf
            u = start
            for j in range(size):
                if not visited[j] and distance[j] < tmp:
                    tmp = distance[j]
                    u = j

            visited[u] = True
            for j in range(size):
                if not visited[j]:
                    distance[j] = min(distance[j], distance[u] + graph[u][j])
                    
        for i in range(size):
            if distance[i] == inf:
                return -1
        res = max(distance)
        return res


if __name__ == '__main__':
    network = [[3, 5, 78], [2, 1, 1], [1, 3, 0], [4, 3, 59], [5, 3, 85],
               [5, 2, 22], [2, 4, 23], [1, 4, 43], [4, 5, 75], [5, 1, 15],
               [1, 5, 91], [4, 1, 16], [3, 2, 98], [3, 4, 22], [5, 4, 31],
               [1, 2, 0], [2, 5, 4], [4, 2, 51], [3, 1, 36], [2, 3, 59]]
    s = Solution()
    print(s.networkDelayTime(network, 5, 5))
