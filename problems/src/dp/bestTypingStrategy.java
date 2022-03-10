package dp;

/**
 * @Description 最优打字策略
 * @Author Zhang Qihang
 * @Date 2022/3/2 22:33
 */
public class bestTypingStrategy {
    public void bestFunc(String str) {
        //1. dp的定义 dp[i][j]表示考虑str[0..i]后在状态j时的最少按键次数,j为0表示小写状态，j为1表示大写状态
        //2. dp的转移 如果当前为大写字母，结束在小写状态，dp[i][0] = min(dp[i-1][0](上一次为小写状态)+2,dp[i-1][1](上一次在大写状态)+2)
        //           如果当前为大写字母，结束在大写状态，dp[i][1] = min(dp[i-1][0](上一次为小写状态)+2,dp[i-1][1](上一次在大写状态)+1)
        //           如果当前为小写，dp[i][1] =
    }
}
