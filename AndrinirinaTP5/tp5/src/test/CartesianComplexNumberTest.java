import org.junit.jupiter.api.BeforeAll;

public class CartesianComplexNumberTest extends ComplexNumberTest{
    @BeforeAll
    public void setup(){
        factory = new CartesianComplexNumberFactory();
    };
}
