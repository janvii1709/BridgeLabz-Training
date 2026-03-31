class CheckPalindromeString {
    String Text;
    boolean IsPalindrome() {
        String s = Text.replaceAll(" ", "").toLowerCase();
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    void Display() {
        if(IsPalindrome())
            System.out.println(Text + " is palindrome");
        else
            System.out.println(Text + " is not Palindrome");
    }

    public static void main(String[] args) {
        CheckPalindromeString P1=new CheckPalindromeString();
        P1.Text="A man a plan a canal Panama";
        P1.Display();

        CheckPalindromeString P2=new CheckPalindromeString();
        P2.Text="Hello";
        P2.Display();
    }
}