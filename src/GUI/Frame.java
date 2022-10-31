package GUI;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private  CoursePanel coursePanel;

    public Frame(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(new Dimension(500,500));
    }
}
