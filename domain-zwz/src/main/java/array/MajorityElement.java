package array;

/**
 * 投票法 = 大多数
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int num : nums) {
            if(major == num){
                count++;
            }else{
                count--;
                if(count == 0){
                    major = num;
                    count = 1;
                }
            }
        }
        return major;
    }
}
