using System;

public class TestMain
{
    public static void Main(string[] args)
    {
        //注意所有几何体的点按照逆时针输入
        Circle circle = new Circle(0, 0, 1);
        Console.WriteLine("半径为1的圆的面积为：" + circle.Area().ToString());
        Console.WriteLine("半径为1的圆的周长为：" + circle.CircumFerence().ToString());

        Cylinder cylinder = new Cylinder();
        cylinder.R = 1;
        cylinder.h = 1;
        Console.WriteLine("半径为1，高为1的圆柱体的表面积为：" + cylinder.Area().ToString());
        Console.WriteLine("半径为1，高为1的圆柱体的体积为：" + cylinder.GetV().ToString());

        Quadrilateral quadrilateral = new Quadrilateral(1, 2, 2, 3, 3, 4, 1, 4);
        Console.WriteLine("普通四边形的周长：" + quadrilateral.Perimeter().ToString());
        Console.WriteLine("普通四边形的面积：" + quadrilateral.Area().ToString());

        Trapaezoid trapaezoid = new Trapaezoid(0, 0, 2, 0, 2, 1, 1, 1);
        Console.WriteLine("梯形的周长：" + trapaezoid.Perimeter().ToString());
        Console.WriteLine("梯形的面积：" + trapaezoid.Area().ToString());

        Parallelogram parallelogram = new Parallelogram(0, 0, 2, 0, 3, 1, 1, 1);
        Console.WriteLine("平行四边形的周长：" + parallelogram.Perimeter().ToString());
        Console.WriteLine("平行四边形的面积：" + parallelogram.Area().ToString());

        Rectangle rectangle = new Rectangle(0, 0, 2, 0, 2, 1, 0, 1);
        Console.WriteLine("长为2，宽为1的矩形面积为："+rectangle.Area().ToString());
        Console.WriteLine("长为2，宽为1的矩形周长为：" + rectangle.Perimeter().ToString());

        Rhombus rhombus = new Rhombus(0, 0, 2, 1, 3, 3, 1, 2);
        Console.WriteLine("菱形的周长：" + rhombus.Perimeter().ToString());
        Console.WriteLine("菱形的面积：" + rhombus.Area().ToString());

        Quadrate quadrate = new Quadrate(0, 0, 1, 0, 1, 1, 0, 1);
        Console.WriteLine("正方形的周长："+quadrate.Perimeter().ToString());
        Console.WriteLine("正方形的面积：" + quadrate.Area().ToString());

        Triangle triangle = new Triangle(new Point(0, 0), new Point(1, 0), new Point(0, 1));
        Console.WriteLine("三角形的面积为： "+triangle.Area().ToString());
        Console.WriteLine("三角形的周长为： " + triangle.Perimeter().ToString());
    }
}
