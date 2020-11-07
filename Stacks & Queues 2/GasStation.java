//https://leetcode.com/problems/gas-station/

class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int stations = gas.length;
        int previous = 0; 
        
        int currGas = 0;
        int costFromPreviousStation = 0;
        
        int j ;
        
        outer:for(int i = 0; i < stations; i++) {
            j = i;
            costFromPreviousStation = 0;
            previous = 0;
            while(j == i || j % stations != i) {
                
                currGas = gas[j % stations];
                if(j != i) costFromPreviousStation = cost[(j-1) % stations];
            
                if(previous - costFromPreviousStation < 0) continue outer;
                previous = previous + currGas - costFromPreviousStation;
                j++;
            }
            if(previous - cost[(j-1) % stations] >= 0) return i;
        }
        return -1;
                
    }
}
