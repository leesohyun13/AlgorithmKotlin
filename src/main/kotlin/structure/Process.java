package structure;

import java.util.*;
import java.util.Collections;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587?language=java#
 *
 * programmers by 2
 * 프로세스
 * */
public class Process {
        public int solution(int[] priorities, int location) {
            int answer = 0;

            // 우선순위 QUEUE의 데이터를 넣어서 큰 순서대로 정렬을 변경한다. -> O(n)
            // TODO PriorityQueue에 대해 공부 필요
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < priorities.length; i++) {
                pq.add(priorities[i]);
            }

            // 우선순위대로 확인하여 지운다. 데이터가 없어질때까지 계속한다.
            while(!pq.isEmpty()) {
                for (int i = 0; i < priorities.length; i ++) {
                    if (!pq.isEmpty() && priorities[i] == pq.peek()) {
                        // 원하는 위치의 정보가 맞는 경우
                        if (i == location) {
                            answer ++;
                            return answer;
                        }
                        // 아닌 경우 다음 우선순위로 간다.
                        pq.poll();
                        answer ++;
                    }
                }
            }

            return -1;
        }
}
