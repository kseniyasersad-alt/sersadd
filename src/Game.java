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
        int personX = 1;
        int personY = 1;
        personX = sizeBoard / 2;
        personY = sizeBoard / 2;
        String[] board = new String[sizeBoard * sizeBoard];
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
            String person = "\uD83E\uDDD9\u200D";
            String monster = "\uD83E\uDDDF\u200D";
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
                for (int y = 1; y <= sizeBoard; y++) {
                    for (int x = 1; x <= sizeBoard; x++) {
                        board[(y - 1) * sizeBoard + x - 1] = " ";
                    }
                }
                int count_monster = sizeBoard * sizeBoard - sizeBoard - 1;
                Random random1 = new Random();
                for (int y = 0; y < sizeBoard; y++) {
                    for (int x = 0; x < sizeBoard; x++) {
                        board[y][x] = "  ";
                    }
                }
                int countMonster = sizeBoard * sizeBoard - sizeBoard - 1;
                Random r = new Random();
                for (int i = 0; i <= countMonster; i++) {
                    board[r.nextInt(sizeBoard - 1)][r.nextInt(sizeBoard)] = monster;
                }
                System.out.println("Веди свой ход(ход может быть только по вертикали и горизантали на 1 клетку)");
                System.out.println("Координаты персонажа: x" + personX + "y" + personY);
                String full = begin + monster + end;
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if (x != personX && y != personY) {
                    System.out.println("Неккоректный ход");
                } else if (Math.abs(x - personX) == 1 || Math.abs(y - personY) == 1) {
                    if (board[y - 1][x - 1].equals("  ")) {
                        board[personY - 1][personX - 1] = "  ";
                        personX = x;
                        personY = y;
                        step++;
                        System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY +
                                "\nХод номер: " + step);
                    }else if (board[y - 1][x - 1].equals(castle)) {
                        System.out.println("Вы прошли игру!");
                        break;
                    } else {
                        System.out.println("Решите задачу.");
                    }
                } else {
                    System.out.println("Координаты не изменены");
                }

                if (personLive <= 0) {
                    break;
                }
            }

            System.out.println("Закончились жизни. Итог: ...");
        }

    }

}


