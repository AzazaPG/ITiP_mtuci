import java.util.Arrays;

public class task2 {
    // public static boolean validSplit(String sentence) {
    //     String[] words = sentence.split(" ");  // Разделение предложения на слова
    //     if (words.length < 2) {  // Если в предложении меньше двух слов, то разбиение невозможно
    //         return false;
    //     }
        
    //     for (int i = 1; i < words.length; i++) {
    //         String currentWord = words[i];
    //         String previousWord = words[i-1];
    //         if (Character.toLowerCase(currentWord.charAt(0)) != Character.toLowerCase(previousWord.charAt(previousWord.length()-1))) {
    //             return false;
    //         }
    //     }
        
    //     return true;  // Если все слова соответствуют требованиям, разбиение возможно
    // }
    
    // public static void main(String[] args) {
    //     System.out.println(validSplit("apple eagle egg goat"));  // true
    //     System.out.println(validSplit("cat dog goose fish"));  // false
    // }
    public static int[][] modifyArray(int[][] arrays) {
        int n = arrays.length;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    sum += arrays[j][i];  // Суммируем элементы столбца
                }
            }
            int average = sum / (n-1);  // Вычисляем среднее арифметическое
            arrays[i][n-1] = average;  // Заменяем n-ый элемент n-го массива
            
            // Сбрасываем значение суммы перед переходом к следующему столбцу
            sum = 0;
        }
        
        return arrays;
    }
    
    public static void main(String[] args) {
        int[][] arrays1 = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {5, 5, 5, 5, 5},
            {7, 4, 3, 14, 2},
            {1, 0, 11, 10, 1}
        };
        int[][] result1 = modifyArray(arrays1);
        System.out.println(Arrays.deepToString(result1));
        
        int[][] arrays2 = {
            {6, 4, 19, 0, 0},
            {81, 25, 3, 1, 17},
            {48, 12, 60, 32, 14},
            {91, 47, 16, 65, 217},
            {5, 73, 0, 4, 21}
        };
        int[][] result2 = modifyArray(arrays2);
        System.out.println(Arrays.deepToString(result2));
    }
}

