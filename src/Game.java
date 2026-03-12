import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Как тебя зовут??");
        String name = sc.nextLine();
        System.out.println("Привет " + name + "!");
        System.out.println("Готов начать игру? ");
        String answer = sc.nextLine();
        int step = 0;
        int sizeBoard = 5;
        int castleY = 0;
        Person person = new Person(sizeBoard);
        String begin = "|    | |";
        String end = " |    |";
        String castle = "\uD83C\uDFF0";
        Random random = new Random();
        if (answer.equals("Да")) {
            System.out.println("Поехали!");
            System.out.println("Количество жизней: " + person.getLive());
            System.out.println("Выбери сложность игры(от 1 до 5): ");
            int hardd = sc.nextInt();
            if (hardd >= 3) {
                System.out.println("Это будет интересно!");
            } else if (hardd >= 0) {
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
            Monster[] arrMonster = new Monster[countMonster + 1];
            int count = 0;
            Monster test;
            while (count <= countMonster) {
                if (r.nextBoolean()) {
                    test = new Monster(sizeBoard);
                } else {
                    test = new BigMonster(sizeBoard);
                }
                board[r.nextInt(sizeBoard - 1)][r.nextInt(sizeBoard)] = test.getImage();
                arrMonster[count] = test;
                count++;
            }
            board[castleY][castleX] = castle;
            while ((person.getLive() > 0) && !(castleX == person.getX() && castleY == person.getY())) {
                board[person.getY() - 1][person.getX() - 1] = person.getImage();
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
                System.out.println("Координаты персонажа: x" + person.getX() + "y" + person.getY());
                int x = sc.nextInt();
                int y = sc.nextInt();
                if (x != person.getX() && y != person.getY()) {
                    System.out.println("Некорректный ход");
                } else if (Math.abs(x - person.getX()) == 1 || Math.abs(y - person.getY()) == 1) {
                    String next = board[y - 1][x - 1];
                    if (next.equals("  ")) {
                        board[person.getY() - 1][person.getX() - 1] = "  ";
                        person.setY(y);
                        person.setX(x);
                    } else if (next.equals(castle)) {
                        System.out.println("Ты прошёл игру!");
                        break;
                    } else {
                        for (Monster monster : arrMonster) {
                            if (monster.conflictPerson(x, y)) {
                                if (monster.taskMonster(hardd)) {
                                    board[person.getY() - 1][person.getX() - 1] = "  ";
                                    person.move(x, y);

                                } else {
                                    person.downLive();
                                }
                                break;
                            }
                        }
                    }
                } else if (person.getX() == x && person.getY() == y) {
                    System.out.println("Координаты не изменены");
                }
            }
        } else {
            System.out.println("Почему ты не захотел со мной играть:(");
            System.out.println("До скорой встречи!!!");
        }
    }
}