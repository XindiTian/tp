<<<<<<< HEAD:src/test/java/seedu/dicitonote/ui/TestFxmlObject.java
package seedu.dicitonote.ui;
=======
package seedu.dictionote.ui;
>>>>>>> 5707f1221a9e8b188be2a0aaadd1b48809f4ccfc:src/test/java/seedu/dictionote/ui/TestFxmlObject.java

import javafx.beans.DefaultProperty;

/**
 * A test object which can be constructed via an FXML file.
 * Unlike other JavaFX classes, this class can be constructed without the JavaFX toolkit being initialized.
 */
@DefaultProperty("text")
public class TestFxmlObject {

    private String text;

    public TestFxmlObject() {}

    public TestFxmlObject(String text) {
        setText(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TestFxmlObject // instanceof handles nulls
                        && text.equals(((TestFxmlObject) other).getText()));
    }

}
