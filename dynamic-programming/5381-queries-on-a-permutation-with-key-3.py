# a[i] = a[i-1] + a[i-2]+...+a[i-k+0]
# a[i+1] = a[i] + a[i-1]+...+a[i-k+1]

# a[i+1] = 2*a[i]-a[i-k]
# a[i] = 2*a[i - 1]-a[i - 1 - k]
if __name__ == '__main__':
    # text = input()
    # print(text)

    import re

    s = "abbbcccbba"
    print(re.sub(r'([a-z])\\2{2,}', '', s))

    phone = "2004-959-559 # 这是一个电话号码"

    # 删除注释
    num = re.sub('#.*$', "", phone)
    print("电话号码 : ", num)

    # 移除非数字的内容
    num = re.sub('\D', "", phone)
    print("电话号码 : ", num)
