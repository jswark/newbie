public class Matrix {
    private Complex[][] matrix;
    private final int rows;
    private final int columns;

    public Matrix(Complex[][] matrix) {
        rows = matrix.length;
        columns = rows > 0 ? matrix[0].length : 0;
        this.matrix = new Complex[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                try {
                    this.matrix[i][j] = matrix[i][j].clone();
                } catch (CloneNotSupportedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public Matrix(double[][] matrix) {
        rows = matrix.length;
        columns = rows > 0 ? matrix[0].length : 0;
        this.matrix = new Complex[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.matrix[i][j] = new Complex(matrix[i][j], 0);
            }
        }
    }

    public Matrix add(Matrix other) {
        assert (rows == other.rows && columns == other.columns) : "Incompatible sizes of matrices"; // проверяем, одинаковая ли размерность у матриц

        Complex[][] result = new Complex[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix[i][j].add(other.matrix[i][j]); // складываем элементы на одинаковых позициях
            }
        }
        return new Matrix(result);
    }

    public Matrix subtract(Matrix other) {
        assert (rows == other.rows && columns == other.columns) : "Incompatible sizes of matrices"; // проверяем, одинаковая ли размерность у матриц

        Complex[][] result = new Complex[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix[i][j].subtract(other.matrix[i][j]);  // вычитаем элементы на одинаковых позициях
            }
        }
        return new Matrix(result);
    }

    public Matrix multiply(Matrix other) {
        assert (columns == other.rows) : "Incompatible sizes of matrices"; // проверяем равенство столбцов и строчек у двух матриц

        Complex[][] result = new Complex[rows][other.columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                result[i][j] = Complex.ZERO;
                for (int k = 0; k < columns; k++) { // умножаем строку на столбец
                    result[i][j] = result[i][j].add(matrix[i][k].multiply(other.matrix[k][j]));
                }
            }
        }
        return new Matrix(result);
    }

    public Matrix transpose() {
        Complex[][] tMatrix = new Complex[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; ++j) {
                try {
                    tMatrix[j][i] = matrix[i][j].clone();
                } catch (CloneNotSupportedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return new Matrix(tMatrix);
    }

    public Complex determinant() { // Bareys method
        assert (rows == columns) : "Determinant is undefined";

        Matrix copyOfMatrix = new Matrix(matrix); // копируем, чтобы не менять исходную матрицу
        for (int i = 0; i < rows - 1; ++i) { // приводим матрицу к треугольному виду, Барейс хорош тем, что в правом нижнем углу будет определитель
            Complex fst = copyOfMatrix.matrix[i][i];
            Complex denominator = i == 0 ? Complex.ONE : copyOfMatrix.matrix[i - 1][i - 1];
            for (int j = i + 1; j < rows; ++j) {
                Complex snd = copyOfMatrix.matrix[j][i];
                for (int k = i; k < rows; ++k) { // (fst * matrix[j] - snd * matrix[i]) / matrix[i - 1][i - 1] (let matrix[-1][-1] = 1)
                    Complex nominator = fst
                            .multiply(copyOfMatrix.matrix[j][k])
                            .subtract(snd.multiply(copyOfMatrix.matrix[i][k]));
                    copyOfMatrix.matrix[j][k] = nominator.divide(denominator);
                }
            }
        }
        return copyOfMatrix.matrix[rows - 1][rows - 1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Complex[] line : matrix) {
            for (Complex number : line) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
