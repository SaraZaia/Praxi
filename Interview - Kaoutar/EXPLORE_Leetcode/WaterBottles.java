//https://leetcode.com/problems/water-bottles/

class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = 0;
        int currBottle = numBottles;
        int empty = 0;
        int temp = 0;
        while(currBottle > 0) {
            result += currBottle;

            temp =  (currBottle + empty) / numExchange;
            empty = (currBottle + empty) % numExchange;
            currBottle = temp;
        }
        return result + currBottle;
    }
}
/*

15 / 8 = 1
result = 15 + 1 + 2
empty = 7

15 + 15/8 + 

7 + 1
*/
