# (0, 0) ~ (n-1, n-1) 경로
# 직선 - 100원
# 코너 - 500원
# 0: 갈 수 있음
# 1: 벽

# 직선 도로의 개수가 많아도 더 쌀 수 있음 -> 최단 경로가 답이 아닐 수 있음

# 최소 비용 반환
# 이전 노드와 다음 노드 정보가 있으면 다음 노드로 가는 비용을 알 수 있다.
# 이전 노드와 다음 노드의 r, c가 모두 다르면 코너, 하나라도 같으면 직선

from collections import deque

def solution(board):
    n = len(board)

    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    visited = [[False for _ in range(n)] for _ in range(n)]
    costs = [[float("inf") for _ in range(n)] for _ in range(n)]

    q = deque()
    q.append(( (0, 0), None) )
    visited[0][0] = True
    costs[0][0] = 0

    while q:
        now, bef = q.popleft()
        # print(now, bef)
        r, c = now
        visited[r][c] = True

        for dr, dc in directions:
            nr, nc = r + dr, c + dc

            if not (0 <= nr < n and 0 <= nc < n and board[nr][nc] == 0 and not visited[nr][nc]):
                continue 
            new_cost = costs[r][c] + get_cost(bef, (nr, nc))
            costs[nr][nc] = min(costs[nr][nc], new_cost)

            # print(f"r, c = {r} {c}, costs[{r}][{c}] = {costs[r][c]}")
            # print(f"nr, nc = {nr} {nc}, get_cost() = {get_cost(bef, (nr, nc))}")
            # print(f"costs[{nr}][{nc}] = {costs[nr][nc]}")

            q.append(((nr, nc), (r, c)))
            # visited[nr][nc] = True
                
    return costs[n-1][n-1]
                
def get_cost(bef, nxt):
    if bef == None:
        return 100
    
    bef_r, bef_c = bef
    nxt_r, nxt_c = nxt
    if bef_r != nxt_r and bef_c != nxt_c:
        return 600
    
    return 100



