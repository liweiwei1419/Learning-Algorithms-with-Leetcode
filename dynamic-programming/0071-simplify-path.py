class Solution:
    def simplifyPath(self, path: str) -> str:
        dirs = path.split("/")
        if len(dirs) == 0:
            return "/"

        if dirs[-1] == '':
            dirs.pop()

        stack = []
        for dir in dirs:
            if dir == '.' or dir == '':
                continue
            elif dir == '..':
                if stack:
                    stack.pop()
                continue
            else:
                stack.append(dir)
        return "/" + "/".join(stack)
