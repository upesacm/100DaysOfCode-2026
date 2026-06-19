package DSA.VridhiJain_590014870.Day_4;
class Solution {
    public void rotate(int[] arr, int k) {
        int size = arr.length;
        int[] newArr = new int[size];
        for (int i = 0; i < size; i++) {
            int rot = (i + k) % size;
            newArr[rot] = arr[i];
        }
        for (int i = 0; i < size; i++) {
            arr[i] = newArr[i];
        }
    }
}
