import java.io.BufferedWriter;
import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Как тебя зовут??");
        String name = sc.nextLine();
        System.out.println("Привет " + name + "!");
        System.out.println("Готов начать игру? ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        int step = 0;
        int personLine = 3;
        int sizeBoard = 5;
        int personX = 3;
        int personY = 1;
        personX = sizeBoard / 2;
        personY = sizeBoard / 2;
        if (answer.equals("Да")) {
            System.out.println("Поехали!");
        } else {
            System.out.println("Почему ты не захотел со мной играть:(");
            System.out.println("Доскорой встречи!!!");
        }

        System.out.println("Количество жизней: " + personLine);
        System.out.println("Выбери сложность игры(от 1 до 5): ");
        Scanner hard = new Scanner(System.in);
        personLine = hard.nextInt();
        if (personLine >= 3) {
            System.out.println("Это будет интересно!");
        } else {
            System.out.println("Ну что поехали дальше!");
        }
        step += 1;
        step -= 10;
        step *= 5;
        step /= 2;
        String person = "Г";
        String monster = "Мм";
        String gamingField = "+ —— + —— + —— +"
                + "|    |    |    |"
                + "+ —— + —— + —— +"
                + "|    | " + monster + " |    |"
                + "+ —— + —— + —— +"
                + "| " + person + " |    |    |"
                + "+ —— + —— + —— +";
        String begin = "|    | |";
        String end = " |    |";
        System.out.println("Веди свой ход(ход может быть только по вертикали и горизантали на 1 клетку)");
        System.out.println("Координаты персонажа: x" + personX+ "y" + personY);
        String full = begin + monster + end;
        int x = scanner. nextInt();
        int y = scanner. nextInt();
        if (x != personX && y != personY) {
            System.out.println("Некорректный ход");
        } else if (Math.abs(x - personX) == 1) {
            personX = x;
            step += 1;
        } else if (Math.abs(y - personY) == 1) {
            personY = y;
            step += 1;
        } else {
            System.out.println("Координаты не изменены");
        }
    }
}