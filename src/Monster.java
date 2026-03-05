import java.util.Random;
import java.util.Scanner;

public class Monster {

    private int x, y;
    private String image =  "\uD83E\uDDDF\u200D";
    Random rand = new Random();
    Monster(int sizeBoard){
        this.y = rand.nextInt(sizeBoard - 1);
        this.x = rand.nextInt(sizeBoard);
    }
    public String getImage() {
        return image;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean conflictPerson(int perX, int perY){
        return perY - 1 == this.y && perX - 1 == this.x;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public boolean taskMonster(int difficultGame){
        System.out.println("Решите задачу:");
        int x = rand.nextInt(100);
        int y = rand.nextInt(100);
        int trueAnswer = x + y;
        System.out.println("Реши пример: " + x + " + " + y + " = ?");
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();
        if (trueAnswer == ans) {
            System.out.println("Верно! Ты победил монстра");
            return true;
        }
        System.out.println("Ты проиграл эту битву!");
        return false;
    }
}
