arr = [True for _ in range(10001)]

for i in range(1, 10001): # 1 to 10000
    num = i # num += n
    for n in str(i): # 각 자리수
        num += int(n)
    if num <= 10000:
      arr[num] = False;

for num in range(1, 10001):
    if arr[num]:
      print(num)    