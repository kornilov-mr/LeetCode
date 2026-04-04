package normal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Partition String
 * <a href="https://leetcode.com/problems/partition-string/description/">...</a>
 */
public class PartitionString {
    public List<String> partitionString(String s) {
        Set<String> seen = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            if(!seen.contains(sb.toString())){
                result.add(sb.toString());
                seen.add(sb.toString());
                sb.delete(0,sb.length());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PartitionString cl = new PartitionString();
        System.out.println(cl.partitionString("aaaa"));
    }
}
