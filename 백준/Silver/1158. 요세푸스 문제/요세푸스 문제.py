N, K = map(int, input().split())

answer = []
people = [i for i in range(1, N + 1)]

idx = K - 1
while len(people) > 0:
    idx %= len(people)
    answer.append(people.pop(idx))
    idx += K - 1

result = ""
for i in range(len(answer) - 1):
    result += str(answer[i]) + ", "
result += str(answer[-1])
print(f"<{result}>")
