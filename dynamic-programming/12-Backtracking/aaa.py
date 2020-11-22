class Solution:
    def getPermutation(self, n: int, k: int) -> str:

        count = 0
        num_l = [i + 1 for i in range(n)]
        result = ''

        def back_track(num_list, res=''):
            temp_res = res
            for i in num_list:
                res += str(i)
                if len(res) == n:
                    nonlocal count
                    count += 1
                    if count == k:
                        nonlocal result
                        result = res
                        return
                else:
                    temp_list = num_list[:]
                    temp_list.remove(i)
                    res = back_track(temp_list, res)
                    if res == None:
                        return
            res = temp_res[:-1]
            return res

        back_track(num_l)
        return result

if __name__ == '__main__':
    solution = Solution()
    n = 3
    k = 2
    res = solution.getPermutation(n,k)
    print(res)