import ecs100.UI;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Haylem on 4/08/2016.
 */
public class Grapher {

    private static int left;
    private static int bottom;
    private static int height;
    private static int width;

    public static void initialize(int l, int b, int h, int w){
        left = l;
        bottom = b;
        height = h;
        width = w;
    }

   public static void graphFrequencies(int[] array, int max){

       int minY = bottom - height;
       int maxX = left + width;

       int barWidth = (int)(width / array.length);
       int heightRatio = height/max;

       int barLeft = left;
       for(int i = 0; i < array.length; i++){
           int screenHeight = heightRatio * array[i];
           UI.fillRect(barLeft, bottom-screenHeight,barWidth,screenHeight);
           barLeft = barLeft+barWidth;
       }
   }

}
