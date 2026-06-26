package DSA.VridhiJain_590014870.Day_6;

class Solution {
    public void union(int[] arr1, int[] arr2) {

        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] < arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++;
            }
            else if (arr1[i] > arr2[j]) {
                System.out.print(arr2[j] + " ");
                j++;
            }
            else {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }

        while (i < arr1.length) {
            System.out.print(arr1[i] + " ");
            i++;
        }

        while (j < arr2.length) {
            System.out.print(arr2[j] + " ");
            j++;
        }
    }
}
