package StopWatch;

import java.util.Arrays;

public class StopWatch {
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
    public StopWatch(){
        startTime = System.currentTimeMillis();
    }
    public void start(){
        startTime = System.currentTimeMillis();
    }
    public void stop(){
        endTime = System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return endTime - startTime;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int[] arr = Sort.createArray(20000, 20, 10);
        Sort.selectionSort(arr);
        stopWatch.stop();
        System.out.println("thời gian đã trôi qua: " + stopWatch.getElapsedTime());
    }

}