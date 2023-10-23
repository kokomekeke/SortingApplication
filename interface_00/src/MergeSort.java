import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Utils.Utils.toIntArr;
import static Utils.Utils.toIntegerArr;

public class MergeSort implements Sortable{
    private final List<Integer[]> arrayContainer = new ArrayList<>();
    private Integer[] sortResult;
    private boolean isOrdered = false;

    @Override
    public int[] sort(int[] arr) {
        partition(toIntegerArr(arr));
        mergeAndSort(arrayContainer);
        return null;
    }

    private void mergeAndSort(List<Integer[]> arr) {
        if(arr.size() == 1 || isOrdered) {
            isOrdered = true;
            sortResult = arr.get(0);
            return;
        }
        List<Integer[]> res = new ArrayList<>(arr.size() / 2);
        if(arr.size() % 2 == 0) {
            int i = 0;
            while(i < arr.size()) {
                if(arr.size() - i > 1) {
                    res.add(Utils.Utils.toIntegerArr(
                            merge(Utils.Utils.toIntArr(arr.get(i)), Utils.Utils.toIntArr(arr.get(i+1)))));
                    i += 2;
                    continue;
                }
                res.add(arr.get(i));
                i++;
            }
            mergeAndSort(res);

        } else {
            int i = 0;
            while(i < arr.size()) {
                if(arr.size() - i > 1) {
                    res.add(Utils.Utils.toIntegerArr(
                            merge(Utils.Utils.toIntArr(arr.get(i)), Utils.Utils.toIntArr(arr.get(i+1)))));
                    i += 2;
                    continue;
                }
                res.add(arr.get(i));
                i++;
            }
            mergeAndSort(res);
        }
    }

    public int[] partition(Integer[] arr) {
        if(arr.length == 1) {
            arrayContainer.add(arr);
            return toIntArr(arr);
        }
        if(arr.length % 2 != 0) {
            int size = arr.length / 2;
            int n = arr[size];

            int[] subArr1 = new int[size + 1];
            int[] subArr2 = new int[size];

            for(int i = 0; i < size; i ++) {
                subArr1[i] = arr[i];
            }
            subArr1[size] = n;
            for(int i = size + 1, j = 0; i < arr.length; i ++, j ++) {
                subArr2[j] = arr[i];
            }
            partition(Utils.Utils.toIntegerArr(subArr1));
            partition(Utils.Utils.toIntegerArr(subArr2));
        } else {
            int size = arr.length / 2;

            int[] subArr1 = new int[size];
            int[] subArr2 = new int[size];

            for(int i = 0; i < size; i ++) {
                subArr1[i] = arr[i];
            }
            for(int i = size, j = 0; i < arr.length; i ++, j ++) {
                subArr2[j] = arr[i];
            }
            partition(Utils.Utils.toIntegerArr(subArr1));
            partition(Utils.Utils.toIntegerArr(subArr2));
        }
        return null;
    }


    public int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int temp;

        for(int i = 0; i < arr1.length; i ++) {
            for(int j = 0; j < arr2.length; j ++) {
                if(arr1[i] > arr2[j]) {
                    temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
        }

        for(int i = 0; i < arr1.length; i ++) {
            for(int j = i; j < arr1.length; j ++) {
                if(arr1[i] > arr1[j]) {
                    temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                }
            }
        }

        for(int i = 0; i < arr2.length; i ++) {
            for(int j = i; j < arr2.length; j ++) {
                if(arr2[i] > arr2[j]) {
                    temp = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
        }

        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        return result;
    }

    public void printList(List<Integer[]> arr) {
        for(Integer[] e : arr) {
            System.out.println(Arrays.toString(e));
        }
    }

    public Integer[] getSortResult() {
        return sortResult;
    }
}
