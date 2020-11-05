//https://leetcode.com/problems/meeting-rooms-ii/

class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        int rooms = 0;
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((Integer a, Integer b) -> a - b);

        for(int[] inter : intervals) {
            
            if(!pQueue.isEmpty()) System.out.println(inter[0] + "  " + pQueue.peek());
            if(pQueue.isEmpty() || pQueue.peek() > inter[0]){
                rooms++;
            }
            else pQueue.poll();
            
            pQueue.add(inter[1]);


        }
        return rooms;
    }
}
