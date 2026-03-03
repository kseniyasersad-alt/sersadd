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
        int personX = sizeBoard / 2;
        int personY = sizeBoard / 2;
        int castleY = 0;
        String person = "\uD83E\uDDD9\u200D";
        String monster = "\uD83E\uDDDF\u200D";
        String begin = "|    | |";
        String end = " |    |";
        String castle = "\uD83C\uDFF0";

        Random random = new Random();
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
            String[][] board = new String[sizeBoard][sizeBoard];
            int castleX = random.nextInt(sizeBoard);
            String leftBlock = " | ";
            String rightBlock = " |";
            String wall = " + —— + —— + —— + —— + —— + ";
            Random r = new Random();
            for (int y = 0; y < sizeBoard; y++) {
                for (int x = 0; x < sizeBoard; x++) {
                    board[y][x] = "  ";
                }
            }
            int countMonster = sizeBoard * sizeBoard - sizeBoard - 1;
            for (int i = 0; i <= countMonster; i++) {
                board[r.nextInt(sizeBoard - 1)][r.nextInt(sizeBoard)] = monster;
            }
            board[castleY][castleX] = castle;
            while ((personLife > 0) && !(castleX == personX && castleY == personY)) {
                board[personY][personX] = person;
                for (int y = 0; y < sizeBoard; y++) {
                    System.out.println(wall);
                    for (int x = 0; x < sizeBoard; x++) {
                        System.out.print(leftBlock);
                        System.out.print(board[y][x]);
                    }
                    System.out.println(rightBlock);
                }
                System.out.println(wall);
                System.out.println("Веди свой ход(ход может быть только по вертикали и горизантали на 1 клетку)");
                System.out.println("Координаты персонажа: x" + personX + "y" + personY);
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                board[castleY][castleX] = castle;
                if (x != personX && y != personY) {
                    System.out.println("Некорректный ход");
                } else if (Math.abs(x - personX) == 1 || Math.abs(y - personY) == 1) {
                    } else if (board[y - 1][x - 1].equals(castle)) {
                        System.out.println("Вы прошли игру!");
                        break;
                    } else {
                        System.out.println("Решите задачу:");
                        if (taskMonster(personLine)) {
                            board[personY - 1][personX - 1] = "  ";
                            personX = x;
                            personY = y;
                        } else {
                            personLife--;
                        }
                        if (personLife == 0) {
                            System.out.println("Закончились жизни. Итог: ...");
                        }
                        if (personX == x && personY == y) {
                            System.out.println("Координаты не изменены");
                        } else {
                            System.out.println("Почему ты не захотел со мной играть:(");
                            System.out.println("До скорой встречи!!!");
                        }
                    }
                }
            }
        }
    }
    static boolean taskMonster(int difficultGame) {
        if (difficultGame == 1) {
            Random ii = new Random();
            int z = ii.nextInt(100);
            int p = ii.nextInt(100);
            int trueAnswer = z + p;
            System.out.println("Реши пример: " + z + " + " + p + " = ?");
            Scanner zi = new Scanner(System.in);
            int ans = zi.nextInt();
            if (trueAnswer == ans) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }
        }
        return true;

    }

public void main() {
}