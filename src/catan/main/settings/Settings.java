// The package/current namespace of this particular Java compilation unit.
package catan.main.settings;

// Imports from existing Java libraries, classes and interfaces.
import java.awt.*;

public interface Settings {
    /**
     * This here interface contains a collection of constants which serve as the settings for the current project.
     *
     * @author Andrei-Paul Ionescu.
     */

    // Game title
    final String GAME_TITLE = "Catan";

    // Initial screen settings.
    final int INITIAL_SCREEN_WIDTH  = 1200;
    final int INITIAL_SCREEN_HEIGHT = 800;
    Color BACKGROUND_COLOUR         = Color.BLACK;
}
