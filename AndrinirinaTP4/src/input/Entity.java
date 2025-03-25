package input;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * An interface that represents an entity in a class diagram 
 */
public interface Entity 
{    /**
     * Give the name of the entity
     * 
     * @return the entity name
     */
    public String getName();

    void generate(BufferedWriter writer) throws IOException;
}

