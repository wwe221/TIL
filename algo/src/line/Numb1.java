package line;

import java.util.ArrayList;

class Numb1 {
    public boolean solution(int[] floor) {
      boolean result = true;
      int power = 1;
      int next = 1;
      ArrayList<Integer> list = new ArrayList<Integer>();
      for (int i = 0; i < floor.length; i++) {
         list.add(floor[i]);
      }
      int now = list.remove(0);   
      result = (jump(floor,0,1));
      return result;
   }
   static boolean jump(int[] floor , int idx, int power) {
      if(idx==floor.length-1)
         return true;
      int now = floor[idx];
      for(int i=idx+1;i<floor.length;i++) {
         int next = floor[i];
         if(next==now+power) {
            if(jump(floor,i,power))
               return true;
         }
         if(next==now+power+1) {
            if(jump(floor,i,power+1))
               return true;
         }
         if(next==now+power-1) {
            if(jump(floor,i,power-1))
               return true;
         }
      }
      return false;
   }
}
