import sys


def solution(s):
    for word_pi in s.split("pi"):
        if not word_pi:
            continue

        for word_ka in word_pi.split("ka"):
            if not word_ka:
                continue

            for word_chu in word_ka.split("chu"):
                if word_chu.strip():
                    return "NO"

    return "YES"


input = sys.stdin.readline
s = input()

answer = solution(s)

print(answer)
