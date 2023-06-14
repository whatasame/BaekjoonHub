def solution(word_list: list):
    cnt = 0  # 그룹 단어가 아닌 것들

    for word in word_list:
        for i in range(1, len(word)):
            if word[i] != word[i - 1] and word[i - 1] in word[i:]:
                cnt += 1
                break
    return N - cnt


if __name__ == "__main__":
    # 입력
    N = int(input())
    word_list = [input() for _ in range(N)]

    # 해결
    answer = solution(word_list)

    # 출력
    print(answer)
