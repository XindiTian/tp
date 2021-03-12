<<<<<<< HEAD:src/test/java/seedu/dicitonote/commons/core/ConfigTest.java
package seedu.dicitonote.commons.core;
=======
package seedu.dictionote.commons.core;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/commons/core/ConfigTest.java

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ConfigTest {

    @Test
    public void toString_defaultObject_stringReturned() {
        String defaultConfigAsString = "Current log level : INFO\n"
                + "Preference file Location : preferences.json";

        assertEquals(defaultConfigAsString, new Config().toString());
    }

    @Test
    public void equalsMethod() {
        Config defaultConfig = new Config();
        assertNotNull(defaultConfig);
        assertTrue(defaultConfig.equals(defaultConfig));
    }


}
