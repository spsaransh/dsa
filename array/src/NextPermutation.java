public class NextPermutation {

    public  void nextPermutation(int nums[]) {
        int index = -1;
        int n = nums.length;;
        //find breakpoint at index i
        for (int i= n-2; i>=0 ;i--){
            if(nums[i]<nums[i+1]){
                index = i;
                break;
            }
        }
        // reverse if index = -1;
        if(index == -1) {
            reverse(nums, 0, n - 1);
        }
        else{
            //find the next number that is greater than nums[i] but closeset
            for(int i = n-1; i >=0 ;i--)
            {
                if(nums[i] > nums[index]){
                    //swap
                    swap(nums,i , index);
                    break;
                }
            }
            reverse(nums, index+1, n-1);
        }
    }

    private  void swap(int[] arr ,int i, int j )
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private  void reverse(int[] arr, int start, int end ){
        while(start <end )
        {
            swap( arr,start, end);
            start++;
            end --;
        }
    }
}
