/**
 * Created by Haylem on 4/08/2016.
 */
public class ArraySort {

    public static int[] sort(int[] array){
        return split(array);
    }

    private static int[] split(int[] array){
        if(array.length==1){
            return array;
        } else if(array.length==2){
            if(array[0] > array[1]){
                return new int[]{array[1], array[0]};
            }
        }
        int mid = (array.length-1)/2;
        int[] a1 = split(splitArray(array, 0, mid));
        int[] a2 = split(splitArray(array, mid+1, array.length-1));
        return merge(a1, a2);

    }

    private static int[] splitArray(int[] array, int low, int high){
        int[] nArray = new int[high-low+1];
        int c = 0;
        for(int i = low; i <= high; i ++){
            nArray[c] = array[i];
            c++;
        }
        return nArray;
    }

    private static int[] merge(int[] a1, int[] a2){
        int[] nA = new int[a1.length+a2.length];
        int nA_index = 0;
        int a1_index = 0;
        int a2_index = 0;
        while(a1_index < a1.length && a2_index < a2.length){
            if(a1[a1_index]<a2[a2_index]){
                nA[nA_index]=a1[a1_index];
                a1_index++;
            } else  {
                nA[nA_index]=a2[a2_index];
                a2_index++;
            }
            nA_index++;
        }

        if(a1_index >= a1.length){
            while(a2_index < a2.length){
                nA[nA_index] = a2[a2_index];
                a2_index++;
                nA_index++;
            }
        } else {
            while(a1_index < a1.length){
                nA[nA_index] = a1[a1_index];
                a1_index++;
                nA_index++;
            }
        }

        return nA;
    }

}
