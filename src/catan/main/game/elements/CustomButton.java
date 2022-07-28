package catan.main.game.elements;

import catan.main.settings.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomButton extends JButton implements Settings {
    /**
     * This here unit models a custom button object which is specifically design so as to fit in with the UI of the
     * application.
     *
     *
     * @author Andrei-Paul Ionescu
     */
    // Attributes of the class.
    private boolean isMouseOverButtonArea = false;

    // Constructor of the class.
    public CustomButton(String name){

        // Disable the standard button look which is automatically generated based on the look and feel which the
        // program supports
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);

        // Change the foreground colour and add the test which is transmitted to the constructor via the aid of the
        // formal argument.
        this.setForeground(MAIN_MENU_BUTTON_TEXT_COLOUR);
        this.setText(name);

        this.setMinimumSize(new Dimension(INITIAL_BUTTON_WIDTH, INITIAL_BUTTON_HEIGHT));
        // Add a custom event listener to the button object so as to properly handle user's interactivity with the object.
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent event){


                isMouseOverButtonArea = true;
            }

            @Override
            public void mouseExited(MouseEvent event){

                isMouseOverButtonArea = false;
            }

            @Override
            public void mouseReleased(MouseEvent event){

                if(isMouseOverButtonArea) setBackground(Color.orange);
                else setBackground(Color.PINK);
            }
        });
    }

    // Public methods of the class.
    @Override
    public void paintComponent(Graphics graphics){

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //graphics2D.setColor(DARK_THEME_BUTTON_FOREGROUND);
        graphics2D.fillRect(0, 0, this.getWidth(), this.getHeight());
        graphics2D.setPaint(MAIN_MENU_BUTTON_BACKGROUND_COLOUR);
        graphics2D.fillRect(2, 2, this.getWidth() - 4, this.getHeight() - 4);
        super.paintComponent(graphics);
    }
}
