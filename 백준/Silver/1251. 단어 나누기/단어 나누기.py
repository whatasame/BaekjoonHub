if __name__ == "__main__":
    # 입력
    word = input()

    # 해결
    answer = []
    for i in range(1, len(word) - 1):  # 최소 길이 1
        for j in range(i + 1, len(word)):
            answer.append(word[:i][::-1] + word[i:j][::-1] + word[j:][::-1])

    # 출력
    print(min(answer))
