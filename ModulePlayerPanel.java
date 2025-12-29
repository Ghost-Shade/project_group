
/*
    GROUP NAME: LOUCIOUS
UNIT: OBJECT ORIENTED PROGRAMMING II
DATE: 19/12/2025

MEMBERS:

JAMSON ANJERA:            CCS/00039/024
JOHNSTON ODHIAMBO :       CCT/00012/024
JUNE JEPKOSGEI RUTO :     ESC/00389/024
ALPHONCE KIOKO:           CCT/00070/024

*/

/*
        PLEASE NOTE THAT!!!
INORDER FOR THE APPLICATION TO RUN THERE MUST EXIST A DATABASE IN THE LOCAL MACHINE.
I HAVE INCLUDED THE DATABASE MODIFICATION QUERIES IN A FOLDER KNOWN AS "database".
YOU CAN USE THOSE QUERIES TO CREATE A DATABASE.
AGAIN INORDER TO RUN THE APPLICATION YOU MUST START WITH THE AuthFrame.java FILE and Log in BEFORE PROCEEDING.


*/


package project_group;

import java.awt.*;
import javax.swing.*;

public class ModulePlayerPanel extends JPanel {
    private Main_Page mainPage;
    
    public ModulePlayerPanel() {
        initComponents();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        // Create header
        JPanel headerPanel = createHeader();
        
        // Create main content
        JPanel contentPanel = createContent();
        
        // Create sidebar
        JPanel sidebarPanel = createSidebar();
        
        // Create footer
        JPanel footerPanel = createFooter();
        
        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(sidebarPanel, BorderLayout.EAST);
        add(footerPanel, BorderLayout.SOUTH);
    }
    
    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(245, 245, 245));
        header.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        
        // Back button
        JButton backButton = new JButton("← Back to Modules");
        backButton.setBackground(new Color(149, 165, 166));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> {
            if (mainPage != null) {
                mainPage.showLearningModules();
            }
        });
        
        // Module title
        JLabel titleLabel = new JLabel("Java Programming Fundamentals");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Progress
        JPanel progressPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        progressPanel.setBackground(new Color(245, 245, 245));
        
        JLabel progressLabel = new JLabel("Lesson 3 of 12");
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(25);
        progressBar.setForeground(new Color(39, 174, 96));
        progressBar.setPreferredSize(new Dimension(100, 15));
        
        progressPanel.add(progressLabel);
        progressPanel.add(progressBar);
        
        header.add(backButton, BorderLayout.WEST);
        header.add(titleLabel, BorderLayout.CENTER);
        header.add(progressPanel, BorderLayout.EAST);
        
        return header;
    }
    
    private JPanel createContent() {
        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Color.WHITE);
        content.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Lesson title
        JLabel lessonTitle = new JLabel("📝 Lesson 3: Variables and Data Types");
        lessonTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lessonTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        
        // Lesson content
        JTextArea lessonContent = new JTextArea(
            "Variables are containers for storing data values. In Java, there are different types of variables, for example:\n\n" +
            "• String - stores text, such as \"Hello\". String values are surrounded by double quotes\n" +
            "• int - stores integers (whole numbers), without decimals, such as 123 or -123\n" +
            "• float - stores floating point numbers, with decimals, such as 19.99 or -19.99\n" +
            "• char - stores single characters, such as 'a' or 'B'. Char values are surrounded by single quotes\n" +
            "• boolean - stores values with two states: true or false\n\n" +
            "📌 Key Points:\n" +
            "• Variables must be declared before use\n" +
            "• Java is strongly typed\n" +
            "• Variable names are case-sensitive\n" +
            "• Use meaningful variable names\n\n" +
            "Example Code:\n" +
            "   String name = \"John\";\n" +
            "   int age = 25;\n" +
            "   double salary = 55000.50;\n" +
            "   boolean isEmployed = true;\n\n" +
            "🛠 Practice Exercise:\n" +
            "Create variables for:\n" +
            "- Your name (String)\n" +
            "- Your birth year (int)\n" +
            "- Your height in meters (double)\n" +
            "- Whether you like Java (boolean)"
                
             
        );
        lessonContent.setFont(new Font("Monospaced", Font.PLAIN, 13));
        lessonContent.setLineWrap(true);
        lessonContent.setWrapStyleWord(true);
        lessonContent.setEditable(false);
        lessonContent.setBackground(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane(lessonContent);
        
        content.add(lessonTitle, BorderLayout.NORTH);
        content.add(scrollPane, BorderLayout.CENTER);
        
        return content;
    }
    
    private JPanel createSidebar() {
        JPanel sidebar = new JPanel(new BorderLayout());
        sidebar.setBackground(new Color(240, 240, 240));
        sidebar.setPreferredSize(new Dimension(250, 0));
        sidebar.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Course outline
        JLabel outlineLabel = new JLabel("Course Outline");
        outlineLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        outlineLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        String[] lessons = {
            "▶ Introduction",
            "▶ Lesson 1: Java Basics",
            "▶ Lesson 2: Operators",
            "▷ Lesson 3: Variables ← Current",
            "▶ Lesson 4: Control Flow",
            "▶ Lesson 5: Methods",
            "▶ Lesson 6: Arrays",
            "▶ Lesson 7: OOP Concepts",
            "▶ Lesson 8: Inheritance",
            "▶ Lesson 9: Polymorphism",
            "▶ Lesson 10: Collections",
            "▶ Lesson 11: File Handling",
            "▶ Lesson 12: Final Project"
        };
        
        JList<String> lessonList = new JList<>(lessons);
        lessonList.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lessonList.setBackground(new Color(240, 240, 240));
        lessonList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lessonList.setSelectedIndex(3);
        
        JScrollPane listScroll = new JScrollPane(lessonList);
        
        // Resources
        JPanel resourcesPanel = new JPanel();
        resourcesPanel.setLayout(new BoxLayout(resourcesPanel, BoxLayout.Y_AXIS));
        resourcesPanel.setBackground(new Color(240, 240, 240));
        resourcesPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        JButton downloadBtn = new JButton("📥 Download Slides");
        JButton filesBtn = new JButton("📋 Exercise Files");
        
        downloadBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
        filesBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
        downloadBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        filesBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        
        resourcesPanel.add(downloadBtn);
        resourcesPanel.add(Box.createVerticalStrut(5));
        resourcesPanel.add(filesBtn);
        
        sidebar.add(outlineLabel, BorderLayout.NORTH);
        sidebar.add(listScroll, BorderLayout.CENTER);
        sidebar.add(resourcesPanel, BorderLayout.SOUTH);
        
        return sidebar;
    }
    
    private JPanel createFooter() {
        JPanel footer = new JPanel(new BorderLayout());
        footer.setBackground(new Color(245, 245, 245));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        footer.setPreferredSize(new Dimension(1200,700));
        
        // Previous button
        JButton prevButton = new JButton("◀ Previous Lesson");
        prevButton.setBackground(new Color(149, 165, 166));
        prevButton.setForeground(Color.WHITE);
        
        // Center buttons
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        centerPanel.setBackground(new Color(245, 245, 245));
        
        JCheckBox completeCheck = new JCheckBox("Mark as Complete");
        JButton quizButton = new JButton("Take Quiz");
        quizButton.setBackground(new Color(39, 174, 96));
        quizButton.setForeground(Color.WHITE);
        
        centerPanel.add(completeCheck);
        centerPanel.add(quizButton);
        
        // Next button
        JButton nextButton = new JButton("Next Lesson ▶");
        nextButton.setBackground(new Color(52, 152, 219));
        nextButton.setForeground(Color.WHITE);
        
        footer.add(prevButton, BorderLayout.WEST);
        footer.add(centerPanel, BorderLayout.CENTER);
        footer.add(nextButton, BorderLayout.EAST);
        
        return footer;
    }
    
    public void setMainPage(Main_Page mainPage) {
        this.mainPage = mainPage;
    }
}