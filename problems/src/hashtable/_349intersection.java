package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _349intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> record = new HashSet<Integer>();
        Set<Integer> unique = new HashSet<Integer>();
        for (int num : nums1) {
            record.add(num);
        }

        for (int num : nums2) {
            if (record.contains(num)) {
                unique.add(num);
            }
        }

        int[] res = new int[unique.size()];
        int index = 0;
        for (int num : unique) {
            res[index++] = num;
        }
        return res;
    }
}
