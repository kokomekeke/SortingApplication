import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] list = {6, 1, 4, 5, 2, 3, 7};
//        System.out.println(Arrays.toString(new QuickSort().sort(list)));
//        System.out.println(Arrays.toString(new MergeSort().sortHelper(list)));

        MergeSort merge = new MergeSort();
        merge.sort(list);
//        System.out.println("result: " +Arrays.toString(merge.getSortResult()));


    }
}
