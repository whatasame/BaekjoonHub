import heapq

def solution(scoville, k):
    heapq.heapify(scoville) # min_heap

    count = 0
    # heap peek가 k 이상일 때까지
    while scoville[0] < k:
        if len(scoville) == 1:
            return -1
        
        min_scov = heapq.heappop(scoville)
        next_min_scov = heapq.heappop(scoville)
        
        heapq.heappush(scoville, min_scov + next_min_scov * 2)
        
        count += 1
        
    return count

    
    
