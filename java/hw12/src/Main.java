public class Main {
    public static void main(String[] args) {
        Complex z1 = new Complex(-1, 2);
        Complex z2 = new Complex(12, -1);
        System.out.println(z1.add(z2));
        System.out.println(z1.subtract(z2));
        System.out.println(z1.multiply(z2));
        System.out.println(z1.divide(z2));
        System.out.println(z1.conjugate());
        System.out.println(z1.getPhi());
        System.out.println(z1.getR());


        Matrix m1 = new Matrix(new double[][]{
                {-1, 2, -3},
                {4, 5, 6},
                {7, 8, 9}
        });

        Matrix m2 = new Matrix(new double[][]{
                {-1, 2, -3},
                {4, -5, 6},
                {-7, 8, 19}
        });

        System.out.println(m2.add(m1));
        System.out.println(m1.subtract(m2));
        System.out.println(m1.multiply(m2));
        System.out.println(m1.determinant());
        System.out.println(m1.transpose());

        Matrix cm1 = new Matrix(new Complex[][]{
                {new Complex(-1, 2), new Complex(2, -1), new Complex(-3, 3)},
                {new Complex(1, 3), new Complex(0, -12), new Complex(3, -3)},
                {new Complex(-10, -2), new Complex(123, 0), new Complex(-10, 1)}
        });

        Matrix cm2 = new Matrix(new Complex[][]{
                {new Complex(1, 3), new Complex(-10, -6), new Complex(13, -1)},
                {new Complex(-3, 20), new Complex(-2, 0), new Complex(-13, 3)},
                {new Complex(0, -2), new Complex(12, 10), new Complex(-10, 10)}
        });

        System.out.println(cm2.add(cm1));
        System.out.println(cm1.subtract(cm2));
        System.out.println(cm1.multiply(cm2));
        System.out.println(cm1.determinant());
        System.out.println(cm1.transpose());
    }
}