package Problems;
//File: StringUtils.java
public class StringUtils {

 // Public constructor
 public StringUtils() {
 }

 // Reverse a string
 public String reverse(String str) {
     if (str == null) {
         return null;
     }
     return new StringBuilder(str).reverse().toString();
 }
 public boolean isPalindrome(String str) {
     if (str == null) {
         return false;
     }
     return str.equalsIgnoreCase(reverse(str));
 }
 public String toUpperCase(String str) {
     if (str == null) {
         return null;
     }
     return str.toUpperCase();
 }
}





