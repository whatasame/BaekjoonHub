# 1, 4, 7 -> 왼쪽
# 2, 5, 8, 0, -> 오른쪽
# 3, 6, 9 -> 둘 중 가까운 것 -> 거리 같다면 주 손 사용

# number 내 중복 번호 존재

def solution(numbers, hand):
    # 손가락 초기화
    left, right = (3, 0), (3, 2) 
    
    answer = []
    for number in numbers:
        left, right, used = move(number, left, right, hand)
        answer.append(used)
    
    return "".join(map(str, answer))

def move(number, left, right, hand):
    keymap = {
        1: (0, 0),
        2: (0, 1),
        3: (0, 2),
        4: (1, 0),
        5: (1, 1),
        6: (1, 2),
        7: (2, 0),
        8: (2, 1),
        9: (2, 2),
        "*": (3, 0),
        0: (3, 1),
        "#": (3, 2),
    }
    
    if number in (1, 4, 7):
        return keymap[number], right, "L"
    if number in (3, 6, 9):
        return left, keymap[number], "R"
    
    left_distance = abs(keymap[number][0] - left[0]) + abs(keymap[number][1] - left[1])
    right_distance = abs(keymap[number][0] - right[0]) + abs(keymap[number][1] - right[1])
    
    if left_distance == right_distance:
        if hand == "left":
            return keymap[number], right, "L"
        elif hand == "right":
            return left, keymap[number], "R"
    elif left_distance > right_distance:
        return left, keymap[number], "R"
    elif right_distance > left_distance:
        return keymap[number], right, "L"
        
    
    
    
