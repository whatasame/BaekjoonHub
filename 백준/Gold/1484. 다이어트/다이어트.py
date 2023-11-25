import sys

input = sys.stdin.readline
g = int(input())

def solution(g):
    # n^2 - (n-1)^2 = 2n - 1 = g => n = (g+1) // 2
    squares = [num ** 2 for num in range(1, (g + 1) // 2 + 1)]

    answer = []
    end = 0

    for start in range(len(squares)):
        diff = squares[end] - squares[start]

        while end + 1 < len(squares) and diff < g:
            end += 1
            diff = squares[end] - squares[start]

        if diff == g:
            answer.append(end + 1)

    return answer if answer else [-1]

print("\n".join(map(str, solution(g))))
