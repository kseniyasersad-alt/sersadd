import java.util.Random;
import java.util.Scanner;

public class Ghost extends Monster{
    private String image = "\uD83D\uDC7B";
    Random ran = new Random();

    Ghost(int sizeBoard) {
        super(sizeBoard);
    }


    public String getImage() {
        return image;
    }

    public boolean taskMonster(int difficultGame) {
        System.out.println("Ответь на вопрос: ");
        int a = ran.nextInt(3)+1;
        Scanner scan = new Scanner(System.in);
        if (a == 1) {
            System.out.println("Сколько океанов в мире?");
            int trueAnswer = 4;

            int q = scan.nextInt();
            if (trueAnswer == q) {
                System.out.println("Молодец! Привидение подеждено!");
                return true;
            }
        } else if (a == 2) {
            System.out.println("Сколько материков в мире?");
            int trueAnswer2 = 6;
            int z = scan.nextInt();
            if (trueAnswer2 == z) {
                System.out.println("Молодец! Привидение подеждено!");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву.");
                return false;
            }
        } else if (a == 3) {
            System.out.println("Сколько времён в году?");
            int trueAnswer3 = 4;
            int p = scan.nextInt();
            if (trueAnswer3 == p) {
                System.out.println("Молодец! Привидение подеждено!");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву.");
                return false;
            }
        }
        return false;
    }
}
