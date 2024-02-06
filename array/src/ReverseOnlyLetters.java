public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        char[] ch = s.toCharArray();
        int i = 0 ;
        int j = s.length() - 1;

        while(i< j)
        {
            while(i<j && !Character.isLetter(s.charAt(i)))
                i++;
            while(i< j && !Character.isLetter((s.charAt(j))))
                j--;

            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;

            i++;
            j--;
        }
        String string = new String(ch);
        return  string;
    }
}
