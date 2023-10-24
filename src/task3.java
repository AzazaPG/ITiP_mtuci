// import java.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class task3 {
    public static void main(String[] args) {

        System.out.println("Number 1");
        System.out.println(replaceVowels("apple")); // Output: *ppl*
        System.out.println(replaceVowels("Even if you did this task not by yourself, you have to understand every single line of code.")+ "\n");

        System.out.println("Number 2");
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper")+ "\n");

        System.out.println("Number 3");
        System.out.println(doesBlockFit(1, 3, 5, 4, 5)); // true
        System.out.println(doesBlockFit(1, 8, 1, 1, 1)); // true
        System.out.println(doesBlockFit(1, 2, 2, 1, 1)+ "\n"); // false

        System.out.println("Number 4");
        System.out.println(numCheck(243)); // true
        System.out.println(numCheck(52)+ "\n"); // false

        System.out.println("Number 5");
        System.out.println(countRoots(new int[]{1, -3, 2})); // 2
        System.out.println(countRoots(new int[]{2, 5, 2})); // 1
        System.out.println(countRoots(new int[]{1, -6, 9})+ "\n"); // 1

        String[][] sales1 = {
            {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
            {"Banana", "Shop2", "Shop3", "Shop4"},
            {"Orange", "Shop1", "Shop3", "Shop4"},
            {"Pear", "Shop2", "Shop4"}
        };
        List<String> result3 = getCommonProducts(sales1);
        System.out.println(result3); // Output: [Shop4]
        
        String[][] sales2 = {
            {"Fridge", "Shop2", "Shop3"},
            {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
            {"Laptop", "Shop3", "Shop4"},
            {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}
        };
        List<String> result4 = getCommonProducts(sales2);
        System.out.println(result4); // Output: [Shop3, Shop4]
    

        System.out.println("Number 7");
        System.out.println(validSplit("apple eagle egg goat")); // Output: true
        System.out.println(validSplit("cat dog goose fish")+ "\n"); // Output: false


        System.out.println("Number 8");
        int[] arr1 = {3, 1, 4, 2, 7, 5};
        System.out.println(waveForm(arr1)); // Output: true
        
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(waveForm(arr2)); // Output: false
        
        int[] arr3 = {1, 2, -6, 10, 3};
        System.out.println(waveForm(arr3)+ "\n"); // Output: true

        System.out.println("Number 9");
        System.out.println(commonVovel("Hello world")); // Output: o
        System.out.println(commonVovel("Actions speak louder than words.")+ "\n"); // Output: a

        System.out.println("Number 10");
        int[][] data1 = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {5, 5, 5, 5, 5},
            {7, 4, 3, 14, 2},
            {1, 0, 11, 10, 1}
        };
        int[][] result1 = dataScience(data1);
        printMatrix(result1);
        // Output:
        // 5  2  3  4  5
        // 6  3  8 29 10
        // 5  5  6  5 35
        // 7  4  3 12  2
        // 1  0 11 10 13
        
        int[][] data2 = {
            {6, 4, 19, 0, 0},
            {81, 25, 3, 1, 17},
            {48, 12, 60, 32, 14},
            {91, 47, 16, 65, 217},
            {5, 73, 0, 4, 21}
        };
        int[][] result2 = dataScience(data2);
        printMatrix(result2);
        // Output:
        // 56  4 19  0   0
        // 81 34  3  1  17
        // 48 12 10 32  14
        // 91 47 16  9 217
        //  5 73  0  4  62
    }

    // NUMBER 1
    public static String replaceVowels(String str) {
        // Создаем новую строку, чтобы сохранить оригинальную строку без изменений
        String result = "";

        // Проходимся по каждому символу в строке
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // Проверяем, является ли символ гласной буквой
            if (isVowel(c)) {
                // Если символ является гласной буквой, заменяем его на ""
                result += "*";
            } else {
                // Иначе, оставляем символ без изменений
                result += c;
            }
        }

        return result;
    }
 
    // Функция для проверки, является ли символ гласной буквой
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c); // Приводим символ к нижнему регистру для удобства сравнения

        // Проверяем, является ли символ одной из гласных букв
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    // NUMBER 2
    public static String stringTransform(String str) {
        // Создаем новую строку, чтобы сохранить оригинальную строку без изменений
        String result = "";

        // Проходимся по каждому символу в строке, кроме последнего
        for (int i = 0; i < str.length() - 1; i++) {
            char currentChar = str.charAt(i);
            char nextChar = str.charAt(i + 1);

            // Проверяем, являются ли два символа идущими подряд и одинаковыми
            if (currentChar == nextChar) {
                // Если символы идущие подряд и одинаковы, добавляем "Double" перед текущим символом
                result += "Double";
            } else {
                // Иначе, оставляем текущий символ без изменений
                result += currentChar;
            }
        }

        // Добавляем последний символ в строку без изменений
        result += str.charAt(str.length() - 1);

        return result;
    }

    // NUMBER 3
    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        if ((a <= h && b <= w) || (a <= h && c <= w) || (b <= h && a <= w) || (b <= h && c <= w) || (c <= h && a <= w) || (c <= h && b <= w)) {
            return true;
        } else {
            return false;
        }
    }

    // NUMBER 4
    public static boolean numCheck(int num) {
        String numStr = String.valueOf(num); // преобразуем число в строку
        int sum = 0; // переменная для суммы квадратов цифр
        
        for (int i = 0; i < numStr.length(); i++) {
            int digit = Character.getNumericValue(numStr.charAt(i)); // получаем цифру из строки
            sum += digit * digit; // возводим цифру в квадрат и добавляем к сумме
        }
        
        if (num % 2 == sum % 2) { // проверяем, имеют ли число и сумма одну и ту же четность
            return true;
        } else {
            return false;
        }
    }

    // NUMBER 5
    public static int countRoots(int[] coefficients) {
        int a = coefficients[0];
        int b = coefficients[1];
        int c = coefficients[2];
        
        int discriminant = b * b - 4 * a * c; // вычисляем дискриминант
        
        if (discriminant > 0) {
            return 2; // два корня
        } else if (discriminant == 0) {
            return 1; // один корень
        } else {
            return 0; // нет целочисленных корней
        }
    }

    public static List<String> getCommonProducts(String[][] sales) {
        Map<String, Integer> productCount = new HashMap<>();
        
        for (int i = 0; i < sales.length; i++) {
            for (int j = 1; j < sales[i].length; j++) {
                String shop = sales[i][j];
                
                if (productCount.containsKey(shop)) {
                    productCount.put(shop, productCount.get(shop) + 1);
                } else {
                    productCount.put(shop, 1);
                }
            }
        }
        
        List<String> commonProducts = new ArrayList<>();
        
        for (String shop : productCount.keySet()) {
            if (productCount.get(shop) == sales.length) {
                commonProducts.add(shop);
            }
        }
        
        return commonProducts;
    }
    

    // NUMBER 7
    public static boolean validSplit(String sentence) {
        String[] words = sentence.split(" ");
        
        if (words.length == 0) {
            return false;
        }
        
        for (int i = 1; i < words.length; i++) {
            String previousWord = words[i - 1];
            String currentWord = words[i];
            
            if (previousWord.charAt(previousWord.length() - 1) != currentWord.charAt(0)) {
                return false;
            }
        }
        
        return true;
    }

    // NUMBER 8
    public static boolean waveForm(int[] arr) {
        if (arr.length <= 2) {
            return false;
        }
        
        boolean increasing = arr[1] > arr[0];
        
        for (int i = 2; i < arr.length; i++) {
            if (increasing && arr[i] >= arr[i - 1]) {
                return false;
            } else if (!increasing && arr[i] <= arr[i - 1]) {
                return false;
            }
            
            increasing = !increasing;
        }
        
        return true;
    }

    // NUMBER 9
    public static char commonVovel(String sentence) {
        int[] vowelCount = new int[5];
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        
        for (int i = 0; i < sentence.length(); i++) {
            char c = Character.toLowerCase(sentence.charAt(i));
            
            if (c == 'a') {
                vowelCount[0]++;
            } else if (c == 'e') {
                vowelCount[1]++;
            } else if (c == 'i') {
                vowelCount[2]++;
            } else if (c == 'o') {
                vowelCount[3]++;
            } else if (c == 'u') {
                vowelCount[4]++;
            }
        }
        
        int maxCount = 0;
        int maxIndex = 0;
        
        for (int i = 0; i < vowelCount.length; i++) {
            if (vowelCount[i] > maxCount) {
                maxCount = vowelCount[i];
                maxIndex = i;
            }
        }
        
        return vowels[maxIndex];
    }

    // NUMBER 10
    public static int[][] dataScience(int[][] data) {
        int n = data.length;
        int[] columnSums = new int[n];
        
        // Вычисляем сумму каждого столбца
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                columnSums[j] += data[i][j];
            }
        }
        
        // Вычисляем среднее арифметическое для каждого столбца
        for (int i = 0; i < n; i++) {
            int columnAverage = columnSums[i] / (n - 1); // n-1, так как n-ый элемент будет изменен
            for (int j = 0; j < n; j++) {
                if (j != i) { // Пропускаем n-ый столбец
                    data[j][i] = columnAverage;
                }
            }
        }
        
        return data;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
         System.out.println();
    }
}
