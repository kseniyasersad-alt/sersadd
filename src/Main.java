import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");
        int x = 40;
        int y = 20;
        System.out.println(x+y);
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Привет! " + name);
        Scanner in = new Scanner(System.in);
        short d =  in.nextShort();
        System.out.println(d);
        Random random = new Random();

    }

}
