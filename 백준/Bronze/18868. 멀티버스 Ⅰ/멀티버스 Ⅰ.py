import sys

"""
3 3
1 1 1
1 1 1
1 1 1
-> 3

2 3
5 7 6
1 2 3
-> 0
"""

m, n = map(int, input().split())
planets = [list(map(int, input().split())) for _ in range(m)]

def solution(planets):
    # 랭킹 구하기 -> O(n^2)
    orders = []
    for planet in planets:
        sorted_planet = sorted(planet) # O(nlogn)
        orders.append([sorted_planet.index(e) for e in planet]) # O(n^2)

    # 순서들의 조합으로 쌍 구하기 -> O(m^2n)
    answer = 0
    for i in range(m):
        for j in range(i + 1, m):
            if orders[i] == orders[j]:
                answer += 1

    return answer

print(solution(planets))
