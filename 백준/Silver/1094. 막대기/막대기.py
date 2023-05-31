if __name__ == "__main__":
    # 입력
    N = int(input())

    # 해결
    num_list = [64, 32, 16, 8, 4, 2, 1]

    answer = 0
    while N:
        for num in num_list:
            if num <= N:
                N -= num
                answer += 1
                break

    # 출력
    print(answer)