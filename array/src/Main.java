import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*System.out.println("Hello world!");
        int[] a = {4, 5, 6,0,0,0};
        int[] b= {1,2,3};
        int ans =LongestRepeatingCharacterReplacement.characterReplacement("aabccb", 2);
        System.out.println(ans);*/
        int arr[] = {5,1, 2 ,3,0,0};
        NextPermutation nxtPmt = new NextPermutation();
        nxtPmt.nextPermutation(arr);
        for(int i = 0 ; i< arr.length; i++)
        {
            System.out.println(arr[i]);
        }
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Please enter string to reverse only letters");
        String name = sc.nextLine();
       ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters();
       System.out.println(reverseOnlyLetters.reverseOnlyLetters(name));*/

    }
}
