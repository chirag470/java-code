class FindRepeatingNumber
{
    // Returns index of second appearance of a repeating element
    // The function assumes that array elements are in range from
    // 1 to n-1.
    static int findRepeatingElement(int arr[], int low, int high)
    {

        if(low<high) {
          return -1;
        }
        if(low==high) {
        return low;
        }


        int mid = (low+high)/2;

        if(mid==arr[mid]) {

            return findRepeatingElement(arr, low,mid-1);
        } else {
        return findRepeatingElement(arr, mid+1,high);
        }

    }

    // Driver method
    public static void main(String[] args)
    {
        int  arr[] = {0,1,2,2,3};
        int index = findRepeatingElement(arr, 0, arr.length-1);

            System.out.println(index);
    }
}
