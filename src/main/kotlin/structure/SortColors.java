package structure;

/**
 https://leetcode.com/problems/sort-colors/solutions/3592562/java-code-100-fast-o-n/
 *
 * 1. 시작, 중간, 끝을 나눠서 숫자를 이동시킨다.
 * 2. 0이면 맨 앞부터, 2면 뒤부터 넣는다. 1이면 가만히 두고 저장되어야 하는 위치 정보만 이동시킨다.
 * 3. mid <= end 위치 값이 만날 때까지 계속한다.
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 * */
public class SortColors {
    public void sortColors(int[] nums) {
        int start = 0;
        int mid = 0;
        int end = nums.length - 1;

        while (mid <= end) {
            int data = nums[mid];
            if (data == 0) {
                swap(nums, start, mid);
                start++;
                mid++;
            } else if (data == 1) {
                mid++;
            } else {
                swap(nums, mid, end);
                end--;
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
