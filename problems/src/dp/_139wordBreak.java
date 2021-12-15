package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @className: _139wordBreak
 * @Description: 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * @author: Zhang Qihang
 * @date: 2021/12/15 11:06
 */
public class _139wordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        //1. dp[j]表示s[0:j-1]可以是否可以被拆分(true or false)
        //2. dp[j]=true 当且仅当 dp[i]为true&&[j,i]是一个子串时才成立(在当前子串匹配时)
        //3. 初始化
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        StringBuffer temp = new StringBuffer();
        //4. 没有办法保证先匹配上哪个单词，所以应该全排列单词，而不是组合，因此应该先遍历重量，再遍历物品
        //这里内层的循环和物品没关系了，他是从0到j，而不是之前的在物品内部进行循环
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (wordDict.contains(s.substring(i, j)) && dp[i]) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");
        wordBreak(s, wordDict);
    }
}
