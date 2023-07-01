def solution(arr):
    board = [[0 for _ in range(101)] for _ in range(101)]

    for x, y in arr:
        for i in range(x, x + 10):
            for j in range(y, y + 10):
                board[i][j] = 1

    answer = 0
    for row in board:
        answer += row.count(1)

    return answer

if __name__ == "__main__":
    # 입력
    N = int(input())
    arr = [tuple(map(int, input().split())) for _ in range(N)]

    # 해결
    answer = solution(arr)

    # 출력
    print(answer)
