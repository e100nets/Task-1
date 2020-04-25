package okay;
import java.util.Scanner;

public class Main {
    public static double InputCoordinates(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите %s: ", name);
        return scanner.nextDouble();
    }

    public static void main(String[] args) {
        System.out.printf("Треугольник ABC, точка P%nКоординаты точек:%nA(x1, y1)%nB(x2, y2)%nC(x3, y3)%nP(xp, yp)%n");
        double x1 = InputCoordinates("x1");
        double y1 = InputCoordinates("y1");
        double x2 = InputCoordinates("x2");
        double y2 = InputCoordinates("y2");
        double x3 = InputCoordinates("x3");
        double y3 = InputCoordinates("y3");
        double xp = InputCoordinates("xp");
        double yp = InputCoordinates("yp");

        Triangle triangle = new Triangle(x1, y1, x2, y2, x3, y3, xp, yp);


        System.out.println("Периметр треугольника: " + triangle.Perimeter());

        System.out.println("Площадь тругольника: " + triangle.Square());

        if (triangle.IsPointInsideTheTriangle()) {
            System.out.println("Точка (" + xp + "; " + yp + ") принадлежит треугольнику");
        } else System.out.println("Точка (" + xp + "; " + yp + ") не принадлежит треугольнику");

    }
}
