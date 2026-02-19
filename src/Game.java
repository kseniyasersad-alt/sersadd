import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Как тебя зовут??");
        String name = sc.nextLine();
        System.out.println("Привет " + name + "!");
        System.out.println("Готов/а начать игру? ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        int step = 0;
        int personLife = 3;
        int sizeBoard = 5;
        String[] board = new String[sizeBoard * sizeBoard];
        int personX = 1;
        int personY = 1;
        personX = sizeBoard / 2;
        personY = sizeBoard / 2;
        if (answer.equals("Да")) {
            System.out.println("Поехали!");
            System.out.println("Количество жизней: " + personLife);
            System.out.println("Выбери сложность игры(от 1 до 5): ");
            Scanner hard = new Scanner(System.in);
            int personLine = hard.nextInt();
            if (personLine >= 3) {
                System.out.println("Это будет интересно!");
            } else if (personLine >= 0) {
                System.out.println("Ну ладно, поехали дальше!");
            }
            String person = "Г";
            String monster = "Мм";
            String begin = "|    | |";
            String end = " |    |";
            String castle = "\uD83C\uDFF0";
            int castleY = 1;
            Random random = new Random();
            int castleX = random.nextInt(sizeBoard);
            String leftBlock = " | ";
            String rightBlock = " |";
            String wall = " + —— + —— + —— + —— + —— + ";
            while ((personLife > 0) && !(castleX == personX && castleY == personY)) {
                for (int y = 1; y <= sizeBoard; y++) {
                    System.out.println(wall);
                    for (int x = 1; x <= sizeBoard; x++) {
                        System.out.print(leftBlock);
                        if (personY == y && personX == x) {
                            System.out.print(person);
                        } else if (castleX == x && castleY == y) {
                            System.out.print(castle);
                        } else {
                            System.out.print("  ");
                        }
                    }
                    System.out.println(rightBlock);
                }
                System.out.println(wall);
                int count_monster = sizeBoard * sizeBoard - sizeBoard - 1;
                Random random1 = new Random();
                for (int z = 0; z <= count_monster; z++) {
                    for (int y = 1; y <= sizeBoard; y++) {
                        for (int x = 1; x <= sizeBoard; x++) {
                            board[y - 1][x - 1] = "  ";
                        }
                    }
                }
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
                System.out.println("Ты справился/лась!!!");
            }
        } else {
            System.out.println("Почему ты не захотел со мной играть:(");
            System.out.println("До скорой встречи!!!");
        }
    }
}