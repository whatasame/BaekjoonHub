// 출차 내역 없으면 23:59에 출차
// 단위시간 올림

// 차량 번호가 작은 자동차부터 청구할 주차 요금을 배열로 반환

import java.util.*;
import java.util.stream.*;

class Solution {
    
    static int END = 23 * 60 + 59; // 23:59
    static int dt, df; // default time, default fee
    static int ut, uf; // unit time, unit fee
    
    public int[] solution(int[] fees, String[] records) {
        // init
        dt = fees[0];
        df = fees[1];
        ut = fees[2];
        uf = fees[3];
        
        Map<String, Integer> garage = new HashMap<>();
        Map<String, Integer> times = new HashMap<>();
        for (String record : records) {
            String[] split = record.split(" ");
            
            String[] timeSplit = split[0].split(":");
            int time = Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
            
            String num = split[1];
            String command = split[2];
            if (command.equals("IN")) {
                garage.put(num, time);
            } else { // OUT
                times.merge(num, time - garage.remove(num), Integer::sum);
            }
        }
        
        // 23:59
        for (Map.Entry<String, Integer> entry : garage.entrySet()) {
            times.merge(entry.getKey(), END - entry.getValue(), Integer::sum);
        }
        
        return times.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())  
            .mapToInt(Map.Entry::getValue)      
            .map(time -> time <= dt ? df : (time - dt + ut - 1) / ut * uf + df)
            .toArray();         
    }
}