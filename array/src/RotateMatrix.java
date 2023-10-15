public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //transpose
        for(int i = 0 ; i< n-1 ;i++)
        {
            for(int j = i+1  ; j<n ; j++)
            {
                swap(matrix,i, j);
            }
        }

        for(int i = 0 ; i< n ; i++)
        {
            reverse(matrix[i]);
        }

    }

    private    void swap(int[][] a , int i , int j)
    {
        int temp = a[i][j];
        a[i][j] = a[j][i];
        a[j][i] = temp;
    }

    private void reverse(int[]a){
        int i = 0 ; int j = a.length -1;
        while(i< j)
        {
            int temp = a[i];
            a[i] = a[j];
            a[j]= temp;
            i++;
            j--;
        }
    }
}
