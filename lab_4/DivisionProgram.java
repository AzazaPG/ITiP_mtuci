import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DivisionProgram {
    private static final Logger logger = Logger.getLogger(DivisionProgram.class.getName());

    public static void main(String[] args) {
        try {
            FileHandler fileHandler = new FileHandler("lab_4/exceptions.log");
            logger.addHandler(fileHandler);

            int dividend = 10;
            int divisor = 0;

            double result = divide(dividend, divisor);
            System.out.println("Результат деления: " + result);
        } catch (CustomDivisionException e) {
            logger.log(Level.SEVERE, "Division error: " + e.getMessage(), e);
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла лога" + e.getMessage());
        }
    }

    public static double divide(int dividend, int divisor) throws CustomDivisionException {
        if (divisor == 0) {
            throw new CustomDivisionException("Division by zero is prohibited");
        }
        return (double) dividend / divisor;
    }
}