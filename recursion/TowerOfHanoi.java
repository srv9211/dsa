import java.util.Scanner;
public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of discs: ");
        int n = sc.nextInt();
        System.out.print("Enter source tower: ");
        int source = sc.nextInt();
        System.out.print("Enter destiation tower: ");
        int destination = sc.nextInt();
        System.out.print("Enter aux tower: ");
        int helperTower = sc.nextInt();
        System.out.println();

        towerOfHanoi(n, source, destination, helperTower);
    }

    static void towerOfHanoi(int n, int source, int dest, int auxTower) {
        if (n == 0) return;

        // High level: we are trying to shift all the top discs but not the bottom one
        towerOfHanoi(n-1, source, auxTower, dest);

        // shifted the last disc to the destination and now, source tower is empty
        System.out.println(n + "[" + source + " -> " + dest + "]");

        // here we are moving remaing discs(which were moved to auxTower) to destination with the help of source tower
        towerOfHanoi(n-1, auxTower, dest, source);
    }
}