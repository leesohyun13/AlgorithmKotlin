package java_test;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/solutions/2840656/java-explained-in-detail-simple-fast-solution-intuitive-hash-table/
 * */

// 검사 방식
// 1. .인지 아닌지 확인하고, 아니라면 아래의 계산을 실행한다.
// 2. 전체 board를 돌면서 각 int별 개수를 hashmap에 담는다. 이때, 가로, 세로, 구역별 hashmap에 모두 담는다.
// #. 각 hasmp 맴을 검사하면서 하나라고 숫자가 2 이상이면, false를 반환한다.
// Space Complexity : O(n) = 3 * 9
// Time Complexity : O(n^2) = 9 * 9

// 수정 방식
// 1. .가 아닌 데이터인지 검사한다.
// 2. set에 해당 데이터가 각 타입벼로 존재하는지 검사한다.
// 3. 만약, 기존에 없는 경우에는 각 타입에 맞는 포멧으로 저장한다.
// 4. 존재하는 경우, false를 반환한다.
// Space Complexity : O(n^2)
// Time Complexity : O(n^2) = 9 * 9
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        // 데이터 수집
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                char data = board[r][c];
                if (data == '.') {
                    continue;
                }

                if (!set.add(r + "row" + data) || !set.add(c + "coulumn" + data) || !set.add((r/3) + "," + (c/3) + "box" + data)) {
                    return false;
                }
            }
        }

        return true;
    }
}
