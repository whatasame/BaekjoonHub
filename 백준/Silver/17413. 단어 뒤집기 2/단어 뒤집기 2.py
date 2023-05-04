S = input()

# 태그와 태그가 아닌 문자열 분리
arr = []
start = 0
for i in range(len(S)):
    if S[i] == "<" and start != i:
        arr.append(S[start:i])
        start = i
    elif S[i] == ">":
        arr.append(S[start:i + 1])
        start = i + 1
if start != len(S):
    arr.append(S[start:])

answer = []
for s in arr:
    if s.startswith("<"):
        answer.append(s)
    else:  # 문자 뒤집기
        words = []
        for word in s.split(" "):
            words.append(word[::-1])
        answer.append(" ".join(words))

print("".join(answer))
