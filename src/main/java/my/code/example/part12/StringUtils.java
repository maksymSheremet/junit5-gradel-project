package my.code.example.part12;

public class StringUtils {

    public static boolean isPalindrome(String candidate) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(candidate);
        stringBuilder.reverse();
        return stringBuilder.toString().equals(candidate);
    }
}
