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
    final int INITIAL_SCREEN_HEIGHT = 675;
    Color BACKGROUND_COLOUR         = Color.BLACK;

    // Main menu view settings.
    final int INITIAL_BUTTON_WIDTH = 600;
    final int INITIAL_BUTTON_HEIGHT = 50;
    final int MARGIN_BOTTOM = 200;
    final Color MAIN_MENU_BUTTON_TEXT_COLOUR = Color.WHITE;
    final GradientPaint MAIN_MENU_BUTTON_BACKGROUND_COLOUR = new GradientPaint
            (0, 0, new Color(241, 189, 112),
                    (float)INITIAL_BUTTON_WIDTH/2, (float)INITIAL_BUTTON_HEIGHT/2, new Color(113, 89, 81));
}
