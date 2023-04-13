package leetcode.LeetCode75.ArrayAndString.week02.day01;

public class Place {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int last_bed = -1;
        int add_trees = 0;
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 1) {
                if (last_bed == -1) {
                    add_trees += i / 2;
                } else {
                    int slot = i - last_bed - 2;
                    add_trees += slot / 2;
                }
                last_bed = i;
            }
        }
        if (last_bed == -1) {
            add_trees += (len + 1) / 2;
        } else {
            add_trees += (len - last_bed - 1) / 2;
        }

        return add_trees >= n;
    }


    public static void main(String[] args) {
        System.out.println(new Place().canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
    }
}
