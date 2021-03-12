<<<<<<< HEAD:src/test/java/seedu/dicitonote/commons/util/JsonUtilTest.java
package seedu.dicitonote.commons.util;
=======
package seedu.dictionote.commons.util;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/commons/util/JsonUtilTest.java

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

<<<<<<< HEAD:src/test/java/seedu/dicitonote/commons/util/JsonUtilTest.java
import seedu.dicitonote.testutil.SerializableTestClass;
import seedu.dicitonote.testutil.TestUtil;
=======
import seedu.dictionote.testutil.SerializableTestClass;
import seedu.dictionote.testutil.TestUtil;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/commons/util/JsonUtilTest.java

/**
 * Tests JSON Read and Write
 */
public class JsonUtilTest {

    private static final Path SERIALIZATION_FILE = TestUtil.getFilePathInSandboxFolder("serialize.json");

    @Test
    public void serializeObjectToJsonFile_noExceptionThrown() throws IOException {
        SerializableTestClass serializableTestClass = new SerializableTestClass();
        serializableTestClass.setTestValues();

        JsonUtil.serializeObjectToJsonFile(SERIALIZATION_FILE, serializableTestClass);

        assertEquals(FileUtil.readFromFile(SERIALIZATION_FILE), SerializableTestClass.JSON_STRING_REPRESENTATION);
    }

    @Test
    public void deserializeObjectFromJsonFile_noExceptionThrown() throws IOException {
        FileUtil.writeToFile(SERIALIZATION_FILE, SerializableTestClass.JSON_STRING_REPRESENTATION);

        SerializableTestClass serializableTestClass = JsonUtil
                .deserializeObjectFromJsonFile(SERIALIZATION_FILE, SerializableTestClass.class);

        assertEquals(serializableTestClass.getName(), SerializableTestClass.getNameTestValue());
        assertEquals(serializableTestClass.getListOfLocalDateTimes(), SerializableTestClass.getListTestValues());
        assertEquals(serializableTestClass.getMapOfIntegerToString(), SerializableTestClass.getHashMapTestValues());
    }

    //TODO: @Test jsonUtil_readJsonStringToObjectInstance_correctObject()

    //TODO: @Test jsonUtil_writeThenReadObjectToJson_correctObject()
}
