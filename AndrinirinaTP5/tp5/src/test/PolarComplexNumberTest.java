import org.junit.jupiter.api.BeforeEach;

public class PolarComplexNumberTest extends ComplexNumberTest{
    @BeforeEach
    public void setup(){
        factory = new PolarComplexNumberFactory();
    };
}
