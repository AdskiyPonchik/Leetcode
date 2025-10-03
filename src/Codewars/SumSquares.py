"""def sum_of_squares(n):
    dp = [float("inf")] * (n+1)
    dp[0] = 0
    for i in range(1, n + 1):
        for sq in range(1, int(i ** 0.5) + 1):
            k = sq * sq
            dp[i] = min(dp[i], 1 + dp[i - k])
    return dp[n]"""

def sum_of_squares(n):
    if int(math.isqrt(n)) ** 2 == n:
        return 1

    for a in range(1, int(math.isqrt(n)) + 1):
        b = n - a * a
        if int(math.isqrt(b)) ** 2 == b:
            return 2
    m = n
    while m % 4 == 0:
        m //= 4
    if m % 8 == 7:
        return 4
    return 3


print(sum_of_squares(12))
