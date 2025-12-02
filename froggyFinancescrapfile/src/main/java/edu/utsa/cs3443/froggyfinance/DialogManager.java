package edu.utsa.cs3443.froggyfinance;

import java.util.ArrayList;

import java.util.List;

/**
 * Manages the dialog per level, separating them into opening dialogs and
 * feedback dialogs
 *
 * @author erikamey
 * @since 10/30/25
 */
public class DialogManager {
    private List<Dialog> openingDialogs;
    private List<Dialog> feedbackDialogs;
    private int openIndex = 0;
    /**
     * Constructs a new DialogManager and initializes the lists for
     * opening and feedback dialogs.
     */
    public DialogManager(){
        openingDialogs = new ArrayList<>();
        feedbackDialogs = new ArrayList<>();
    }
    /**
    * Loads dialogs from a specified file path for a given level, clearing
    * any previously loaded dialogs.
    *
    * @param filePath The path to the file containing the dialog data.
    * @param level The level identifier for which to load the dialogs.
    */
    public void loadDialogsForLevel(String filePath, int level){
        List<Dialog> allDialogs = DialogLoader.loadDialog(filePath, level);

        openingDialogs.clear();
        feedbackDialogs.clear();

        for (Dialog d : allDialogs){
            openingDialogs.add(new Dialog(d.getOpen(), "",""));

            feedbackDialogs.add(new Dialog("", d.getRight(), d.getWrong()));
        }
        openIndex = 0;
    }
    /**
     * Gets the next available dialog from the openingDialogs list
     * and increments the internal index.
     *
     * @return The next Dialog in the sequence.
     */
    public Dialog getNextOpeningDialog() {
        if (openIndex < openingDialogs.size()) {
            Dialog next = openingDialogs.get(openIndex);
            openIndex++;
            return next;
        }
        return null;
    }
    /**
     * Retrieves a specific feedback dialog based on an index.
     *
     * @param questionIndex The zero-based index of the desired feedback dialog.
     * @return The Dialog containing the right/wrong feedback.
     */
    public Dialog getFeedbackDialog(int questionIndex){
        if (questionIndex >= 0 && questionIndex < feedbackDialogs.size()) {
            return feedbackDialogs.get(questionIndex);
        }
        return null;
    }
    /**
     * Resets the index used for retrieving opening dialogs.
     */
    public void resetOpenDialogs(){
       openIndex = 0;
    }
}
