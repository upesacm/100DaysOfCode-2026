public class Question2
{
    public int[] findUnion(int[] arr1, int[] arr2)
    {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] union = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) 
        {
            if (arr1[i] < arr2[j])
            {
                if (k == 0 || union[k - 1] != arr1[i])
                {
                    union[k++] = arr1[i];
                }
                i++;
            }
            else if (arr1[i] > arr2[j])
            {
                if (k == 0 || union[k - 1] != arr2[j])
                {
                    union[k++] = arr2[j];
                }
                j++;
            }
            else
            {
                if (k == 0 || union[k - 1] != arr1[i])
                {
                    union[k++] = arr1[i];
                }
                i++;
                j++;
            }
        }
        while (i < n1)
        {
            if (k == 0 || union[k - 1] != arr1[i])
            {
                union[k++] = arr1[i];
            }
            i++;
        }
        while (j < n2)
        {
            if (k == 0 || union[k - 1] != arr2[j])
            {
                union[k++] = arr2[j];
            }
            j++;
        }
        int[] result = new int[k];
        System.arraycopy(union, 0, result, 0, k);
        return result;
    }
    
}
