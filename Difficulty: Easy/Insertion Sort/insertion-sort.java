class Solution {
    // Please change the array in-place
    public void insertionSort(int arr[]) {
        
        
        //size of array.
        int n = arr.length;
        
        for(int i=1; i<n; i++)
        {
            insertAtCorrectPosition(i, arr);
        }
    }
    
    public void insertAtCorrectPosition(int i, int arr[])
    {
        int j = i - 1;
        int candidate = arr[i];
        
        while(j >= 0)
        {
            if(arr[j] > candidate)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            else
            {

                break;
            }
        }
        
        arr[j+1] = candidate;
    }
}