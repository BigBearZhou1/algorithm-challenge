package dp;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int imax = nums[0], imin = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int pmax = imax,pmin = imin;
            imax = Math.max(pmax*nums[i],Math.max(pmin*nums[i],nums[i]));
            imin = Math.min(pmax*nums[i],Math.min(pmin*nums[i],nums[i]));
            max = Math.max(max,imax);
        }
        return max;
    }
}
