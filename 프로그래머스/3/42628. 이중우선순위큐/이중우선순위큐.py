import heapq

def solution(operations):
    min_heap, max_heap = [], []
    
    for operation in operations:
        op, num = operation.split()
        num = int(num)
        
        if op == "I":
            heapq.heappush(min_heap, num)
            heapq.heappush(max_heap, (num * -1, num))
        else:
            if not min_heap:
                pass
            elif num == 1:
                _, max_num = heapq.heappop(max_heap)
                min_heap.remove(max_num)
            elif num == -1:
                min_num = heapq.heappop(min_heap)
                max_heap.remove((min_num * -1, min_num))
                
    if min_heap:
        _, max_num = heapq.heappop(max_heap)
        min_num = heapq.heappop(min_heap)
        
        return [max_num, min_num]
    else:
        return [0, 0]