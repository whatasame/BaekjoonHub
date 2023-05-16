# 0-1 knapsack problem

if __name__ == "__main__":
    N, K = map(int, input().split())
    item = [(0, 0)]
    for _ in range(N):
        item.append(tuple(map(int, input().split())))

    dp = [[0 for _ in range(K + 1)] for _ in range(N + 1)]
    for i in range(1, N + 1):
        for k in range(1, K + 1):
            w, v = item[i]  # weight, value
            if w <= k:
                dp[i][k] = max(dp[i - 1][k], dp[i - 1][k - w] + v)
            else:
                dp[i][k] = dp[i - 1][k]

    print(dp[N][K])
