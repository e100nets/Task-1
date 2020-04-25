package okay;

public class Triangle {
    private double x1, y1, x2, y2, x3, y3, xp, yp;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3, double xp, double yp) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.xp = xp;
        this.yp = yp;
    }

    public double side_AB() {
        return Math.sqrt((Math.pow(x1 - x2, 2)) + ((Math.pow(y1 - y2, 2))));
    }

    public double side_BC() {
        return Math.sqrt((Math.pow(x2 - x3, 2)) + ((Math.pow(y2 - y3, 2))));
    }

    public double side_CA() {
        return Math.sqrt((Math.pow(x3 - x1, 2)) + ((Math.pow(y3 - y1, 2))));
    }

    public double Perimeter() {
        return side_AB() + side_BC() + side_CA();
    }

    public double Square () {
        double half_meter = Perimeter()/2;
        return Math.sqrt(half_meter*(half_meter - side_AB())*(half_meter-side_BC())*(half_meter-side_CA()));
    }

    public boolean IsPointInsideTheTriangle () {
        double side_AP = Math.sqrt((Math.pow(x1-xp, 2))+((Math.pow(y1-yp, 2))));
        double side_BP = Math.sqrt((Math.pow(x2-xp, 2))+((Math.pow(y2-yp, 2))));
        double side_CP = Math.sqrt((Math.pow(x3-xp, 2))+((Math.pow(y3-yp, 2))));

        double half_meter1 = (side_AB() + side_AP + side_BP)/2;
        double half_meter2 = (side_BC() + side_BP + side_CP)/2;
        double half_meter3 = (side_CA() + side_CP + side_AP)/2;

        double Square1 = Math.sqrt(half_meter1*(half_meter1 - side_AB())*(half_meter1 - side_AP)*(half_meter1 - side_BP));
        double Square2 = Math.sqrt(half_meter2*(half_meter2 - side_BC())*(half_meter2 - side_BP)*(half_meter2 - side_CP));
        double Square3 = Math.sqrt(half_meter3*(half_meter3 - side_CA())*(half_meter3 - side_CP)*(half_meter3 - side_AP));

        return Square() > (Square1 + Square2 + Square3) * 0.999 && Square() < (Square1 + Square2 + Square3) * 1.001; // задаём погрешность 0,1%
    }
}



