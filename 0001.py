class Solution:
    def removeEdgeBT(self, root):
        def removeEdgeBT(node, seen):
            if node is None or node in seen:
                return None

            seen.add(node)

            node.left = removeEdgeBT(node.left, seen)
            node.right = removeEdgeBT(node.right, seen)
            return node

        return removeEdgeBT(root, dict())
