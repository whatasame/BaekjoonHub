# 가입자 많은 순 -> 판매액 많은 순
# 플러스 서비스 가입 수 & 매출액 반환
# 각 이모티콘마다 최소 할인율을 구해야함.
# 할인율: 10, 20, 30, 40
# i -> i + 1번째 사람, 이모티콘

# 가입자 많게 하려면 -> 할인을 안하면 된다.
# 할인을 너무 안하면 -> 사는 것조차 안한다.

# 할인율 경우의 수: 4^m <= 4^7 = 2^14 < 20k

from itertools import product

def solution(users, emoticons):
    ratio = [10, 20, 30, 40]
    max_subscriber = 0
    max_price = 0
    
    # 모든 할인율의 경우의 수에 대하여 
    for ratios in product(ratio, repeat = len(emoticons)):
        total_subscriber = 0
        total_price = 0
        
        # 할인된 이모티콘 가격 계산
        saled = [] # (할인율, 할인가격)
        for i in range(len(emoticons)):
            sale_ratio = (100 - ratios[i]) / 100
            saled.append((ratios[i], emoticons[i] * sale_ratio))
            
        for user_ratio, user_price in users:
            # 유저별 구매비용 계산
            purchased_price = sum([sale_price for sale_ratio, sale_price in saled if sale_ratio >= user_ratio])
            
            # 가입자수, 판매액 계산
            if purchased_price >= user_price:
                total_subscriber += 1
            else:
                total_price += purchased_price
            
        # 최대 업데이트
        if total_subscriber > max_subscriber or (total_subscriber == max_subscriber and total_price > max_price):
            max_subscriber, max_price = total_subscriber, total_price
                    
    # 가입자수, 판매액 반환
    return [max_subscriber, max_price]
    
