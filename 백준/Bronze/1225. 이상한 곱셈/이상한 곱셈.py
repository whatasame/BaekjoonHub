N, M = input().split()

# map의 매개변수는 iterable
sum_n = sum(map(int, N))
sum_m = sum(map(int, M))

print(sum_n * sum_m)
