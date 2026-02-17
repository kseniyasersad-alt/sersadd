import java.util.Scanner;

public class ifElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ответ");
        String answer = scanner.nextLine();
        boolean condition = answer.equals("Да") ;
        if (condition) {
            System.out.println("Вы меня увидете если condition = true");
        }else {
            if (answer.equals("Нет")) {
                System.out.println("Я открываюсь когда к condition = false");
            } else {
                System.out.println("Вы что-то не то ввели");
            }
        }
        System.out.println("Меня вы видете всегда");
    }
}
