/*

*/
import java.util.*;

public class CombinationSumIII {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        helper(n, lists, new ArrayList<>(), 0, k, 1);
        return lists;
    }
  
    private static void helper(int n, List<List<Integer>> lists, List<Integer> list, int currSum, int k, int currNum) {
        if (list.size() == k) {
            if (currSum == n) {
                lists.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = currNum; i <= 9; i++) {
            list.add(i);
            helper(n, lists, list, currSum + i, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        System.out.println("Combination sum: "+combinationSum3(k,n));
    }
}