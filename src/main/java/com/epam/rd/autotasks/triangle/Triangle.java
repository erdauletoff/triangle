package com.epam.rd.autotasks.triangle;

class Triangle {

    final Point a;
    final Point b;
    final Point c;
    final double ab;
    final double bc;
    final double ac;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;

        ab = findDistance(a, b);
        bc = findDistance(b, c);
        ac = findDistance(a, c);

        if (!(ab + bc > ac && ac + bc > ab && ab + ac > bc)) {
            throw new IllegalArgumentException();
        }
    }

    public double area() {
        double s = (ab + bc + ac) / 2;
        return Math.sqrt(s * (s - ab) * (s - bc) * (s - ac));
    }

    public Point centroid(){
        return new Point((a.getX() + b.getX() + c.getX()) / 3, (a.getY() + b.getY() + c.getY()) / 3);
    }

    private double findDistance(Point first, Point second) {
        return Math.sqrt(Math.pow(second.getX() - first.getX(), 2) + Math.pow(second.getY() - first.getY(), 2));
    }

}
