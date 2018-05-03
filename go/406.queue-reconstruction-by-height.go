/*
 * [406] Queue Reconstruction by Height
 *
 * https://leetcode.com/problems/queue-reconstruction-by-height/description/
 *
 * algorithms
 * Medium (56.49%)
 * Total Accepted:    44.9K
 * Total Submissions: 79.6K
 * Testcase Example:  '[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]'
 *
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * 
 * Note:
 * The number of people is less than 1,100.
 * 
 * 
 * 
 * 
 * Example
 * 
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 
 * 
 */
func reconstructQueue(people [][]int) [][]int {
	res := people

	sort.Slice(people, func(i, j int) bool {
		if people[i][0] > people[j][0] {
			return true
		}
		if people[i][0] == people[j][0] && people[i][1] < people[j][1] {
			return true
		}

		return false
	})

	for i, p := range people {
		k := p[1]
		copy(res[k + 1 : i + 1], res[k : i])
		res[k] = p
	}

	return res
}


