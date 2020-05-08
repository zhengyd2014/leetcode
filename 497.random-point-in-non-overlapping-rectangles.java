/*
 * @lc app=leetcode id=497 lang=java
 *
 * [497] Random Point in Non-overlapping Rectangles
 *
 * https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/description/
 *
 * algorithms
 * Medium (37.35%)
 * Likes:    178
 * Dislikes: 179
 * Total Accepted:    11.6K
 * Total Submissions: 31.1K
 * Testcase Example:  '["Solution", "pick", "pick", "pick"]\n[[[[1, 1, 5, 5]]], [], [], []]'
 *
 * Given a list of non-overlapping axis-aligned rectangles rects, write a
 * function pick which randomly and uniformily picks an integer point in the
 * space covered by the rectangles.
 * 
 * Note:
 * 
 * 
 * An integer point is a point that has integer coordinates. 
 * A point on the perimeter of a rectangle is included in the space covered by
 * the rectangles. 
 * ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer
 * coordinates of the bottom-left corner, and [x2, y2] are the integer
 * coordinates of the top-right corner.
 * length and width of each rectangle does not exceed 2000.
 * 1 <= rects.length <= 100
 * pick return a point as an array of integer coordinates [p_x, p_y]
 * pick is called at most 10000 times.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * ["Solution","pick","pick","pick"]
 * [[[[1,1,5,5]]],[],[],[]]
 * Output: 
 * [null,[4,1],[4,1],[3,3]]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 
 * ["Solution","pick","pick","pick","pick","pick"]
 * [[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
 * Output: 
 * [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
 * 
 * 
 * 
 * Explanation of Input Syntax:
 * 
 * The input is two lists: the subroutines called and their arguments.
 * Solution's constructor has one argument, the array of rectangles rects. pick
 * has no arguments. Arguments are always wrapped with a list, even if there
 * aren't any.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start

// 497. Random Point in Non-overlapping Rectangles

// note: area is a little different to calc.  need "width + 1" * "height + 1"

class Solution {

    Random rand = new Random();
    TreeMap<Integer, Integer> idxMap = new TreeMap<>();
    int areaSum = 0;
    int[][] rects;
    
    public Solution(int[][] rects) {
        this.rects = rects;
        for (int[] rect : rects) {
            int width = rect[2] - rect[0] + 1;
            int height = rect[3] - rect[1] + 1;
            areaSum += width * height;
            idxMap.put(areaSum, idxMap.size());
        }
    }
    
    public int[] pick() {
        int r = rand.nextInt(areaSum);
        Integer index = idxMap.get(idxMap.higherKey(r));
        int[] rect = rects[index];
        int x = rect[0] + rand.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + rand.nextInt(rect[3] - rect[1] + 1);
        return new int[] {x, y};
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
// @lc code=end

