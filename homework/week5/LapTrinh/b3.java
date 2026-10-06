package homework.week5.LapTrinh;

public class b3 {

    public static void quickSort(int[] array, int start, int end){
        if(start >= end){
            return;
        }
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot+1, end);
    }
    private static int partition(int[] array, int start, int end){
        int pivot = array[end];

        int i = start - 1;

        for(int j = start; j < end ; j++){
            if (array[j] < pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = pivot;
        array[end] = temp;
        return i;
    }
    public static void main(String[] args){
        int[] array = {6, 3, 2, 5, 4, 1, 7};

        quickSort(array, 0 , array.length - 1);

        for(int n: array){
            System.out.print(n + " ");
        }
    }
}
