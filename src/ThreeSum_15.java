import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum_15 {
    // 先排序，然后遍历索引
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        if(len==0){
            return res;
        }
        if (nums[0] > 0 || nums[len-1] < 0) {
            return res;
        }
        for (int i = 0; i < len; i++) {
            if(nums[i]>0)break;
            // 如果当前数和上一个数相同，那么就直接跳过即可，因为上一个的范围更广，所以这一次的结果上一次一定已经求出来了
            if(i > 0 && nums[i] == nums[i-1])continue;

            int another_num = -nums[i];
            int j = i + 1, k = len - 1;
            while (j<k){
                if(nums[j]+nums[k]>another_num){
                    k--;
                }else if(nums[j]+nums[k]<another_num) {
                    j++;
                }else {
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    // 找到一个结果，继续进行循环，如果下一个左/右数和当前的数一样，那么一定会产生重复解。
                    // 所以要跳过
                    while(j<k && nums[k] == nums[k-1]) k--;
                    while(j<k && nums[j] == nums[j+1]) j++;
                    j++;
                    k--;
                }
            }
        }
        return res;
    }
}
