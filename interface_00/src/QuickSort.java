import java.util.Arrays;
import java.util.Random;

public class QuickSort implements Sortable{

    @Override
    public int[] sort(int[] arr) {
        if (arr.length <= 1)
            return arr;
        if(arr.length == 2) {
            if(arr[0] > arr[1]) {
                int a = arr[0];
                arr[0] = arr[1];
                arr[1] = a;
            }
            return arr;
        }

        int rnd = new Random().nextInt(arr.length);
        int pivot = arr[rnd];

        int[] result = new int[arr.length];

        int lowrCountr = 0;
        int highrCountr = 0;

        for (int k : arr) {
            if (k < pivot) {
                lowrCountr++;
            } else if (k > pivot) {
                highrCountr++;
            }
        }

        int[] newArrLower = new int[lowrCountr + 1];
        int[] newArrHigher = new int[highrCountr];

        newArrLower = initArray(arr, pivot, newArrLower, true);
        newArrHigher = initArray(arr, pivot, newArrHigher, false);

        newArrLower[newArrLower.length - 1] = pivot;
        System.arraycopy(sort(newArrLower), 0, result, 0, lowrCountr + 1);
        System.arraycopy(sort(newArrHigher), 0, result, lowrCountr + 1, highrCountr);


    return result;
    }

    private int[] initArray(int[] arr, int pivot, int[] newArr, boolean isLower) {
        int j = 0;
        for (int k : arr) {
            if(isLower) {
                if (k < pivot) {
                    newArr[j] = k;
                    j++;
                }
            } else {
                if (k > pivot) {
                    newArr[j] = k;
                    j++;
                }
            }
        }

        return newArr;
    }


}
