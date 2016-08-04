/**
 * Created by Haylem on 4/08/2016.
 */

import ecs100.*;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Main {

    int[] array;

    public Main(){
        UI.initialise();
        UI.addButton("Merge Sort", this::mergeSort);
        UI.addButton("Graph frequencies", ()->{graphFrequencies(array);});

    }

    public void graphFrequencies(int[] array){
        Map<Integer, Integer> f = new HashMap<Integer, Integer>();
        for(int i = 0; i < array.length; i++){
            if(f.containsKey(array[i])){
                f.put(array[i],f.get(array[i])+1);
            } else {
                f.put(array[i],1);
            }
        }

        int max = maxInMap(f);

        int[] orderedF = new int[f.keySet().size()];
        for(Integer key: f.keySet()){
            orderedF[key] = f.get(key);
        }

        Grapher.graphFrequencies(orderedF,max);
    }

    private  int maxInMap(Map<Integer, Integer> map){
        int max = Integer.MIN_VALUE;
        for(Integer key: map.keySet()){
            if(map.get(key)>max){
                max = map.get(key);
            }
        }
        return max;
    }

    public void mergeSort(){
        UI.clearText();
        UI.print("Length of array: ");
        array = new int[promptInt()];
        UI.print("Maximum value in array: ");
        int maxValue = promptInt();
        for(int i = 0; i < array.length; i ++){
            array[i] = (int)(Math.random()*maxValue);
        }

        array = ArraySort.sort(array);
        printArray(array);
    }

    public int interpolationSearch(int[] sortedArray, int toFind){
        int low = 0;
        int high = sortedArray.length - 1;
        int mid;
        while(sortedArray[low] <= toFind && sortedArray[high] >= toFind){
            if (sortedArray[high] - sortedArray[low] == 0){
                return (low + high)/2;
            }
            mid = low + ((toFind - sortedArray[low]) * (high - low)) / (sortedArray[high] - sortedArray[low]);
            if(sortedArray[mid] < toFind){
                low = mid + 1;
            } else if(sortedArray[mid] > toFind){
                high = mid - 1;
            } else {
                return mid;
            }
        }
        if(sortedArray[low] == toFind){
            return low;
        } else {
            return -1;
        }
    }

    public int promptInt(){
        int r = UI.askInt("Input a number between greater than zero");
        while(r < 0){
            r = UI.askInt("Input a number between greater than zero");
        }
        return r;
    }

    public void printArray(int[] array){
        UI.println("--------");
        for(int i = 0; i < array.length; i ++){
            UI.printf("%4d\n",array[i]);
        }
    }

    public static void main(String[] args){
        Grapher.initialize(20,400,400,400);
        new Main();
    }

}
