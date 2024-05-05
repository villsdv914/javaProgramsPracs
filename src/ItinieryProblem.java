import java.util.*;

public class ItinieryProblem {
    public static void main(String[] args){
        String[][] tickets = {{"MIA", "ORD"},{"DFW","JFK"},{"SFO","DFW"},{"JFK", "MIA"}};
        HashMap<String, Queue<String>> mp = new HashMap<>();
        HashMap<String, Integer> stmp = new HashMap<>();

        for(int i = 0; i < tickets.length; i++){
            String src = tickets[i][0];
            String dst = tickets[i][1];
            if(mp.containsKey(src)){
                mp.get(src).offer(dst);

            }else{
                mp.put(src, new PriorityQueue<>());
                mp.get(src).offer(dst);

            }
        }
        for(int i = 0; i < tickets.length; i++){
            String src = tickets[i][0];
            if(stmp.containsKey(src)){
                stmp.put(src,stmp.get(src)+1);
            }else{
                stmp.put(src, 1);
            }
        }
        for(int i = 0; i < tickets.length; i++){
            String src = tickets[i][1];
            if(stmp.containsKey(src)){
                stmp.put(src,stmp.get(src)+1);
            }else{
                stmp.put(src, 1);
            }
        }

        String[] s = new String[1];
        for(String[] tick : tickets){
           if( stmp.get(tick[0]) == 1){
               s[0] = tick[0];
           }
        }
        List<String> ls = new ArrayList<>();
        dfs(mp, s[0], ls);
        for(int k =1 ; k < ls.size(); k++){
            System.out.print(ls.get(k -1));
            System.out.print("-");
            System.out.print(ls.get(k));
            System.out.print(" ");
        }


    }

    public static void dfs( HashMap<String, Queue<String>> mp, String s, List<String> ls ){
        Queue<String> q = mp.get(s);
        while(q != null && !q.isEmpty()){
            dfs(mp, q.poll(), ls);
        }
        ls.add(0, s);
    }

}
