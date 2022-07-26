// The package/current namespace of this particular Java compilation unit.
package catan.main;

// Imports from custom libraries, classes and interfaces.
import catan.main.view.MainMenuView;

// Imports from existing Java libraries, classes and interfaces.
import javax.swing.*;

public class Runner {
    /**
     *  This here class serves as the main runner of the game, and its role is to instantiate a MainMenuView object
     *  which will then allow the user to commence interacting with the program and thus to commence instantiating
     *  other views and triggering other functionalities.
     *
     *  @author Andrei-Paul Ionescu.
     */

    public static void main(String[] args){

        // Utilise the SwingUtilities invokeLater routine so as to make sure that the newly invoked graphical window
        // is thread safe.
        SwingUtilities.invokeLater(MainMenuView::new);
    }
}
