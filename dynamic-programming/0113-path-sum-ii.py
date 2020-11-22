from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        res, path = [], []
        # 这里如果输入结点为空结点，应该返回空列表
        if not root: return []

        def dfs(root, sum):
            # print(path)
            if not root: return
            if root.val == sum and not root.left and not root.right:
                path.append(root.val)
                res.append(path[:])
                path.pop()
                # 在叶子结点处，并且找到了一个解以后，就可以返回，所以要加上 return
                return

            # 缩进错了，下面 4 行都是 dfs 函数里的内容
            path.append(root.val)
            dfs(root.left, sum - root.val)
            dfs(root.right, sum - root.val)
            path.pop()

        # 在这里要调用一下 dfs 方法
        dfs(root, sum)
        return res
