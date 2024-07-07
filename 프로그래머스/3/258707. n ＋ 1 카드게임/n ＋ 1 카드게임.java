// 시작할 때 n/3, 라운드 마다 2장씩
// 카드 1장당 동전 1개를 소모해서 가질 수 있다.
// n+1이 되도록 두 장을 낸다.

// 카드는 중복 없음

// 최대 라운드 수를 반환

import java.util.*;

class Solution {
    
    static int n, target;
    
    public int solution(int coin, int[] cards) {
        n = cards.length;
        target = n + 1;
        
        Set<Integer> hands = new HashSet<>();
        Set<Integer> draws = new HashSet<>();
        
        int turn = n / 3;
        
        for (int i = 0; i < turn; i++) {
            hands.add(cards[i]);
        }
        
        int answer = 0;
        while (true) {
            answer++;
            
            if (turn >= n) {
                break;
            }
            
            draws.add(cards[turn++]);
            draws.add(cards[turn++]);
            
            System.out.println(hands);
            System.out.println(draws);
            System.out.println("---");
            if (checkHands(hands)) {
                continue;
            }
            
            if (coin >= 1 && useOne(hands, draws)) {
                coin -= 1;
                continue;
            }
            
            if (coin >= 2 && useTwo(draws)) {
                coin -= 2;
                continue;
            }
            
            break;
        }
        
        return answer;
    }
    
    private boolean checkHands(Set<Integer> hands) {
        for (int hand : hands) {
            if (hands.contains(target - hand)) {
                hands.remove(hand);
                hands.remove(target - hand);
                
                return true;
            }
        }
        
        return false;
    }
    
    private boolean useOne(Set<Integer> hands, Set<Integer> draws) {
        for (int hand : hands) {
            if (draws.contains(target - hand)) {
                hands.remove(hand);
                draws.remove(target - hand);
                
                return true;
            }
        }
        
        return false;
    }
    
    private boolean useTwo(Set<Integer> draws) {
        for (int draw : draws) {
            if (draws.contains(target - draw)) {
                draws.remove(draw);
                draws.remove(target - draw);
                
                return true;
            }
        }
        
        return false;
    }
}