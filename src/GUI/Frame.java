package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

import University.Course;
import Writer.*;

public class Frame extends JFrame {

    private Course course;

    private  CoursePanel coursePanel;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem saveItem;
    public Frame(String title, Course course) throws HeadlessException {
        super(title);

        this.course = course;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(new Dimension(500,500));

        createMenu();

        coursePanel = new CoursePanel(course);

        add(coursePanel, BorderLayout.CENTER);
    }
    private void createMenu()
    {
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        saveItem = new JMenuItem("Save as");
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setMultiSelectionEnabled(true);
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                fileChooser.setFileHidingEnabled(false);
                fileChooser.showOpenDialog(null);
                File f = fileChooser.getSelectedFile();

                if (f == null)
                    return;
                try {
                    MyWriter.toFile(course,f,false);
                }catch (IOException err)
                {
                    System.err.println(err.getMessage());
                }
            };
        });
        menu.add(saveItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }
}
