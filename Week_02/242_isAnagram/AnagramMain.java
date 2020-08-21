public class AnagramMain {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        IsAnagram anagram = new IsAnagram();

        if (anagram.isAnagram(s, t)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}