import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public abstract class ComplexNumberTest {
    protected ComplexNumberFactory factory;
    @BeforeAll
    public abstract void setup();

    @Test
    public void conversion0(){
        ComplexNumber z = factory.createComplexNumberFromCartesian(0,0);

        assertEquals(z.getModulus(), 0,10E-5);
        assertEquals(z.getArgument(), 0,10E-5);
    }

    @Test
    public void conversion1(){
        ComplexNumber z = factory.createComplexNumberFromCartesian(1,1);

        assertEquals(z.getModulus(), Math.sqrt(2),10E-10);
        assertEquals(z.getArgument(),Math.PI / 4,10E-10);
    }

    @Test
    public void conversion2(){
        ComplexNumber z = factory.createComplexNumberFromCartesian(-1,-1);
        
        assertEquals(z.getModulus(), Math.sqrt(2),10E-10);
        assertEquals(z.getArgument(),5* Math.PI / 4,10E-10);
    }

    @Test
    public void conversion3(){
        ComplexNumber z = factory.createComplexNumberFromCartesian(4,0);
        
        assertEquals(z.getModulus(), 4,10E-5);
        assertEquals(z.getArgument(),0,10E-5);
    }

    @Test
    public void conversion4(){
        ComplexNumber z = factory.createComplexNumberFromCartesian(0,-2);
        
        assertEquals(z.getModulus(), 2,10E-10);
        assertEquals(z.getArgument(),3*  Math.PI / 2,10E-10);
    }

    @Test
    public void addition0(){
        ComplexNumber z1 = factory.createComplexNumberFromCartesian(0,1);
        ComplexNumber z2 = factory.createComplexNumberFromCartesian(1,0);
        ComplexNumber result = z1.plus(z2);
        assertEquals(result.getReal(), 1,10E-5);
        assertEquals(result.getImaginary(), 1,10E-5);
    }

    @Test
    public void addition1(){
        ComplexNumber z1 = factory.createComplexNumberFromCartesian(1,1);
        ComplexNumber z2 = factory.createComplexNumberFromCartesian(-1,-1);
        ComplexNumber result = z1.plus(z2);
        assertEquals(result.getReal(), 0,10E-5);
        assertEquals(result.getImaginary(), 0,10E-5);
    }

    @Test
    public void addition2(){
        ComplexNumber z1 = factory.createComplexNumberFromCartesian(1,-1);
        ComplexNumber z2 = factory.createComplexNumberFromCartesian(0,1);
        ComplexNumber result = z1.plus(z2);
        assertEquals(result.getReal(), 1,10E-5);
        assertEquals(result.getImaginary(), 0,10E-5);
    }

    @Test
    public void soustraction0(){
        ComplexNumber z1 = factory.createComplexNumberFromCartesian(0,1);
        ComplexNumber z2 = factory.createComplexNumberFromCartesian(1,0);
        ComplexNumber result =z1.minus(z2);
        assertEquals(result.getReal(), -1,10E-5);
        assertEquals(result.getImaginary(), 1,10E-5);
    }

    @Test
    public void soustraction1(){
        ComplexNumber z1 = factory.createComplexNumberFromCartesian(1,1);
        ComplexNumber z2 = factory.createComplexNumberFromCartesian(-1,-1);
        ComplexNumber result =z1.minus(z2);
        assertEquals(result.getReal(), 2,10E-5);
        assertEquals(result.getImaginary(), 2,10E-5);
    }

    @Test
    public void soustraction2(){
        ComplexNumber z1 = factory.createComplexNumberFromCartesian(1,-1);
        ComplexNumber z2 = factory.createComplexNumberFromCartesian(0,1);
        ComplexNumber result =z1.minus(z2);
        assertEquals(result.getReal(), 1,10E-5);
        assertEquals(result.getImaginary(), -2,10E-5);
    }

    @Test
    public void multiplication0(){
        ComplexNumber z1 = factory.createComplexNumberFromPolar(Math.sqrt(2),Math.PI / 4);
        ComplexNumber z2 = factory.createComplexNumberFromPolar(Math.sqrt(2),Math.PI / 4);
        ComplexNumber result =z1.multiply(z2);
        assertEquals(result.getModulus(), 2,10E-10);
        assertEquals(result.getArgument(), Math.PI / 2,10E-10);
    }

    @Test
    public void multiplication1(){
        ComplexNumber z1 = factory.createComplexNumberFromPolar(1,Math.PI / 3);
        ComplexNumber z2 = factory.createComplexNumberFromPolar(3,2*Math.PI / 3);
        ComplexNumber result =z1.multiply(z2);
        assertEquals(result.getModulus(), 3,10E-10);
        assertEquals(result.getArgument(), Math.PI,10E-10);
    }

    @Test
    public void multiplication2(){
        ComplexNumber z1 = factory.createComplexNumberFromPolar(2,0);
        ComplexNumber z2 = factory.createComplexNumberFromPolar(2,3*Math.PI / 2);
        ComplexNumber result =z1.multiply(z2);
        assertEquals(result.getModulus(), 4,10E-10);
        assertEquals(result.getArgument(), 3*Math.PI / 2,10E-10);
    }

    @Test
    public void conjugate0(){
        ComplexNumber z = factory.createComplexNumberFromPolar(Math.sqrt(2),Math.PI / 4);
        ComplexNumber result = z.conjugate();
        assertEquals(result.getModulus(), Math.sqrt(2),10E-10);
        assertEquals(result.getArgument(), 7*Math.PI / 4,10E-10);
    }

    @Test
    public void conjugate1(){
        ComplexNumber z = factory.createComplexNumberFromPolar(2,Math.PI);
        ComplexNumber result = z.conjugate();
        assertEquals(result.getModulus(), 2,10E-10);
        assertEquals(result.getArgument(), -Math.PI,10E-10);
    }

    @Test
    public void conjugate2(){
        ComplexNumber z = factory.createComplexNumberFromPolar(1,2*Math.PI/3);
        ComplexNumber result = z.conjugate();
        assertEquals(result.getModulus(), 1,10E-10);
        assertEquals(result.getArgument(), 4*Math.PI/3,10E-10);
    }
}
