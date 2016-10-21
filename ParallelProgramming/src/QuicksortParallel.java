/**
 * Created by steffi on 2016/08/04.
 */
import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class QuicksortParallel extends RecursiveAction {
    private int[] array;
    private int low, high;
    private int threshold;

    public QuicksortParallel(int[] arr, int start, int end, int threshold) {
        this.array = arr;
        this.low = start;
        this.high = end;
        this.threshold = threshold;
    }

    @Override
    protected void compute() {
        if (high - low <= threshold) {
            Arrays.sort(array, low, high);
            return;
        }
       // System.out.println(high-low);
        int count = low;
        int pivot = high-1;
        while (count < pivot){
            if(array[count] > array[pivot]){
                int place = array[pivot-1];
                array[pivot -1] = array[pivot];
                array[pivot] = place;
                place = array[count];
                array[count] = array[pivot];
                array[pivot] = place;
                pivot--; }
            else {
                count++;
            }
        }
        //System.out.println(low + " " + pivot + " " + high);
        invokeAll(
                new QuicksortParallel(array, low, pivot, threshold),
                new QuicksortParallel(array, pivot, high, threshold));
    }

}


