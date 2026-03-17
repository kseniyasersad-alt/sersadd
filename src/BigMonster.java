import java.util.Random;
import java.util.Scanner;


public class BigMonster extends Monster {
    private String image = "\uD83E\uDDDF\u200D";

    BigMonster(int sizeBoard) {
        super(sizeBoard);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean taskMonster(int difficultGame) {
        System.out.println("Решите задачу:");
        if (difficultGame == 1) {
            return super.taskMonster(difficultGame);
        } else {
            int x = rand.nextInt(15);
            int y = rand.nextInt(10);
            int z = rand.nextInt(20);
            int trueAnswer = x * y - z;
            System.out.println("Реши пример: " + x + " * " + y + " - " + z + " = ?");
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
}
