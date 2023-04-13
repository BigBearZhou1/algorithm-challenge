package leetcode.LeetCode75.ArrayAndString.week01.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class Candies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> list = new ArrayList<>();
        OptionalInt max = Arrays.stream(candies).max();
        if(max.isPresent()){
            for (int candy :candies) {
                list.add(candy + extraCandies >= max.getAsInt());
            }

        }
        return list;

    }
}
