N, M = map(int, input().split())

arr = [list(map(int, input())) for _ in range(N)]

max_length = 0
for i in range(N):
    for j in range(M):
        watch = arr[i][j]

        for k in range(j, M):
            length = k - j
            if i + length < N \
                    and arr[i][j + length] == watch \
                    and arr[i + length][j] == watch \
                    and arr[i + length][j + length] == watch:
                max_length = max(max_length, length)

print((max_length + 1) ** 2)
