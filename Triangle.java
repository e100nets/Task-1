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

    public double sideAB() {
        return Math.sqrt((Math.pow(x1 - x2, 2)) + ((Math.pow(y1 - y2, 2))));
    }

    public double sideBC() {
        return Math.sqrt((Math.pow(x2 - x3, 2)) + ((Math.pow(y2 - y3, 2))));
    }

    public double sideCA() {
        return Math.sqrt((Math.pow(x3 - x1, 2)) + ((Math.pow(y3 - y1, 2))));
    }

    public double Perimeter() {
        return sideAB() + sideBC() + sideCA();
    }

    public double Square () {
        double halfMeter = Perimeter()/2;
        return Math.sqrt(halfMeter*(halfMeter - sideAB())*(halfMeter-sideBC())*(halfMeter-sideCA()));
    }

    public boolean IsPointInsideTheTriangle () {
        double sideAP = Math.sqrt((Math.pow(x1-xp, 2))+((Math.pow(y1-yp, 2))));
        double sideBP = Math.sqrt((Math.pow(x2-xp, 2))+((Math.pow(y2-yp, 2))));
        double sideCP = Math.sqrt((Math.pow(x3-xp, 2))+((Math.pow(y3-yp, 2))));

        double halfMeter1 = (sideAB() + sideAP + sideBP)/2;
        double halfMeter2 = (sideBC() + sideBP + sideCP)/2;
        double halfMeter3 = (sideCA() + sideCP + sideAP)/2;

        double Square1 = Math.sqrt(halfMeter1*(halfMeter1 - sideAB())*(halfMeter1 - sideAP)*(halfMeter1 - sideBP));
        double Square2 = Math.sqrt(halfMeter2*(halfMeter2 - sideBC())*(halfMeter2 - sideBP)*(halfMeter2 - sideCP));
        double Square3 = Math.sqrt(halfMeter3*(halfMeter3 - sideCA())*(halfMeter3 - sideCP)*(halfMeter3 - sideAP));

        return Square() > (Square1 + Square2 + Square3) * 0.999 && Square() < (Square1 + Square2 + Square3) * 1.001; // задаём погрешность 0,1%
    }
}



