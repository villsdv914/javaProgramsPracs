public class Isomorphic {

    public static void main(String[] args){
        System.out.print(isIsomorphic("egg", "ada"));
    }
    public static boolean isIsomorphic(String s, String t) {
        int[] lastSeenPositionS = new int[256];
        int[] lastSeenPositionT = new int[256];

        int length = s.length();
        for(int i = 0; i < length; i++){
            char charFromS = s.charAt(i);
            char charFromT = t.charAt(i);

            if(lastSeenPositionS[charFromS] != lastSeenPositionT[charFromT]){
                return false;
            }

            lastSeenPositionS[charFromS] = i + 1;
            lastSeenPositionT[charFromT] = i + 1;
        }

        return true;
    }
}


