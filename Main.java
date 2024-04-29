import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final int ARRAY_SIZE = 400;
    private static final int NUM_THREADS = 4;
    public static void main(String[] args)  {

          int array[] = createArray();
          Thread[] threads = new Thread[NUM_THREADS];
          int segmentSize = ARRAY_SIZE/NUM_THREADS;
          for(int i =0;i< NUM_THREADS;i++){
              int startIndex = i*segmentSize;
              int endIndex = (i==NUM_THREADS-1)?ARRAY_SIZE-1:startIndex+segmentSize-1;
              threads[i] = new Thread(()->{
                 Arrays.sort(array,startIndex,endIndex+1);
              });
              threads[i].start();

          }
          for(Thread thread : threads){
              try {
                  thread.join();
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
          mergeSort(array,0,ARRAY_SIZE-1);
          System.out.println(Arrays.toString(array));
    }

    private static int[] createArray(){
        int array[]  = new int[ARRAY_SIZE];
         for(int i =0;i<ARRAY_SIZE;i++){
             array[i] = (int)(Math.random()*400);
         }
         return array;
    }
    private static void mergeSort(int[] array, int left, int right){
            if(left<right) {
                int mid = (left+right)/2;
                mergeSort(array,left,mid);
                mergeSort(array,mid+1,right);
                merge(array,left,mid,right);

    }}

    private static void merge(int[] array, int left , int mid, int right){
        int[] temp = new int[right-left+1];
        int i = left, j = mid+1,k =0;
        while(i<=mid&&j<=right){
            if(array[i]<=array[j]){
                temp[k++] = array[i++];
            }
            else temp[k++] = array[j++];

        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= right) {
            temp[k++] = array[j++];
        }
        System.arraycopy(temp, 0, array, left, temp.length);
    }
}