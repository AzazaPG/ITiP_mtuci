import java.util.*;


public class task4 {
    public static void main(String[] args) {

        System.out.println("Number 1");
        System.out.println(nonRepeatable("abracadabra")); 
        System.out.println(nonRepeatable("paparazzi")+ "\n");

        System.out.println("Number 2");
        System.out.println(generateBrackets(1)); 
        System.out.println(generateBrackets(2)); 
        System.out.println(generateBrackets(3)+ "\n"); 

        System.out.println("Number 3");
        System.out.println(binarySystem(3)); 
        System.out.println(binarySystem(4)+ "\n"); 

        System.out.println("Number 4");
        System.out.println(alphabeticRow("abcdjuwx")); 
        System.out.println(alphabeticRow("klmabzyxw")+ "\n"); 

        System.out.println("Number 5");
        System.out.println(countAndSort("aaabbcdd"));
        System.out.println(countAndSort("vvvvaajaaaaa")+ "\n"); 

        System.out.println("Number 6");
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one")+ "\n");

        System.out.println("Number 7");
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898")+ "\n");

        System.out.println("Number 8");
        int[][] grid1 = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        System.out.println(shortestWay(grid1));
        
        int[][] grid2 = {
            {2, 7, 3},
            {1, 4, 8},
            {4, 5, 9}
        };
        System.out.println(shortestWay(grid2)+ "\n");

        System.out.println("Number 9");
        String str1 = "t3o the5m 1One all6 r4ule ri2ng";
        System.out.println(numericOrder(str1));
        
        String str2 = "re6sponsibility Wit1h gr5eat power3 4comes g2reat";
        System.out.println(numericOrder(str2)+ "\n");

        System.out.println("Number 10");
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259)+ "\n");
    }

    // NUMBER 1
    public static String nonRepeatable(String str) {
        if (str.length() <= 1) {
            return str;
        }
        
        if (str.substring(1).contains(String.valueOf(str.charAt(0)))) {
            return nonRepeatable(str.substring(1));
        } else {
            return str.charAt(0) + nonRepeatable(str.substring(1));
        }
    }
    
    // NUMBER 2
    public static List<String> generateBrackets(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private static void backtrack(List<String> result, String current, int open, int close, int n) {
        if (current.length() == n * 2) {
            result.add(current);
            return;
        }
        
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }


    // NUMBER 3
    public static List<String> binarySystem(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", n);
        return result;
    }
    
    private static void backtrack(List<String> result, String current, int n) {
    
        if (current.length() == n) {
            result.add(current);
            return;
        }
        
        if (current.isEmpty() || current.charAt(current.length() - 1) == '1') {
            backtrack(result, current + "0", n);
        }
        if (current.isEmpty() || current.charAt(current.length() - 1) == '0') {
            backtrack(result, current + "1", n);
        }
    }

    // NUMBER 4
    public static String alphabeticRow(String str) {
        if (str.isEmpty()) {
            return "";
        }
        
        String longestRow = "";
        String currentRow = String.valueOf(str.charAt(0));
        
        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            char previousChar = str.charAt(i - 1);
            
            if (currentChar == previousChar + 1 || currentChar == previousChar - 1) {
                currentRow += currentChar;
            } else {
                if (currentRow.length() > longestRow.length()) {
                    longestRow = currentRow;
                }
                currentRow = String.valueOf(currentChar);
            }
        }
        
        if (currentRow.length() > longestRow.length()) {
            longestRow = currentRow;
        }
        
        return longestRow;
    }

    // NUMBER 5
    public static String countAndSort(String str) {
        if (str.isEmpty()) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> charCountMap = new HashMap<>();
        
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            charCountMap.put(currentChar, charCountMap.getOrDefault(currentChar, 0) + 1);
        }
        
        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(charCountMap.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue());
        
        for (Map.Entry<Character, Integer> entry : sortedEntries) {
            result.append(entry.getKey());
            result.append(entry.getValue());
        }
        
        return result.toString();
    }

    // NUMBER 6
    public static int convertToNum(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        
        Map<String, Integer> wordToNumber = createWordToNumberMap();
        String[] words = str.toLowerCase().split(" ");
        int result = 0;
        
        for (String word : words) {
            if (wordToNumber.containsKey(word)) {
                result += wordToNumber.get(word);
            }
        }
        
        return result;
    }
    
    private static Map<String, Integer> createWordToNumberMap() {
        Map<String, Integer> wordToNumber = new HashMap<>();
        wordToNumber.put("one", 1);
        wordToNumber.put("two", 2);
        wordToNumber.put("three", 3);
        wordToNumber.put("four", 4);
        wordToNumber.put("five", 5);
        wordToNumber.put("six", 6);
        wordToNumber.put("seven", 7);
        wordToNumber.put("eight", 8);
        wordToNumber.put("nine", 9);
        wordToNumber.put("ten", 10);
        wordToNumber.put("eleven", 11);
        wordToNumber.put("twelve", 12);
        wordToNumber.put("thirteen", 13);
        wordToNumber.put("fourteen", 14);
        wordToNumber.put("fifteen", 15);
        wordToNumber.put("sixteen", 16);
        wordToNumber.put("seventeen", 17);
        wordToNumber.put("eighteen", 18);
        wordToNumber.put("nineteen", 19);
        wordToNumber.put("twenty", 20);
        wordToNumber.put("thirty", 30);
        wordToNumber.put("forty", 40);
        wordToNumber.put("fifty", 50);
        wordToNumber.put("sixty", 60);
        wordToNumber.put("seventy", 70);
        wordToNumber.put("eighty", 80);
        wordToNumber.put("ninety", 90);
        wordToNumber.put("hundred", 100);
        wordToNumber.put("thousand", 1000);
        return wordToNumber;
    }

    // NUMBER 7
    public static String uniqueSubstring(String s) {
        String maxSubstring = "";
        String substring = "";
        Set<Character> visitedChars = new HashSet<>();
        
        for (char c : s.toCharArray()) {
            if (!visitedChars.contains(c)) {
                visitedChars.add(c);
                substring += c;
            } else {
                if (substring.length() > maxSubstring.length()) {
                    maxSubstring = substring;
                }
                while (visitedChars.contains(c)) {
                    visitedChars.remove(substring.charAt(0));
                    substring = substring.substring(1);
                }
                visitedChars.add(c);
                substring += c;
            }
        }
        
        if (substring.length() > maxSubstring.length()) {
            maxSubstring = substring;
        }
        
        return maxSubstring;
    }

    // NUMBER 8
    public static int shortestWay(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        
        dp[0][0] = grid[0][0];
        
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        return dp[n - 1][n - 1];
    }

    // NUMBER 9
    public static String numericOrder(String str) {
        String[] words = str.split(" ");
        int n = words.length;
        
        String[][] wordArray = new String[n][2];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int num = Integer.parseInt(word.replaceAll("[^0-9]", ""));
            wordArray[i][0] = String.valueOf(num);
            wordArray[i][1] = word.replaceAll("[0-9]", "");
        }
        
        Arrays.sort(wordArray, Comparator.comparingInt(a -> Integer.parseInt(a[0])));
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(wordArray[i][1]);
            if (i < n - 1) {
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }

    // NUMBER 10
    public static int switchNums(int n1, int n2) {
        char[] digits = String.valueOf(n2).toCharArray();
        for (int i = String.valueOf(n1).length() - 1; i >= 0; i--) {
            for (int j = 0; j < digits.length; j++) {
                if (digits[j] < String.valueOf(n1).charAt(i)) {
                    digits[j] = String.valueOf(n1).charAt(i);
                    return Integer.parseInt(String.valueOf(digits));
                }
            }
        }
        return n2;
    }
}
