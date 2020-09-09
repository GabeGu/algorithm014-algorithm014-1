public class AnagramMain {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        IsAnagram isAnagram = new IsAnagram();

        if (isAnagram.solution1(s, t)) {
        //if (isAnagram.solution2(s, t)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}