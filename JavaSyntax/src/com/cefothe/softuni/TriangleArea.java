package com.cefothe.softuni;

import java.util.Scanner;

/**
 * 
 * @author cefothe
 *
 */
class Point {
    public double x;
    public double y;
}

public class TriangleArea {

    public static double calculateTriangleArea(Point[] points) {
	double area = Math.abs((points[0].x * (points[1].y - points[2].y) + points[1].x * (points[2].y - points[0].y)
		+ points[2].x * (points[0].y - points[1].y)) / 2);
	return area;
    }

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	Point[] points = new Point[3];
	for (int i = 0; i < 3; i++) {
	    Point point = new Point();
	    point.x = scanner.nextDouble();
	    point.y = scanner.nextDouble();
	    points[i] = point;
	}
	System.out.println(calculateTriangleArea(points));
    }

}
