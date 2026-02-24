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
      System.out.println(jumper.height;



      if (x != personX && y != personY) {
         System.out.println("Некорректный ход");
      } else if (Math.abs(x - personX) == 1 || Math.abs(y - personY) == 1) {

         (board[y - 1][x - 1].equals("  "))
         board[personY - 1][personX - 1] = "  ";
         personX = x;
         personY = y;
         step++;
         System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY +
                 "\nХод номер: " + step);
      } else if (board[y - 1][x - 1].equals(castle)) {
         System.out.println("Вы прошли игру!");
         break;
      } else {
         System.out.println("Координаты не изменены");}
                else {
         System.out.println("Почему ты не захотел со мной играть:(");
         System.out.println("До скорой встречи!!!");
      }
   }
}
