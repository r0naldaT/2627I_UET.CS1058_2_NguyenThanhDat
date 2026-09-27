package homework.week3.LapTrinh;

import java.util.List;

public class equalStacks {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int height1 = 0;
        int height2 = 0;
        int height3 = 0;

        for(int i: h1){
            height1 += i;
        }
        for(int i: h2){
            height2 += i;
        }
        for(int i: h3){
            height3 += i;
        }

        int i = 0; int j = 0; int k = 0;

        while (i < h1.size() && j < h2.size() && k < h3.size()){
            if (height1 == height2 && height1 == height3){
                return height1;
            }
            int maxHeight = Math.max(height1, height2);
            maxHeight = Math.max(maxHeight, height3);
            if (height1 == maxHeight){
                height1 -= h1.get(i);
                i++;
            }
            if (height2 == maxHeight){
                height2 -= h2.get(j);
                j++;
            }
            if (height3 == maxHeight){
                height3 -= h3.get(k);
                k++;
            }
        }
        return 0;
    }
}
