public class Solution {
    public int singleNumber(int[] A) {
          int ones = 0, twos = 0, threes = 0;
        for(int i = 0;i<A.length;i++){
            twos = twos | (ones & A[i]);//update twos with the digits that appeared once before and now again in A[i]
            ones = ones ^ A[i];//if not appeared before, add. If appeared again, remove
            threes = ones & twos;//if appeared one and two then appeared three times
            ones = ones & ~threes;//remove digit that appeared three times in ones
            twos = twos & ~threes;//remove digit that appeared three times in twos
        }
        return ones;//the number that has appeared just once
    }
}