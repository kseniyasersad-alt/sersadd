import java.util.Random;
import java.util.Scanner;

public class Jumper {
   int height;
   public void jump() {
      height += 2;
   }
   public void bigjump() {
      height += 100;
   }
   public static void main(String[] args) {
      Jumper jumper = new Jumper();
      jumper.height = 0;
      jumper.jump();
      System.out.println(jumper.height);
   }
}
