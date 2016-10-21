/**
 * Created by steffi on 2016/08/04.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Arrays;
import java.lang.Math;
import java.io.FileOutputStream;
import java.io.PrintStream;


public class DriverSort {

    static long startTime = 0;

    private static void tick() {
        startTime = System.nanoTime();
    }

    private static float tock() {
        return (System.nanoTime() - startTime) / 10000.0f;
    }


    //private static void tack(){
    //startTime = System.nanoTime();
    //}
//    private static float teck(){
//        return (System.nanoTime() - startTime) / 10000.0f;
//    }

    public static void main(String[] args) throws IOException {

        //Parameters: <sort> <arraySizeMin> <arraySizeMax> <arraySizeIncr> <outFileName>
        int[] arr;
        int[] arr2;
        float speedup = 0;
        int threshold = 0;
        int optNumThreads = 0;
        //Otherwise nothing will be less than zero!
        float bestTime = Integer.MAX_VALUE;
        float bestSpeedup = 0;
        float arrSort = 0;
        float timeSpan = 0;
        String alg = args[0]; //specifies the sorting algorithm
        int ASmin = Integer.parseInt(args[1]); //size of the smallest (random) array of integers to be sorted
        int ASmax = Integer.parseInt(args[2]); //size of the largest (random) array of integers to be sorted
        int ASinc = Integer.parseInt(args[3]); //step size for increasing the array of integers to be sorted
        String outFileName = args[4]; //name of the file to which the output data will be written

        PrintWriter pw = new PrintWriter(outFileName);


        //FileOutputStream fos = new FileOutputStream(outFileName);
        //PrintStream p = new PrintStream(fos);
        //System.setOut(p);
        System.out.println("Array Size " + "\t" + "Optimal Num of Threads " + "\t" + "Best Time  " +  "\t" +"Best Speedup ");


        for (int i = ASmin; i < ASmax; i += ASinc) {
//            optNumThreads = 0;
            arr = new int[i];
            arr2 = new int[i];
            bestSpeedup = 0; //IMPORTANT

            for (int k = 0; k < i - 1; k++) {
                arr[k] = (int) (Math.random() * 1000001);
            }

            for (int thread = 1; thread <= 1024; thread*=2) {

                threshold = i / thread;
                bestTime = Integer.MAX_VALUE; //IMPORTANT


                arr2 = arr.clone();
                tick();
                Arrays.sort(arr2);
                arrSort = tock();

                if (alg.equalsIgnoreCase("Mergesort")) {

                    for (int y = 0; y < 5; y++) {
                        timeSpan = 0;
                        System.gc(); //Garbage collection

                        //public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
                        arr2 = arr.clone();
                        MergesortParallel ms = new MergesortParallel(arr2, 0, arr2.length - 1, threshold);
                        //System.gc(); //Garbage collection
                        tick();
                        ms.invoke(); //invoke instead of compute
                        timeSpan = tock();

                        if (timeSpan < bestTime) {
                            bestTime = timeSpan;

                        }
                        speedup = arrSort / timeSpan;

                        if (speedup > bestSpeedup){
                            bestSpeedup = speedup;
                            optNumThreads = thread;
                        }

                    }

                    //System.out.println(optNumThreads);

                }

                else if (alg.equalsIgnoreCase("Quicksort")) {

                    for (int s = 0; s < 5; s++) {
                        System.gc(); //Garbage collection

                        //public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
                        System.arraycopy(arr, 0, arr2, 0, arr.length);
                        QuicksortParallel qs = new QuicksortParallel(arr2, 0, arr2.length, threshold);
                        tick();
                        qs.invoke(); //invoke instead of compute
                        timeSpan = tock();

                        if (timeSpan < bestTime) {
                            bestTime = timeSpan;

                        }
                        speedup = arrSort / timeSpan;

                        if (speedup > bestSpeedup){
                            bestSpeedup = speedup;
                            optNumThreads = thread;
                        }

                    }

                }

                else {
                    System.out.println("Invalid Input");
                }

                //System.out.println("Array Size: " + arr.length + "     Optimal Number of Threads: " + optNumThreads + "     Best Time: " + bestTime + "     Best Speedup: " + bestSpeedup);
            }

            String output =  arr.length + "          \t" + optNumThreads + "          \t" + bestTime + "          \t" + bestSpeedup;
            System.out.println(output);
            pw.write(output);

        }
        pw.close();
    }
}



//speedup = arr.sort/paralellizationTime

        /*public void print(String outFileName, int optNumThreads, int bestTime, int bestSpeedup, int ASinc, int ASmin, int ASmax) throws IOException {

            try{
                File file = new File (outFileName);

                PrintWriter pw = new PrintWriter (file);

                for (int j = ASmin; j < ASmax -1; j *= ASinc){
                pw.println(j + optNumThreads + bestTime + bestSpeedup);}

                pw.close();}

            catch (Exception e) {System.err.print(e.getStackTrace());}



            //The output file, <outFileName>, should consist of successive lines :
            //<arraySizeMin> <optimalNumThreads> <bestTime> <bestSpeedup>
            //<arraySizeMin+arraySizeIncr> <optimalNumThreads> <bestTime> <bestSpeedup>
        }  */
