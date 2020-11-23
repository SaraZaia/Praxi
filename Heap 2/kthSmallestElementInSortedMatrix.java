//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/


class kthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length ==0 || matrix[0].length == 0) return 0;
        
        int count = 0;
        PriorityQueue<Pair> pQueue = new PriorityQueue<>((Pair a, Pair b) -> a.number - b.number);
        int i = 0;
        for(int[] row : matrix) pQueue.add(new Pair(row[0], new int[]{i++,0}));

        Pair temp = new Pair(0, new int[]{0,0});
        int number;
        int[] position;
        while(count < k) {
            temp = pQueue.poll();
            count++;
            if(temp.position[1] < matrix.length - 1) {
                number = matrix[temp.position[0]][temp.position[1]+1];
                position = new int[]{temp.position[0], temp.position[1] + 1};
                pQueue.add(new Pair (number, position));
            }
            
        }
      return temp.number;
    }
    
    class Pair{
        int number;
        int[] position;
        
        Pair(int n, int[] p) {
            number = n;
            position = new int[] {p[0], p[1]};
        }
    }
}

