public class Complex implements Cloneable {
    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE = new Complex(1, 0);

    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public double getPhi() {
        return Math.atan2(imaginary, real);
    }

    public double getR() {
        return Math.sqrt(squareR());
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public void setPhi(double phi) {
        convertFromTrigonometricFrom(getR(), phi); //convert from trig
    }

    public void setR(double r) {
        convertFromTrigonometricFrom(r, getPhi());
    }

    @Override
    public String toString() {
        return real + " + i * " + imaginary;
    }
    
    public Complex clone() throws CloneNotSupportedException {
        return (Complex) super.clone();
    }

    public Complex add(Complex number) {
        return new Complex(real + number.real, imaginary + number.imaginary);
    }

    public Complex subtract(Complex number) {
        return new Complex(real - number.real, imaginary - number.imaginary);
    }

    public Complex multiply(Complex number) {
        return new Complex(real * number.real - imaginary * number.imaginary,
                real * number.imaginary + imaginary * number.real);
    }

    public Complex divide(Complex number) {
        Complex result = this.multiply(number.conjugate()); // z1 / z2 = z1 * conj(z2) / (|z2| ^ 2)
        double denominator = number.squareR();
        result.real /= denominator;
        result.imaginary /= denominator;
        return result;
    }

    public Complex conjugate() {
        return new Complex(real, -imaginary);
    }

    private void convertFromTrigonometricFrom(double r, double phi) {
        real = r * Math.cos(phi);
        imaginary = r * Math.sin(phi);
    }

    private double squareR() {
        return real * real + imaginary * imaginary;
    }
}
