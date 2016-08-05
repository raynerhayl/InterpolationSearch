import ecs100.UI;

/**
 * Created by Haylem on 5/08/2016.
 */
public class SortedArraySet {

    private String data[];
    private final int INITIAL_CAPACITY=10;
    private int count = 0;

    public SortedArraySet(){
        data = new String[INITIAL_CAPACITY];
    }

    public boolean add(String toAdd){

        int index;

        if(count > 0) {

            index = findIndex(toAdd);
            UI.println("ToAdd should be at: " + index);
            if (data[index] == toAdd) {
                return false;
            }

            ensureCapcity();

            for(int i = count; i > index; i--){
                data[i] = data[i-1];
            }

        } else{
            index = 0;
        }

        data[index] = toAdd;

        count++;

        return true;
    }

    public int findIndex(String toAdd) {

        int low = 0;
        int high = count - 1;
        int mid;

        System.out.println(low +" " + high + " " + count);

        while (data[low].hashCode() <= toAdd.hashCode() && data[high].hashCode() >= toAdd.hashCode()) {
            if (data[high].hashCode() - data[low].hashCode() == 0) {
                return (low + high) / 2;
            }

            mid = low + ((toAdd.hashCode() - data[low].hashCode()) * (high - low)) / (data[high].hashCode() - data[low].hashCode());
            System.out.println("mid: "+mid);

            int comp = data[mid].compareToIgnoreCase(toAdd);
            if (comp < 0) {
                low = mid + 1;
            } else if (comp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        if(toAdd.hashCode()>=data[high].hashCode()){
            return high;
        } else {
            return low;
        }
    }


    public void ensureCapcity(){

        String[] newArray = new String[data.length*2];
        for(int i = 0; i < data.length; i++){
            newArray[i] = data[i];
        }

        data = newArray;
    }

    public void print(){
        UI.println("-----ArraySet-----");
        for(int i = 0; i < count; i++){
            UI.println(data[i]);
        }
        UI.println("------------------");
    }


}
