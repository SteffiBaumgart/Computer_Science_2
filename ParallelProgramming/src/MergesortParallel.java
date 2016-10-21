/**
 * Created by steffi on 2016/08/04.
 */
import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class MergesortParallel extends RecursiveAction {
    private int[] arr;
    private int start, end;
    private int threshold;

    public MergesortParallel(int[] arr, int start, int end, int threshold) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.threshold = threshold;
    }

    @Override
    protected void compute() {
        if (end - start <= threshold) {
            Arrays.sort(arr, start, end);
            return;
        }

        // Sort halves in parallel
        int mid = (start + (end)) / 2;
        invokeAll(
                new MergesortParallel(arr, start, mid, threshold),
                new MergesortParallel(arr, mid, end, threshold));
        sequentialmerge(mid);

    }

    public void sequentialmerge(int mid){
        
        int[] first = Arrays.copyOfRange(arr,start,mid);
        int[] second = Arrays.copyOfRange(arr,mid,end);
        int pos = start;
        int count1 = 0, count2 = 0;

        while(count1 < first.length && count2 < second.length){
            if(first[count1] <= second[count2]){
                arr[pos++] = first[count1++];
            }

            else{
                arr[pos++] = second[count2++]; }
        }

        while(count1 < first.length){
            arr[pos++] = first[count1++];
        }

        while(count2 < second.length){
            arr[pos++] = second[count2++];
        }

    }



}