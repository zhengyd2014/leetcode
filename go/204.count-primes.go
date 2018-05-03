/*
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (26.50%)
 * Total Accepted:    153.4K
 * Total Submissions: 578.8K
 * Testcase Example:  '0'
 *
 * Description:
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Credits:Special thanks to @mithmatt for adding this problem and creating all
 * test cases.
 */
func countPrimes(n int) int {
	if n <= 1 {
		return 0
	}

	notPrimes := make([]bool, n)
	notPrimes[1] = true
	for i := 2; i < n; i++ {
		if notPrimes[i] {
			continue
		}

		for j := i + i; j < n; j += i {
			notPrimes[j] = true
		}
	}

	count := 0
	for i := 2; i < n; i++ {
		if !notPrimes[i] {
			count++;
		}
	}	

	return count
}
