package big_o;

public class BinarySearch {
    public static void run(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int target = 8;
        int start = 0;
        int end = arr.length - 1;

        System.out.println("Founded:" + binarySearch(arr, target, start, end));
    }

    private static boolean binarySearch(int[] arr, int target, int start, int end) {
        int mid = Math.floorDiv(start + end, 2);

        if (arr[mid] == target) return true;

        if (arr[mid] > target) {
            return binarySearch(arr, target, start, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, end);
        }
    }
}
