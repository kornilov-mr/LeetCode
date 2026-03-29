package normal;

import java.util.ArrayList;

/**
 * Reschedule Meetings for Maximum Free Time I
 * <a href="https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-i/description/">...</a>
 */
public class RescheduleMeetingsForMaximumFreeTime {
    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        ArrayList<Integer> freeTime = new ArrayList<>();
        freeTime.add(startTime[0]);
        for(int i =1;i<startTime.length;i++){
            freeTime.add(startTime[i] - endTime[i-1]);
        }
        freeTime.add(eventTime-endTime[endTime.length-1]);


        if(freeTime.size()<=k+1){
            int sum = 0;
            for(int i=0;i<freeTime.size();i++){
                sum+=freeTime.get(i);
            }
            return sum;
        }
        int sum = 0;
        for(int i=0;i<k+1;i++){
            sum+=freeTime.get(i);
        }
        int maxWindow = sum;
        for(int i=k+1;i<freeTime.size();i++){
            sum -=freeTime.get(i-k-1);
            sum +=freeTime.get(i);
            maxWindow = Math.max(maxWindow,sum);
        }
        return maxWindow;
    }

    public static void main(String[] args) {
        int[] startTime = new int[]{0,2,9};
        int[] endTime = new int[]{1,4,10};
        System.out.println(maxFreeTime(10,1,startTime,endTime));
    }
}
