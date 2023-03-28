package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int pos = binSearch(nums, target);
        if (pos == -1) {
            return new int[]{-1, -1};
        }
        int left = pos - 1, right = pos + 1;
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        while (right < nums.length && nums[right] == target) {
            right++;
        }
        return new int[]{++left, --right};
    }

    private int binSearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        SearchRange solution = new SearchRange();
        int[] res = solution.searchRange(nums, 6);
        for (int cur : res) {
            System.out.print(cur + " , ");
        }
    }
}
