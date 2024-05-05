package leet.subset;

import java.util.ArrayList;
import java.util.List;

public class Subset {

        public static void main(String[] args){
        int[] nums={1,2,3}   ;
        System.out.println(subsets(nums));
        }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        List<Integer> ns = new ArrayList<Integer>();
        recursionSubsets(nums,0,ls,ns );
        return ls;
    }

    public static void recursionSubsets(int[] nums, int i,List<List<Integer>> ls, List<Integer> ns ){
        if (i == nums.length){
            ls.add(new ArrayList<Integer>(ns));
            return;
        }
        ns.add(nums[i]);
        recursionSubsets(nums, i+1, ls, ns);

        ns.remove(ns.size()-1);
        recursionSubsets(nums, i+1, ls, ns);



    }
}
