import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DisJointSetValue {
    List<Integer> size = new ArrayList<>();
    List<Integer> parents = new ArrayList<>();
    public DisJointSetValue(int n){

        for(int i = 0; i <= n; i++){
            size.add(1);
            parents.add(i);
        }
    }

    public int findpar(int node){
        if(node == parents.get(node)){
            return node;
        }
        int u = findpar(parents.get(node));
        parents.set(node, u);
        return parents.get(node);
    }

    public void disjointSize(int u, int v){
        int uP = findpar(u);
        int vP = findpar(v);
        if(uP == vP) return;
        if(size.get(uP) < size.get(vP)){
            parents.set(uP, vP);
            size.set(vP, size.get(uP) + size.get(vP));
        }else{
            parents.set(vP, uP);
            size.set(uP, size.get(uP) + size.get(vP));

        }
    }


}

class  DisJointSet{
    public static void main(String[] args){
        DisJointSetValue ds = new DisJointSetValue(7);
        ds.disjointSize(1, 2);
        ds.disjointSize(2, 3);
        ds.disjointSize(4, 5);
        ds.disjointSize(6, 7);
        ds.disjointSize(5, 6);

        // if 3 and 7 same or not
        if (ds.findpar(3) == ds.findpar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.disjointSize(3, 7);
        if (ds.findpar(3) == ds.findpar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}


