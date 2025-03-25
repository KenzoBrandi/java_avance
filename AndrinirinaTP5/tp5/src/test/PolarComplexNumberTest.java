import org.junit.jupiter.api.BeforeAll;

public class PolarComplexNumberTest extends ComplexNumberTest{
    @BeforeAll
    public void setup(){
        factory = new PolarComplexNumberFactory();
    };
}
