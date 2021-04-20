package array;

public class ContainerWithMostWater_11 {
    //高由较低的一个决定
    public int maxArea(int[] height) {
        int tail = height.length - 1;
        int head = 0;
        int maxSize = 0;
        while (head < tail) {
            int curSize = (tail - head) * Math.min(height[head], height[tail]);
            maxSize = Math.max(maxSize, curSize);
            if (height[head] > height[tail]) {
                tail -= 1;
            } else {
                head += 1;
            }
        }
        return maxSize;
    }
}
