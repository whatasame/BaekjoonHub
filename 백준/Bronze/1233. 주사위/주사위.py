S1, S2, S3 = map(int, input().split())

freq = {}

for i in range(1, S1 + 1):
    for j in range(1, S2 + 1):
        for k in range(1, S3 + 1):
            freq[i + j + k] = freq.get(i + j + k, 0) + 1

max_val = max(freq.values())
answer = [k for k, v in freq.items() if v == max_val][0]

print(answer)
