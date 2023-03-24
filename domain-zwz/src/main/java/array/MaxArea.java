package array;

/**
 * 双指针
 * 从最外面向里面移动，数值小的那一边向里面移动
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, max = 0;
        while (l != r) {
            int cur = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(max,cur);
            if(height[l]<=height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}
