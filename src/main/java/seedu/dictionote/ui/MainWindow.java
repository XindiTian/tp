package seedu.dictionote.ui;

import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import seedu.dictionote.commons.core.GuiSettings;
import seedu.dictionote.commons.core.LogsCenter;
import seedu.dictionote.logic.Logic;
import seedu.dictionote.logic.commands.CommandResult;
import seedu.dictionote.logic.commands.enums.UiAction;
import seedu.dictionote.logic.commands.enums.UiActionOption;
import seedu.dictionote.logic.commands.exceptions.CommandException;
import seedu.dictionote.logic.parser.exceptions.ParseException;

/**
 * The Main Window. Provides the basic application layout containing
 * a menu bar and space where other JavaFX elements can be placed.
 */
public class MainWindow extends UiPart<Stage> {

    private static final String FXML = "MainWindow.fxml";

    private static final float CONTACT_SPLIT = 0.25f;
    private static final float DICTIONARY_SPLIT = 0.3f;
    private static final float NOTE_SPLIT = 0.3f;
    private static final float MAIN_SPLIT = 0.5f;

    private final Logger logger = LogsCenter.getLogger(getClass());

    private Stage primaryStage;
    private Logic logic;

    // Independent Ui parts residing in this Ui container
    private PersonListPanel personListPanel;
    private NoteListPanel noteListPanel;
    private ResultDisplay resultDisplay;
    private HelpWindow helpWindow;

    @FXML
    private StackPane commandBoxPlaceholder;

    @FXML
    private MenuItem helpMenuItem;

    @FXML
    private StackPane personListPanelPlaceholder;

    @FXML
    private StackPane resultDisplayPlaceholder;

    @FXML
    private StackPane statusbarPlaceholder;

    @FXML
    private StackPane dictionaryListPlaceholder;

    @FXML
    private StackPane dictionaryContentPlaceholder;

    @FXML
    private StackPane noteListPlaceholder;

    @FXML
    private StackPane noteContentPlaceholder;


    //For show/hide function
    @FXML
    private AnchorPane contactDisplay;

    @FXML
    private AnchorPane dictionaryListDisplay;

    @FXML
    private AnchorPane dictionaryContentDisplay;

    @FXML
    private AnchorPane noteListDisplay;

    @FXML
    private AnchorPane noteContentDisplay;


    @FXML
    private SplitPane contactSplitPanel;

    @FXML
    private SplitPane dictionarySplitPanel;

    @FXML
    private SplitPane noteSplitPanel;

    //Split Panel between dictionary and Note
    @FXML
    private SplitPane mainSplitPanel;


    /**
     * Creates a {@code MainWindow} with the given {@code Stage} and {@code Logic}.
     */
    public MainWindow(Stage primaryStage, Logic logic) {
        super(FXML, primaryStage);
        // Set dependencies
        this.primaryStage = primaryStage;
        this.logic = logic;

        // Configure the UI
        setWindowDefaultSize(logic.getGuiSettings());

        setAccelerators();

        helpWindow = new HelpWindow();


    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }

    private void setAccelerators() {
        setAccelerator(helpMenuItem, KeyCombination.valueOf("F1"));
    }

