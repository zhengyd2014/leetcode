import java.util.Queue;

/*
 * @lc app=leetcode id=841 lang=java
 *
 * [841] Keys and Rooms
 *
 * https://leetcode.com/problems/keys-and-rooms/description/
 *
 * algorithms
 * Medium (61.45%)
 * Likes:    756
 * Dislikes: 65
 * Total Accepted:    62.5K
 * Total Submissions: 99.1K
 * Testcase Example:  '[[1],[2],[3],[]]'
 *
 * There are N rooms and you start in room 0.  Each room has a distinct number
 * in 0, 1, 2, ..., N-1, and each room may have some keys to access the next
 * room. 
 * 
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j]
 * is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j]
 * = v opens the room with number v.
 * 
 * Initially, all the rooms start locked (except for room 0). 
 * 
 * You can walk back and forth between rooms freely.
 * 
 * Return true if and only if you can enter every room.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [[1],[2],[3],[]]
 * Output: true
 * Explanation:  
 * We start in room 0, and pick up key 1.
 * We then go to room 1, and pick up key 2.
 * We then go to room 2, and pick up key 3.
 * We then go to room 3.  Since we were able to go to every room, we return
 * true.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can't enter the room with number 2.
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * The number of keys in all rooms combined is at most 3000.
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) return false;

        int n = rooms.size();
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        visited[0] = true;
        for (int key : rooms.get(0)) {
            q.offer(key);
        }

        while (!q.isEmpty()) {
            int room = q.poll();
            if (!visited[room]) {
                visited[room] = true;
                for (int key : rooms.get(room)) {
                    q.offer(key);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }

        return true;
    }
}
// @lc code=end

