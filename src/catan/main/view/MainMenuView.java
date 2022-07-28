package catan.main.view;

import catan.main.game.elements.CustomButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuView extends View{

    // Constructors of the class.
    public MainMenuView(){
        /*
         * @param none; this here constructor method takes no formal arguments upon invocation.
         *
         * This here method serves as the main and sole constructor for the MainMenuView class, and its role is to
         * properly instantiate the MainMenuView object so that all the functionalities are served properly to the user.
         *
         * @author Andrei-Paul Ionescu.
         */

        // Invoke the constructor of the super/parent class.
        super(1);

        // Invoke the initialisation routine for the view.
        this.initialise();
    }

    // Private/helper methods of the class.
    private void addButtons(){
        /*
         * @param none; this here method takes no arguments upon invocation.
         *
         * This here function achieves one thing, it adds to the centre of the current view the
         * buttons which the app requires, at this point in time those buttons are PLAY, OPTIONS and EXIT,
         * which are present in the view in this exact order, each button has a listener attached to it
         * which deals with onclick events and which triggers different actions to be taken, action
         * which are further explained in the method.
         *
         * @author Andrei-Paul Ionescu.
         */

        // Create a new JPanel upon which we will collate our buttons.
        JPanel buttonsPanel = new JPanel();

        // Set the layout manager of the panel object.
        buttonsPanel.setLayout(new GridLayout(10, 1, 10, 5));

        // Add the title of the game on the main menu screen.
        JLabel title = new JLabel(GAME_TITLE, SwingConstants.CENTER);
        // Set the foreground of the component to the one specified in the Settings interface.
        //title.setForeground();

        //title.setFont(this.customFont);

        // Add the title to the current JPanel object.
        buttonsPanel.add(title);

        // Add a bottom margin with the aid of the Box class.
        buttonsPanel.add(Box.createHorizontalStrut(MARGIN_BOTTOM));

        // Create and instantiate the PLAY button.
        JButton button = new CustomButton("PLAY");

        // Create a new ActionListener and instantiate it using the nested class JButtonActionListener.
        ActionListener listener = new JButtonActionListener(button){

            @Override
            public void actionPerformed(ActionEvent event){
                /*
                 * @param event; an ActionEvent object.
                 *
                 * If the user clicks on the play button then, for now, the response to this action is that
                 * the current window/ view will be terminated and a GameWindow will be instantiated.
                 *
                 * @author Andrei-Paul Ionescu.
                 */

                MainMenuView.this.setVisible(false); // Make current JFrame invisible so as to create a smoother transition.
                MainMenuView.this.dispose(); // Get rid of the current Frame.
                SwingUtilities.invokeLater(GameView::new); // Instantiate a new GameWindow object.
            }
        };

        // Link the ActionListener with the JButton object.
        button.addActionListener(listener);

        // Size the button in accordance with the initial size which is specified in the Settings' interface.
        button.setPreferredSize(new Dimension(INITIAL_BUTTON_WIDTH, INITIAL_BUTTON_HEIGHT));

        // Make the button visible.
        button.setVisible(true);

        // Add the current button to the JPanel.
        buttonsPanel.add(button);

        // Add a bottom margin with the aid of the Box class.
        buttonsPanel.add(Box.createHorizontalStrut(MARGIN_BOTTOM));

        // Create and instantiate the SETTINGS button.
        button = new CustomButton("SETTINGS");

        // Create a new ActionListener and instantiate it using the nested class JButtonActionListener.
        listener = new JButtonActionListener(button){

            @Override
            public void actionPerformed(ActionEvent event){
                /*
                 * @param event; an ActionEvent object.
                 *
                 * If the user clicks on this particular object then this will trigger a chain of events which will
                 * mutate the aspect of the current view by switching the JPanel from the one which serves as the
                 * main menu view to the one which serves as the option menu in which different buttons and sliders
                 * are present so as to allow the user to manipulate various game settings, such as sound, brightness,
                 * etcetera.
                 *
                 * @author Andrei-Paul Ionescu.
                 */



                MainMenuView.this.remove(buttonsPanel); // Remove the buttonsPanel JPanel object from the current frame.

               // MainMenuView.this.createTheSettingsMenu(); // Invoke the method which deals with the creation of the settings menu.
                MainMenuView.this.revalidate(); // Revalidate the current frame.
                MainMenuView.this.repaint(); // Repaint the current frame.
            }
        };

        // Link the ActionListener with the JButton object.
        button.addActionListener(listener);

        // Size the button in accordance with the initial size which is specified in the Settings' interface.
        button.setPreferredSize(new Dimension(INITIAL_BUTTON_WIDTH, INITIAL_BUTTON_HEIGHT));
        button.revalidate();

        // Make the button visible.
        button.setVisible(true);

        // Add the current button to the JPanel.
        buttonsPanel.add(button);

        // Add a bottom margin with the aid of the Box class.
        buttonsPanel.add(Box.createHorizontalStrut(MARGIN_BOTTOM));

        // Create and instantiate the EXIT button.
        button = new CustomButton("EXIT");

        // Create a new ActionListener and instantiate it using the nested class JButtonActionListener.
        listener = new JButtonActionListener(button){

            @Override
            public void actionPerformed(ActionEvent event){
                /*
                 * @param event; an ActionEvent object.
                 *
                 * If the user click on this particular button then it will trigger the termination of the lifespan
                 * of the program, much alike with what happens when the user presses down the combo command + e.
                 * The response to this event is broken down in the following stages, first the current frame is
                 * made invisible then the various objects which are utilised are liberated and then finally the whole
                 * program is shutdown with the aid of the System unit.
                 *
                 * @author Andrei-Paul Ionescu.
                 */

                MainMenuView.this.setVisible(false); // Make the current invisible so as to make the transition smoother.
                MainMenuView.this.dispose(); // Get rid of the current frame by freeing the processes which are link to its existence.
                System.exit(0); // Exit the program with the status 0.
            }
        };

        // Link the ActionListener with the JButton object.
        button.addActionListener(listener);

        // Size the button in accordance with the initial size which is specified in the Settings' interface.
        button.setPreferredSize(new Dimension(INITIAL_BUTTON_WIDTH, INITIAL_BUTTON_HEIGHT));
        button.revalidate();

        // Make the button visible.
        button.setVisible(true);

        // Add the current button to the JPanel.
        buttonsPanel.add(button);

        // Add a bottom margin with the aid of the Box class.
        buttonsPanel.add(Box.createHorizontalStrut(MARGIN_BOTTOM));

        // Change the background colour of the JPanel before collating it to the current frame.
        buttonsPanel.setBackground(BACKGROUND_COLOUR);

        // Make sure that the button pane is transparent so as to not generate a conflict between this panel and the
        // background one.
        buttonsPanel.setOpaque(false);

        // Add the JPanel to the current frame.
        if(this.getBackgroundPanel() != null)
            this.getBackgroundPanel().add(buttonsPanel);
        else
            this.getContentPane().add(buttonsPanel);
    }

    private void initialise(){
        /*
         * @param none; this here methods takes no arguments upon invocation.
         *
         * This method deals with the initialisation and creation of the basic functionalities which our
         * menu requires to have such as a system of buttons which alter the current view, or they entirely
         * get rid of it and instantiate a new one, i.e. the play button. Either way this here method
         * deals with these tasks, and it accomplishes them with the aid of other helper methods.
         *
         * @author Andrei-Paul Ionescu.
         */

        // Set the layout of the current frame.
        this.setLayout(new GridBagLayout());

        // Call the method which creates and properly displays the buttons of the menu.
        this.addButtons();

        // Change the background colour of the current frame so that it conforms to the colour theme of the project.
        this.getContentPane().setBackground(BACKGROUND_COLOUR);
    }

    // Nested class.
    class JButtonActionListener implements ActionListener{
        /*
         * This here class is designed to be utilised only within the scope of the MainMenu class and its
         * role is to model the action listener of a JButton in such a way that it will enable us to
         * easily respond to changes and events without constantly keeping a reference to the buttons.
         *
         * @author Andrei-Paul Ionescu.
         */

        // Attributes of the class.
        private final JButton button;

        // Constructors of the class.
        public JButtonActionListener(JButton button){this.button = button;}

        @Override
        public void actionPerformed(ActionEvent event) {
            /*
             * @param event; an ActionEvent object.
             *
             * This method is to be overridden by the caller, this feat enables us to maintain an abstract
             * class which can be 'customised' to the needs of the caller.
             *
             * @author Andrei-Paul Ionescu.
             */
        }

        // Getters of the class.
        public JButton getButton(){return this.button;}
    }

}
