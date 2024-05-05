package subset.subset2;

import java.util.*;

public class Subset2 {

    public static void main(String[] args){
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        backTrack(nums, 0, ls, new ArrayList<>());
        return ls;
    }

    public static  void backTrack(int[] nums, int index, List<List<Integer>> ls , List<Integer> ns){
        ls.add(new ArrayList<>(ns));
        for (int i = index; i < nums.length; i++){
            if (i != index && nums[i]==nums[i-1]){
                continue;
            }
            ns.add(nums[i]);
            backTrack(nums, i+1, ls, ns);
            ns.remove(ns.size()-1);
        }
    }

}
