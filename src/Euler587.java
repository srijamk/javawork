import java.io.*;
import java.util.*;

class Euler587 {
    public static void main (String [] args) {
        int n = 5;
        int rectangle_area = 4 * n;
        double circles_area = n * 3.1415926;
        double difference = rectangle_area - n * 3.1415926;
        double half_of_the_weird_hourglass_shape_thing = difference / 4;
        double concave_area_la = 1 - half_of_the_weird_hourglass_shape_thing;
        System.out.println(circles_area);
    }
}