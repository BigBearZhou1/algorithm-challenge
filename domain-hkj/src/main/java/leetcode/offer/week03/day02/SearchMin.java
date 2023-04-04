package leetcode.offer.week03.day02;

public class SearchMin {
    public int minArray(int[] numbers) {
        int temp = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (temp > numbers[i]) {
                return numbers[i];
            }
            temp = numbers[i];
        }
        return numbers[0];
    }
}
