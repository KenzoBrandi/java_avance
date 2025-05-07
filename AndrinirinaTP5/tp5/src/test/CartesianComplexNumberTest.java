import org.junit.jupiter.api.BeforeEach;

public class CartesianComplexNumberTest extends ComplexNumberTest{
    @BeforeEach
    public void setup(){
        factory = new CartesianComplexNumberFactory();
    };
}
