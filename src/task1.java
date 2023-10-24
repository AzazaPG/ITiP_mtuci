import java.util.Scanner;

public class task1  {

    public static void main(String[] args){

        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));

        fitCalc();
        containers();
        triangleType();
        ternaryEvaluation ();
        howManyItems();
        factorial();
        gcd();
        ticketSaler();
        tables();
    }

    public static double convert(int gallons) {
        return gallons * 3.78541;
    }
    
    public static void fitCalc() {
        Scanner num = new Scanner(System.in);
        int min, calc;
        System.out.println("Напишите время тренировки в минутах:");
        min = num.nextInt();
        if (min <= 20) {
            calc = min * 1;
            System.out.println("Количество сожженных калорий = " + calc);
        }else if (min >= 40) {
            calc = min * 3;
            System.out.println("Количество сожженных калорий = " + calc);
        }else if (min >= 20) {
            calc = min * 2;
            System.out.println("Количество сожженных калорий = " + calc);
        }else {
            System.out.println("Неверное число");
        }
    }

    public static void containers() {
        Scanner num = new Scanner(System.in);
        int small, medium, big, sum;

        System.out.println("Напишите кол-во коробок:");
        small = num.nextInt();
        System.out.println("Напишите кол-во мешков:");
        medium = num.nextInt();
        System.out.println("Напишите кол-во бочек:");
        big = num.nextInt();

        if ((small >= 1) & (medium >= 1) & (big >= 1)) {
            small *= 20;
            medium *= 50;
            big *= 100;
            sum = small + medium + big;
            System.out.println("Ваше кол-во товаров: " + sum);
        }else {
            System.out.println("Неверное(ые) число(а)");
        }  
    } 

    public static void triangleType() {
        Scanner num = new Scanner(System.in);
        int x, y, z;

        System.out.println("Напишите длинну первой стороны:");
        x = num.nextInt();
        System.out.println("Напишите длинну второй стороны:");
        y = num.nextInt();
        System.out.println("Напишите длинну третьей стороны:");
        z = num.nextInt();

        int hypotenuse = (x > y) ? ((x > z)? x:z) : ((y > z)? y:z);
        int cathets = x + y + z - hypotenuse;

        if ((x >= 1) & (y >= 1) & (z >= 1) & (cathets > hypotenuse)){

            if ((x == y) & (x == z)) {
                System.out.println("Треугольник расносторонний");
            }else if ((x == y) ^ (x == z) ^ (y == z)) {
                System.out.println("Треугольник равнобедренный");
            }else if ((x != y) & (x != z) & (y != z)) {
                System.out.println("Треугольник разносторонний");
            }
        }else {
            System.out.println("Не является треугольником");
        }   
    }

    public static void ternaryEvaluation() {
        Scanner num = new Scanner(System.in);
        int a, b;

        System.out.println("Введите число A:");
        a = num.nextInt();
        System.out.println("Введите число B:");
        b = num.nextInt();

        int max = ((a > b)? a:b);
        System.out.println("Наибольшое число: " + max);
    }   
    
    public static void howManyItems() {
        Scanner num = new Scanner(System.in);
        float w, h, S, l;
        int n = 0;

        System.out.println("Введите длину ткани:");
        l = num.nextFloat();
        l /= 2;
        System.out.println("Введите длину пододеяльника:");
        w = num.nextFloat();
        System.out.println("Введите ширину пододеяльника:");
        h = num.nextFloat();

        S = w * h;

        while(((l - S) >= 0)) {
            l = l - S;
            n += 1;
        }
        System.out.println("Кол-во пододеяльников: " + n);
    }

    public static void factorial() {
        Scanner num = new Scanner(System.in);
        int v;
        int result = 1;
        System.out.println("Введите число:");
        v = num.nextInt();

        for (int i = 1; i <= v; i++) {
            result = result * i;
        }

        System.out.println("Факториал числа " + v + " равен: " + result);
    }

    public static void gcd() {
        Scanner num = new Scanner(System.in);
        int num_1, num_2;
        int gc = 1;
        System.out.println("Введите первое число:");
        num_1 = num.nextInt();
        System.out.println("Введите второе число:");
        num_2 = num.nextInt();

        for (int i = 1; i <= num_1 & i <= num_2; i++) {
            if (num_1 % i == 0 & num_2 % i == 0) {
                gc = i;
            }
        }

        System.out.println("Общий делитель двух чисел равен: " + gc);
    }

    public static void ticketSaler(){
        Scanner num = new Scanner(System.in);
        int value, count;

        System.out.println("Введите стоимость билета:");
        value = num.nextInt();
        System.out.println("Введите кол-во проданных билетов:");
        count = num.nextInt();

        float cost =(float) (value * count * 0.72);
        System.out.println("Общая выручка от продажи билетов: " + cost);
    }

    public static void tables() {
        Scanner num = new Scanner(System.in);
        int students, tables;
        int j = 0;

        System.out.println("Введите кол-во студентов:");
        students = num.nextInt();
        System.out.println("Введите кол-во парт:");
        tables = num.nextInt();

        if ((tables * 2)  <= students){
            if (students % 2 ==0) {
            j = students / 2 - tables;
        }else {
            j = students / 2 + 1 - tables;
        }
        }else { j = 0; }
        
        
        System.out.println(j + " - нехватает парт");
    }
}
