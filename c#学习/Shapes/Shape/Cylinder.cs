using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

public class Cylinder:Circle//圆柱体
 {
    public double h;

    public override double Area()
    {
        double s = 2 * Math.PI * R * R + h * 2 * Math.PI * R;
        return s;
    }

    public double GetV()
    {
        double v = h * Math.PI * R * R;
        return v;
    }
 }