    /**
     * Sets the accelerator of a MenuItem.
     *
     * @param keyCombination the KeyCombination value of the accelerator
     */
    private void setAccelerator(MenuItem menuItem, KeyCombination keyCombination) {
        menuItem.setAccelerator(keyCombination);
        /*
         * TODO: the code below can be removed once the bug reported here
         * https://bugs.openjdk.java.net/browse/JDK-8131666
         * is fixed in later version of SDK.
         *
         * According to the bug report, TextInputControl (TextField, TextArea) will
         * consume function-key events. Because CommandBox contains a TextField, and
         * ResultDisplay contains a TextArea, thus some accelerators (e.g F1) will
         * not work when the focus is in them because the key event is consumed by
         * the TextInputControl(s).
         *
         * For now, we add following event filter to capture such key events and open
         * help window purposely so to support accelerators even when focus is
         * in CommandBox or ResultDisplay.
         */
        getRoot().addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getTarget() instanceof TextInputControl && keyCombination.match(event)) {
                menuItem.getOnAction().handle(new ActionEvent());
                event.consume();
            }
        });
    }

    /**
     * Fills up all the placeholders of this window.
     */
    void fillInnerParts() {
        personListPanel = new PersonListPanel(logic.getFilteredContactList());
        personListPanelPlaceholder.getChildren().add(personListPanel.getRoot());

        noteListPanel = new NoteListPanel(logic.getFilteredNoteList());
        noteListPlaceholder.getChildren().add(noteListPanel.getRoot());

        resultDisplay = new ResultDisplay();
        resultDisplayPlaceholder.getChildren().add(resultDisplay.getRoot());

        StatusBarFooter statusBarFooter = new StatusBarFooter(logic.getAddressBookFilePath());
        statusbarPlaceholder.getChildren().add(statusBarFooter.getRoot());

        CommandBox commandBox = new CommandBox(this::executeCommand);
        commandBoxPlaceholder.getChildren().add(commandBox.getRoot());

    }

    /**
     * Sets the default size based on {@code guiSettings}.
     */
    private void setWindowDefaultSize(GuiSettings guiSettings) {
        primaryStage.setHeight(guiSettings.getWindowHeight());
        primaryStage.setWidth(guiSettings.getWindowWidth());
        if (guiSettings.getWindowCoordinates() != null) {
            primaryStage.setX(guiSettings.getWindowCoordinates().getX());
            primaryStage.setY(guiSettings.getWindowCoordinates().getY());
        }
    }

    /**
     * Dynamically detect and change the split ratio depending on the content
     */
    void configSplit() {
        configContactSplit();
        configNoteSplit();
        configDictionarySplit();
        configMainSplit();
    }

    /**
     * Dynamically detect and change the split ratio depending on contact visible visibility
     */
    private void configContactSplit() {
        if (contactDisplay.isVisible()) {
            contactSplitPanel.setDividerPositions(CONTACT_SPLIT);
        } else {
            contactSplitPanel.setDividerPositions(0);
        }
    }

    /**
     * Dynamically detect and change the split ratio depending on the dictionary list and content visibility
     */
    private void configDictionarySplit() {
        if (!dictionaryListDisplay.isVisible() && dictionaryContentDisplay.isVisible()) {
            dictionarySplitPanel.setDividerPositions(0);
        } else if (dictionaryListDisplay.isVisible() && !dictionaryContentDisplay.isVisible()) {
            dictionarySplitPanel.setDividerPositions(1);
        } else {
            dictionarySplitPanel.setDividerPositions(DICTIONARY_SPLIT);
        }
    }

    /**
     * Dynamically detect and change the split ratio depending on the note list and note visibility
     */
    private void configNoteSplit() {
        if (!noteListDisplay.isVisible() && noteContentDisplay.isVisible()) {
            noteSplitPanel.setDividerPositions(0);
        } else if (noteListDisplay.isVisible() && !noteContentDisplay.isVisible()) {
            noteSplitPanel.setDividerPositions(1);
        } else {
            noteSplitPanel.setDividerPositions(NOTE_SPLIT);
        }
    }

    /**
     * Dynamically detect and change the split ratio depending on the dictionary and note visibility
     */
    private void configMainSplit() {
        if (!noteListDisplay.isVisible() && !noteContentDisplay.isVisible()) {
            mainSplitPanel.setDividerPositions(1);
        } else if (!dictionaryListDisplay.isVisible() && !dictionaryContentDisplay.isVisible()) {
            mainSplitPanel.setDividerPositions(0);
        } else {
            mainSplitPanel.setDividerPositions(MAIN_SPLIT);
        }
    }


    /**
     * Opens the help window or focuses on it if it's already opened.
     */
    @FXML
    public void handleHelp() {
        if (!helpWindow.isShowing()) {
            helpWindow.show();
        } else {
            helpWindow.focus();
        }
    }

    void show() {
        primaryStage.show();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        GuiSettings guiSettings = new GuiSettings(primaryStage.getWidth(), primaryStage.getHeight(),
            (int) primaryStage.getX(), (int) primaryStage.getY());
        logic.setGuiSettings(guiSettings);
        helpWindow.hide();
        primaryStage.hide();
    }


    /**
     * Set the visiable of the panel.
     *
     * @param pane to hide.
     */
    private void setPanelVisibility(Pane pane, boolean visible) {
        pane.setVisible(visible);
    }


    /**
     * * Set the visiable of the panels.
     */
    private void handlePanelVisibility(UiActionOption uiActionOption, boolean visible) {

        switch (uiActionOption) {
        case DICTIONARY:
            setPanelVisibility(dictionaryContentDisplay, visible);
            setPanelVisibility(dictionaryListDisplay, visible);
            break;
        case DICTIONARY_LIST:
            setPanelVisibility(dictionaryListDisplay, visible);
            break;
        case DICTIONARY_CONTENT:
            setPanelVisibility(dictionaryContentDisplay, visible);
            break;
        case NOTE:
            setPanelVisibility(noteContentDisplay, visible);
            setPanelVisibility(noteListDisplay, visible);
            break;
        case NOTE_LIST:
            setPanelVisibility(noteListDisplay, visible);
            break;
        case NOTE_CONTENT:
            setPanelVisibility(noteContentDisplay, visible);
            break;
        case LIST:
            setPanelVisibility(dictionaryListDisplay, visible);
            setPanelVisibility(noteListDisplay, visible);
            break;
        case CONTACT:
            setPanelVisibility(contactDisplay, visible);
            break;
        case ALL:
            setPanelVisibility(contactDisplay, visible);
            setPanelVisibility(dictionaryListDisplay, visible);
            setPanelVisibility(dictionaryContentDisplay, visible);
            setPanelVisibility(noteListDisplay, visible);
            setPanelVisibility(noteContentDisplay, visible);
            break;
        case NONE:
            //Do nothing
            break;
        default:
            assert false : uiActionOption.toString() + " UiAction is not handle";
        }

        configSplit();
    }

    /**
     * Open a panel of a selected type.
     *
     * @param uiActionOption desire display to open.
     */
    private void handleOpen(UiActionOption uiActionOption) {
        handlePanelVisibility(uiActionOption, true);
    }

    /**
     * Close display panel of a selected type.
     *
     * @param uiActionOption desire display to close.
     */
    private void handleClose(UiActionOption uiActionOption) {
        handlePanelVisibility(uiActionOption, false);
    }

    public PersonListPanel getPersonListPanel() {
        return personListPanel;
    }

    /**
     * Executes the command and returns the result.
     *
     * @see seedu.dictionote.logic.Logic#execute(String)
     */
    private CommandResult executeCommand(String commandText) throws CommandException, ParseException {
        try {
            CommandResult commandResult = logic.execute(commandText);


            logger.info("Result: " + commandResult.getFeedbackToUser());
            resultDisplay.setFeedbackToUser(commandResult.getFeedbackToUser());

            executeUiAction(commandResult.getUiAction(), commandResult.getUiActionOption());

            return commandResult;
        } catch (CommandException | ParseException e) {
            logger.info("Invalid command: " + commandText);
            resultDisplay.setFeedbackToUser(e.getMessage());
            throw e;
        }
    }

    /**
     * Executes the Ui Action desired from the command.
     *
     * @see seedu.dictionote.logic.Logic#execute(String)
     */
    private void executeUiAction(UiAction action, UiActionOption uiActionOption) {
        switch (action) {
        case HELP:
            handleHelp();
            break;
        case EXIT:
            handleExit();
            break;
        case OPEN:
            handleOpen(uiActionOption);
            break;
        case CLOSE:
            handleClose(uiActionOption);
            break;
        case NONE:
            break;
        default:
            assert false : action.toString() + " UiAction is not handle";
            break;
        }
    }
}
