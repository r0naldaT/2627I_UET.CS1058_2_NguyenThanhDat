package homework.week5.LapTrinh;

public class b2 {
    public static void mergeSort(int[] array){
        int size = array.length;
        //Base case
        if (size <= 1){
            return;
        }

        int middle = size / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[size - middle];

        int i = 0, j = 0;
        while (i < size){
            if (i < middle){
                leftArray[i] = array[i];
            }
            else{
                rightArray[j] = array[i];
                j++;
            }
            i++;
        }

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array){
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;

        int i = 0, l = 0, r = 0;

        while (l < leftSize && r < rightSize){
            if(leftArray[l] < rightArray[r] ){
                array[i] = leftArray[l];
                l++;
            }
            else{
                array[i] = rightArray[r];
                r++;
            }
            i++;
        }

        while(l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize){
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

    public static void main(String[] args){
        int[] array = {6, 3, 2, 5, 4, 1, 7};

        mergeSort(array);

        for(int n: array){
            System.out.print(n + " ");
        }
    }
}
