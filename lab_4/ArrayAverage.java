public class ArrayAverage {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        int count = 0;
        
        try {
            // Обработка массива
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                count++;
            }
            
            double average = (double) sum / count;
            
            System.out.println("Среднее арифметическое: " + average);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Вывод исключения при выходе за границы массива
            System.out.println("Ошибка: выход за границы массива");
        } catch (NumberFormatException e) {
            // Вывод исключения при неверных данныx
            System.out.println("Ошибка: неверные данные в массиве");
        }
    }
}