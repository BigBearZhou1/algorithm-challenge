package sword;

/**
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 */
public class Coder26 {
    public static void main(String[] args) {
        System.out.println(new Coder26().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        //快排思想，左边大， 右边小
        return sort(nums, 0, nums.length - 1, k-1);
    }

    private int sort(int[] nums, int start, int end, int k) {
        int index = partition(nums, start, end);
        if (index == k) {
            return nums[k];
        } else if (index > k) {
            return sort(nums, start, index - 1, k);
        } else {
            return sort(nums, index + 1, end, k);

        }
    }

    private int partition(int[] nums, int start, int end) {
        int left = start;
        int right = end;
        int indexValue = nums[start];

        while (left < right) {
            while (left < right) {
                if (nums[right] >= indexValue) {
                    nums[left] = nums[right];
                    left++;
                    break;
                } else {
                    right--;
                }
            }

            while (left < right) {
                if (nums[left] >= indexValue) {
                    left++;
                } else {
                    nums[right] = nums[left];
                    right--;
                    break;
                }
            }
        }

        nums[left] = indexValue;

        return left;
    }
}
