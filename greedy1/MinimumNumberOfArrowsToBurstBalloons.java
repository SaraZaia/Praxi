//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;        
        Arrays.sort(points, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));
        
        int previousEndBallons = Integer.MAX_VALUE;
        int result = 1;
        for(int[] ballon : points) {
            if(ballon[0] <= previousEndBallons) {
                previousEndBallons = Math.min(ballon[1], previousEndBallons);
            } else {                
                result++;
                previousEndBallons = ballon[1];
            }
        }
        return result;
    }
}

    
//[[0,12],[3,5],[6,9],[8,13],[13,14]]
// previousEndBallons = 14
// result = 3

//[[1,2],[2,3],[3,4],[4,5]]
// previousEndBallons = 2
// result = 1


// [[-2147483646,-2147483645],[2147483646,2147483647]]
// previousEndBallons = -2147483645
// result = 1
