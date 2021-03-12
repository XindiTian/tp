package seedu.dictionote.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.dictionote.commons.core.LogsCenter;
import seedu.dictionote.model.contact.Contact;

/**
 * Panel containing the list of persons.
 */
public class PersonListPanel extends UiPart<Region> {
    private static final String FXML = "PersonListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);

    @FXML
    private ListView<Contact> personListView;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public PersonListPanel(ObservableList<Contact> contactList) {
        super(FXML);
        personListView.setItems(contactList);
        personListView.setCellFactory(listView -> new PersonListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class PersonListViewCell extends ListCell<Contact> {
        @Override
        protected void updateItem(Contact contact, boolean empty) {
            super.updateItem(contact, empty);

            if (empty || contact == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new PersonCard(contact, getIndex() + 1).getRoot());
            }
        }
    }

}
