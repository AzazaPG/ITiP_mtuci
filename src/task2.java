import java.util.*;

public class task2 {

    public static void main(String[] args) {

        System.out.println("Number 1");
        System.out.println(duplicateChars("donald")); 
        System.out.println(duplicateChars("orange")+ "\n");

        System.out.println("Number 2");
        System.out.println(getInitials("Ryan Gosling"));  // "RG"
        System.out.println(getInitials("Barack Obama")+ "\n");  // "BA"

        System.out.println("Number 3");
        int[] arr1 = {44, 32, 86, 19};
        int[] arr2 = {22, 50, 16, 63, 31, 55};

        System.out.println(differenceEvenOdd(arr1));  // 143
        System.out.println(differenceEvenOdd(arr2)+ "\n");  // 61

        System.out.println("Number 4");
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {1, 2, 3, 4, 6};

        System.out.println(equalToAvg(arr3));  // true
        System.out.println(equalToAvg(arr4)+ "\n");  // false

        System.out.println("Number 5");
        int[] arr5 = {1, 2, 3};
        int[] arr6 = {3, 3, -2, 408, 3, 31};

        int[] result1 = indexMult(arr5);
        System.out.println(Arrays.toString(result1));  // [0, 2, 6]

        int[] result2 = indexMult(arr6);
        System.out.println(Arrays.toString(result2)+ "\n");  // [0, 3, -4, 1224, 12, 155]

        System.out.println("Number 6");
        System.out.println(reverse("Hello World"));  // "dlroW olleH"
        System.out.println(reverse("The quick brown fox.")+ "\n");  // ".xof nworb kciuq ehT"

        System.out.println("Number 7");
        System.out.println(tribonacci(5));  // 7
        System.out.println(tribonacci(9)+ "\n");  // 81

        System.out.println("Number 8");
        System.out.println(pseudoHash(5));  // "04bf2"
        System.out.println(pseudoHash(10));  // "2d9c45e1f3"
        System.out.println(pseudoHash(0)+ "\n");  // ""

        System.out.println("Number 9");
        String input1 = "Hello, I’m under the water, please help me";
        String input2 = "Two pepperoni pizzas please";

        System.out.println(botHelper(input1));  // "Вызов сотрудника"
        System.out.println(botHelper(input2)+ "\n");  // "Продолжайте ожидание"

        System.out.println("Number 10");
        String str1 = "listen";
        String str2 = "silent";

        System.out.println(isAnagram(str1, str2)+ "\n");  // true
    }

    // Number 1
    public static boolean duplicateChars(String str) {
        
        boolean[] charSet = new boolean[256];

        for (int i = 0; i < str.length(); i++) {

            int val = str.charAt(i);

            if (charSet[val]) {
                return true;
            }

            charSet[val] = true;
        } return false;
    }

    // Number 2
    public static String getInitials(String fullName) {
        StringBuilder initials = new StringBuilder();

        String[] words = fullName.split(" ");

        for (String word : words) {
            initials.append(word.charAt(0));
        }

        return initials.toString();
    }

    // Number 3
    public static int differenceEvenOdd(int[] arr) {
        int evenSum = 0;
        int oddSum = 0;

        for (int num : arr) {
            if (num % 2 == 0) {
                evenSum += num;
            } else {
                oddSum += num;
            }
        }
        return Math.abs(evenSum - oddSum);
    }

    // Number 4
    public static boolean equalToAvg(int[] arr) {

        int total = 0;
        for (int num : arr) {
            total += num;
        }
        double avg = (double) total / arr.length;

        for (int num : arr) {
            if (num == avg) {
                return true;
            }
        }

        return false;
    }
    
    // Number 5
    public static int[] indexMult(int[] arr) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] * i;
        }

        return result;
    }

    // Number 6
    public static String reverse(String str) {
        StringBuilder reversed = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }

        return reversed.toString();
    }

    // Number 7
    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }
    
    // Number 8
    public static String pseudoHash(int length) {

        if (length <= 0) {
            return "";
        }

        Random random = new Random();

        StringBuilder pseudoHash = new StringBuilder();

        for (int i = 0; i < length; i++) {

            int index = random.nextInt(16);

            if (index < 10) {
                pseudoHash.append(index);
            } else {
                pseudoHash.append((char) ('a' + (index - 10)));
            }
        }

        return pseudoHash.toString();
    }

    // Number 9
    public static String botHelper(String input) {

        if (input.toLowerCase().contains("help")) {
            return "Вызов сотрудника";
        } else {
            return "Продолжайте ожидание";
        }
    }

    // Number 10
    public static boolean isAnagram(String str1, String str2) {

        char[] arr1 = str1.toLowerCase().toCharArray();
        char[] arr2 = str2.toLowerCase().toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}

