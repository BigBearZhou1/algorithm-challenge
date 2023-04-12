package recursion;

/**
 * 范围上的递归尝试模型
 * 双人拿纸牌游戏
 * 给定一个整数数组arr,代表数值不同的纸牌排成一条线
 * 玩家A和玩家B依次拿走每张纸牌
 * 规定玩家A先拿，玩家B后拿
 * 每个玩家每次只能拿走最左边或最右的纸牌
 * 请返回最后获胜者的分数
 */
public class CardsInLine {
    public int cardsInLine(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        return Math.max(first(arr, 0, arr.length - 1), second(arr, 0, arr.length - 1));
    }

    private int first(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        return Math.max(arr[l] + second(arr, l + 1, r), arr[r] + second(arr, l, r - 1));
    }

    private int second(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        return Math.min(first(arr, l + 1, r), first(arr, l, r - 1));
    }
}
