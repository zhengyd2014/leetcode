class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        
        int start = 1;
        int end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if ( x / mid >= mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (x / end == end) {
            return end;
        } else {
            return start;
        }
    }
}