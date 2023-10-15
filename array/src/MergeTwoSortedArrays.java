import java.util.Arrays;

public class MergeTwoSortedArrays {


    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b) {
      int n = a.length;
      int m = b.length;
      int len = n+m;
      int gap = len/2 + len%2;
      while (gap >0)
      {
          int left = 0 ;
          int right = gap ;
          while( right < len ){
              if(left <n && right >= n){
                  //arr1 and arr2
                  swapIfGreater(a, b, left,right-n );
              }
              else if(left >= n )
              {
                  //arr2 and arr2
                  swapIfGreater(a, b, left-n,right-n );
              }
              else{
                  //arr1 and arr1
                  swapIfGreater(a, b, left,right );
              }
              left++;
              right++;
              gap = gap /2 +gap%2;
              if(gap < 1)
                  break;

          }
      }
    }




    public static void merge(long a[], long b[], int n, int m)
        {
            // two pointer to iterate
            int i = 0;
            int j = 0;
            while (i < n && j < m) {

                // if arr1[i] <= arr2[j] then both array is
                // already sorted
                if (a[i] <= b[j]) {
                    i++;
                }
                else if (a[i] > b[j]) {

                    swap(a,b, i , j);
                    //Rearrange  2nd Array[
                    long val = b[j];
                    int hole = j+1;
                    while(hole<m && val >b[hole]){
                     b[hole-1] = b[hole];
                     hole++;
                    }
                    b[hole-1] = val;


                    // if arr1[i]>arr2[j] then first we swap
                    // both element so that arr1[i] become
                    // smaller means arr1[] become sorted then
                    // we check that arr2[j] is smaller than all
                    // other element in right side of arr2[j] if
                    // arr2[] is not sorted then we linearly do
                    // sorting means while adjacent element are
                    // less than new arr2[j] we do sorting like
                    // by changing position of element by
                    // shifting one position toward left
                  /*  long t = a[i];
                    a[i] = b[j];
                    b[j] = t;
                    i++;
                    if (j < m - 1 && b[j + 1] < b[j]) {
                        long temp = b[j];
                        int tempj = j + 1;
                        while (tempj < m && b[tempj] < temp
                                && tempj < m) {
                            b[tempj - 1] = b[tempj];
                            tempj++;
                        }
                        b[tempj - 1] = temp;
                    }*/
                }
            }
        }



    private  static void  swapIfGreater(long[] a, long[] b , int i , int j)
    {
        if(a[i]> b[j]) {
            long temp = a[i];
            a[i] = b[j];
            b[j] = temp;
        }
    }

    private  static  void swap(long[] a , long[] b, int i , int j)
    {
        long temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }



}
