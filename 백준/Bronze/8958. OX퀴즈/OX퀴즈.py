if __name__ == '__main__':
    N = int(input())

    answer = []
    for _ in range(N):
        point, cnt = 0, 0
        for c in input():
            cnt = cnt + 1 if c == 'O' else 0
            point += cnt
        answer.append(point)

    for a in answer:
        print(a)
