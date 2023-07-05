package ca.bytetube._00_leetcode._02_stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * @author dal
 */
public class SlidingWindowMaximum {
    /**
     * 1.If nums[i] >= nums[tail],removing tail until nums[tail] > nums[i]
     * 2.Add index i into tail of dequeue
     * 3.If W >= 0(第一个合法窗口形成)
     * * Remove expired head of dequeue (value of head < w)
     * * Update window max value at W position to nums[head]
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;

        int[] maxes = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();//
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) deque.pollLast();
            deque.addLast(i);

            int w = i - k + 1;
            if (w < 0) continue;
            //代码能够走到这里，说明合法窗口已经形成

            if (w > deque.peekFirst()) deque.removeFirst();//删除过期队头元素
            maxes[w] = nums[deque.peekFirst()];

        }

        return maxes;
    }
}
