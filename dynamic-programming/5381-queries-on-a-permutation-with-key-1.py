# a[i] = a[i-1] + a[i-2]+...+a[i-k+0]
# a[i+1] = a[i] + a[i-1]+...+a[i-k+1]

# a[i+1] = 2*a[i]-a[i-k]
# a[i] = 2*a[i - 1]-a[i - 1 - k]
if __name__ == '__main__':
    k, n = map(int, input().split())
    arr = [1] * k + [0] * (n - k + 1)

    for i in range(k, n + 1):
        arr[i] = (sum(arr[i - k:i])) % 397

    print(arr[n])
