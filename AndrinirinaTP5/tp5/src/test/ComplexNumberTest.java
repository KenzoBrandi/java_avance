import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public abstract class ComplexNumberTest {
    protected ComplexNumberFactory factory;

    @BeforeEach
    public abstract void setup();

    @Test
    @DisplayName("Conversion 0 + i0 => 0*ei0")
    public void conversion0() {
        ComplexNumber z = factory.createComplexNumberFromCartesian(0, 0);
        assertEquals(0, z.getModulus(), 10E-5);
        assertEquals(0, z.getArgument(), 10E-5);
    }

    @Test
    @DisplayName("Conversion 1 + i1 => sqrt(2)*ei(PI /4)")
    public void conversion1() {
        ComplexNumber z = factory.createComplexNumberFromCartesian(1, 1);
        assertEquals(Math.sqrt(2), z.getModulus(), 10E-10);
        assertEquals(Math.PI / 4, z.getArgument(), 10E-10);
    }

    @Test
    @DisplayName("Conversion -1 - i1 => sqrt(2)*ei(5*PI /4)")
    public void conversion2() {
        ComplexNumber z = factory.createComplexNumberFromCartesian(-1, -1);
        assertEquals(Math.sqrt(2), z.getModulus(), 10E-10);
        assertEquals(5 * Math.PI / 4, z.getArgument(), 10E-10);
    }

    @Test
    @DisplayName("Conversion 4 + i0 => 4*ei0")
    public void conversion3() {
        ComplexNumber z = factory.createComplexNumberFromCartesian(4, 0);
        assertEquals(4, z.getModulus(), 10E-5);
        assertEquals(0, z.getArgument(), 10E-5);
    }

    @Test
    @DisplayName("Conversion 0 - i2 => 2*ei(3*PI /2)")
    public void conversion4() {
        ComplexNumber z = factory.createComplexNumberFromCartesian(0, -2);
        assertEquals(2, z.getModulus(), 10E-10);
        assertEquals(3 * Math.PI / 2, z.getArgument(), 10E-10);
    }

    @Test
    @DisplayName("Addition 0+i1 + 1+i0 == 1+i1")
    public void addition0() {
        ComplexNumber z1 = factory.createComplexNumberFromCartesian(0, 1);
        ComplexNumber z2 = factory.createComplexNumberFromCartesian(1, 0);
        ComplexNumber result = z1.plus(z2);
        assertEquals(1, result.getReal(), 10E-5);
        assertEquals(1, result.getImaginary(), 10E-5);
    }

    @Test
    @DisplayName("Addition 1+i1 + -1-i1== 0+i0")
    public void addition1() {
        ComplexNumber z1 = factory.createComplexNumberFromCartesian(1, 1);
        ComplexNumber z2 = factory.createComplexNumberFromCartesian(-1, -1);
        ComplexNumber result = z1.plus(z2);
        assertEquals(0, result.getReal(), 10E-5);
        assertEquals(0, result.getImaginary(), 10E-5);
    }

    @Test
    @DisplayName("Soustraction 1-i1 - 0+i1 == 1-i2")
    public void soustraction2() {
        ComplexNumber z1 = factory.createComplexNumberFromCartesian(1, -1);
        ComplexNumber z2 = factory.createComplexNumberFromCartesian(0, 1);
        ComplexNumber result = z1.minus(z2);
        assertEquals(1, result.getReal(), 10E-5);
        assertEquals(-2, result.getImaginary(), 10E-5);
    }

    @Test
    @DisplayName("Multiplication (sqrt(2)*ei(PI/4))*(sqrt(2)*ei(PI/4)) == 2*ei(PI/2)")
    public void multiplication0() {
        ComplexNumber z1 = factory.createComplexNumberFromPolar(Math.sqrt(2), Math.PI / 4);
        ComplexNumber z2 = factory.createComplexNumberFromPolar(Math.sqrt(2), Math.PI / 4);
        ComplexNumber result = z1.multiply(z2);
        assertEquals(2, result.getModulus(), 10E-10);
        assertEquals(Math.PI / 2, result.getArgument(), 10E-10);
    }

    @Test
    @DisplayName("Conjugate sqrt(2)*ei(PI/4) == sqrt(2)*ei(7*PI/4)")
    public void conjugate0() {
        ComplexNumber z = factory.createComplexNumberFromPolar(Math.sqrt(2), Math.PI / 4);
        ComplexNumber result = z.conjugate();
        assertEquals(Math.sqrt(2), result.getModulus(), 10E-10);
        assertEquals(7 * Math.PI / 4, result.getArgument(), 10E-10);
    }
}
