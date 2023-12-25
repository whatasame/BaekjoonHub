# 화면은 n x n
# 바구니는 무제한

def solution(board, moves):
    n = len(board)
    answer = 0
    
    # 화면을 세로로 n개의 스택으로 변환
    stacks = [[ ]]
    for c in range(n):
        stack = []
        for r in reversed(range(n)):
            if not board[r][c]:
                continue
            stack.append(board[r][c])
        stacks.append(stack)
            
    # 바구니 스택 선언
    basket = []
    
    # 뽑아서 넣고 터트리기
    for move in moves:
        doll = pop(stacks, move)
        if not doll:
            continue
        basket_doll = peek(basket)
        if doll == basket_doll:
            answer += 2
            basket.pop()
        else:
            basket.append(doll)
    
    return answer

def pop(stacks, idx):
    if not stacks[idx]:
        return None 
    
    return stacks[idx].pop()

def peek(basket):
    if not basket:
        return None
    
    return basket[-1]
    

    
