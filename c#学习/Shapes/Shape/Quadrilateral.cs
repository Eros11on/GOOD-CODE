using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Remoting.Messaging;
using System.Text;

public class Quadrilateral:Shape//四边形类
{
    //逆时针的四个点
    public Point Point1;
    public Point Point2;
    public Point Point3;
    public Point Point4;

    public Quadrilateral(double x1,double y1,double x2,double y2,double x3,double y3,double x4,double y4)
    {
        Point1 = new Point(x1, y1);
        Point2 = new Point(x2, y2);
        Point3 = new Point(x3, y3);
        Point4 = new Point(x4, y4);
    }

    //1/2（x1y2+x2y3+x3y1-(x1y3+x2y1+x3y2))
    //1/2（x1y3+x3y4+x4y1-(x1y4+x3y1+x4y3))
    public override double Area()
    {
        double s1 = 0.5 * (Point1.X * Point2.Y + Point2.X * Point3.Y + Point3.X * Point1.Y - (Point1.X * Point3.Y + Point2.X * Point1.Y + Point3.X * Point2.Y));
        double s2 = -0.5 * (Point1.X * Point4.Y + Point4.X * Point3.Y + Point3.X * Point1.Y - (Point1.X * Point3.Y + Point4.X * Point1.Y + Point3.X * Point4.Y));
        return s1+s2 ; 
    }

    public override double Perimeter()
    {
        double c = Math.Sqrt(Math.Pow(Point1.X - Point2.X, 2) + Math.Pow(Point1.Y - Point2.Y, 2)) +
            Math.Sqrt(Math.Pow(Point2.X - Point3.X, 2) + Math.Pow(Point2.Y - Point3.Y, 2)) +
            Math.Sqrt(Math.Pow(Point3.X - Point4.X, 2) + Math.Pow(Point3.Y - Point4.Y, 2)) +
            Math.Sqrt(Math.Pow(Point1.X - Point4.X, 2) + Math.Pow(Point1.Y - Point4.Y, 2));
        return c;
    }
}