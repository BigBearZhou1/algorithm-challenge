package sword;

/**
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 70. 排序数组中只出现一次的数字
 */
public class Coder24 {
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
    public static int singleNonDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i = i +2) {
            if (nums[i] != nums[i+1]) {
                return nums[i];
            }
        }

        return 0;
    }

    //时间复杂度log(n)
    public static int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right + left)/2;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid+1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                if (nums[mid]== nums[mid - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }

        return nums[left];
    }
}
