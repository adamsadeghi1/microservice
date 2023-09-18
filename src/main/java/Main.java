//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Stack;
//
//public class Main {
//    public static void main(String[] args) {
//        String s = "|*****";
////        System.out.println(fetchDepartmentNumber(s));
//        String A = "madam";
//
//
//
//        System.out.println(A.substring(0));
//    }
//
//    private static int fetchDepartmentNumber(String s){
//        int count=0;
//        List<Integer> pipIndex = new ArrayList<>();
//
//        for (int z = 0; z < s.length(); z++) {
//            if (s.charAt(z) == '|')
//                pipIndex.add(z);
//        }
//
//        for (int x = 0; x < pipIndex.size(); x++) {
//            if (x+1 <pipIndex.size() && pipIndex.get(x) + 1 < pipIndex.get(x+1)){
//                count++;
//            }
//        }
//
//        return count;
//    }
//
//    private static String reverseCheck(String A){
//        String B="";
//        var s = new Stack<Character>();
//        for (int i = 0; i < A.length(); i++) {
//            s.push(A.charAt(i));
//        }
//
//        while (!s.empty()){
//            B= B+ s.pop();
//        }
//
//        if (B.equals( A)){
//            return "Yes";
//        }else{
//             return  "No";
//        }
//    }
//
//    private static HashMap<Character, Integer> characterNumebr(String a){
//        HashMap<Character,Integer> firstString = new HashMap<>();
//        for (int i = 0; i < a.length(); i++) {
//            if (firstString.containsKey(a.charAt(i))){
//                firstString.put(a.charAt(i), firstString.get(a.charAt(i)) +1);
//            }else{
//                firstString.put(a.charAt(i), 1);
//            }
//        }
//        return firstString;
//    }
//
//}
