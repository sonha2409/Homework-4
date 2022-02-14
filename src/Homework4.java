import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Homework4 {
    public static int[] kLargestElement(int[] array, int k) {
        int[] result = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            queue.add(array[i]);
        }
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    public static LinkedList<Integer> mergeLinkedList(LinkedList<Integer>[] lists) {
        LinkedList<Integer> result = new LinkedList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for (int i = 0; i < lists.length; i++) {
            while (lists[i].peek() != null) {
                queue.add(lists[i].pop());
            }
        }
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }

    public static int lessThanOrEqual(int[] sortedArray, int target) {
        int first = 0;
        int last = sortedArray.length - 1;
        int count = 0;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (sortedArray[mid] <= target) {
                count = mid + 1;
                first = mid + 1;

            } else {
                last = mid - 1;
            }
        }
        return count;
    }

    public int rotatedPivot(int[] array, int target) {
        boolean result = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                result = true;
                break;
            }
        }
        if (result) {
            return 0;
        }
        return -1;
    }

    public static int[] sortArray(int[] array) {
        return mergeSort(array, 0, array.length - 1);
    }

    public static int[] mergeSort(int[] array, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(array, first, mid);
            mergeSort(array, mid + 1, last);
            merge(array, first, mid, last);
        }
        return array;
    }

    public static int[] merge(int[] array, int first, int mid, int last) {
        int length1 = mid - first + 1;
        int length2 = last - mid;
        int firstArray[] = new int[length1];
        int secondArray[] = new int[length2];

        for (int i = 0; i < length1; i++) {
            firstArray[i] = array[i + first];
        }
        for (int j = 0; j < length2; j++) {
            secondArray[j] = array[j + mid + 1];
        }
        int i = 0;
        int j = 0;
        int k = first;
        while (i < length1 && j < length2) {
            if (firstArray[i] <= secondArray[j]) {
                array[k] = firstArray[i];
                i++;
            } else {
                array[k] = secondArray[j];
                j++;
            }
            k++;
        }

        while (i < length1) {
            array[k] = firstArray[i];
            i++;
            k++;
        }
        while (j < length2) {
            array[k] = secondArray[j];
            j++;
            k++;
        }
        return array;
    }


    public static void main(String[] args) {
        int[] ga = {0, 6, 4, 100};
        int a[] = sortArray(ga);
        System.out.println(a[1]);
    }

    ;

}