package project_group;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class LeaderBoardPanels extends JPanel {
    
    public LeaderBoardPanels() {
        initComponents();
    }
    
    private void initComponents() {
    setLayout(new BorderLayout());
    setBackground(new Color(245, 245, 245));
    
    // Header
    JPanel headerPanel = createHeader();
    
    // Main content - use BoxLayout EXACTLY like SettingsPanel
    JPanel mainContent = new JPanel();
    mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
    mainContent.setBackground(new Color(245, 245, 245));
    mainContent.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));
    
    // Add all cards
    mainContent.add(createPodiumCard());
    mainContent.add(Box.createVerticalStrut(15));
    mainContent.add(createYourRankingCard());
    mainContent.add(Box.createVerticalStrut(15));
    mainContent.add(createLeaderboardTableCard());
    mainContent.add(Box.createVerticalStrut(15));
    mainContent.add(createBadgesCard());
    mainContent.add(Box.createVerticalStrut(15));
    mainContent.add(createDepartmentRankingsCard());
    
    // Add flexible space
    mainContent.add(Box.createVerticalGlue());
    
    // Wrap in JScrollPane EXACTLY like SettingsPanel
    JScrollPane scrollPane = new JScrollPane(mainContent);
    scrollPane.setBorder(null);
    scrollPane.getVerticalScrollBar().setUnitIncrement(16);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    add(headerPanel, BorderLayout.NORTH);
    add(scrollPane, BorderLayout.CENTER);
}
    
//    private void initComponents() {
//        setLayout(new BorderLayout());
//        setBackground(new Color(245, 245, 245));
//        
//        // Create header
//        JPanel headerPanel = createHeader();
//        
//        // Create main content
//        JPanel mainContent = createMainContent();
//        JScrollPane scrollPane = new JScrollPane(mainContent);
//        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
//        
//        
//        add(headerPanel, BorderLayout.NORTH);
//        add(scrollPane, BorderLayout.CENTER);
//    }
    
    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(245, 245, 245));
        header.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JLabel titleLabel = new JLabel("🏆 Leaderboard");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(new Color(44, 62, 80));
        
        JComboBox<String> timeFilter = new JComboBox<>(new String[]{"All Time", "This Month", "This Week"});
        timeFilter.setPreferredSize(new Dimension(150, 30));
        
        header.add(titleLabel, BorderLayout.WEST);
        header.add(timeFilter, BorderLayout.EAST);
        
        return header;
    }
    
    private JPanel createMainContent() {
        JPanel mainContent = new JPanel();
        mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
        mainContent.setBackground(new Color(245, 245, 245));
        mainContent.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));
        
        // Podium card
        mainContent.add(createPodiumCard());
        mainContent.add(Box.createVerticalStrut(15));
        
        // Your ranking card
        mainContent.add(createYourRankingCard());
        mainContent.add(Box.createVerticalStrut(15));
        
        // Leaderboard table card
        mainContent.add(createLeaderboardTableCard());
        mainContent.add(Box.createVerticalStrut(15));
        
        // Badges card
        mainContent.add(createBadgesCard());
        
        return mainContent;
    }
    
    private JPanel createCard(String title, JComponent content) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.LIGHT_GRAY),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(new Color(44, 62, 80));
        card.add(titleLabel, BorderLayout.NORTH);
        
        card.add(content, BorderLayout.CENTER);
        return card;
    }
    
    private JPanel createPodiumCard() {
        JPanel podiumPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        podiumPanel.setBackground(Color.WHITE);
        
        // 2nd place
        JPanel secondPlace = createPodiumPanel("🥈", "Jamson Anjera", "Marketing", "1,450 pts", Color.LIGHT_GRAY);
        
        // 1st place (bigger)
        JPanel firstPlace = createPodiumPanel("🥇", "Johnstone", "Engineering", "1,650 pts", new Color(255, 215, 0));
        
        // 3rd place
        JPanel thirdPlace = createPodiumPanel("🥉", "June", "Sales", "1,380 pts", new Color(205, 127, 50));
        
        podiumPanel.add(secondPlace);
        podiumPanel.add(firstPlace);
        podiumPanel.add(thirdPlace);
        
        return createCard("🏆 Top Performers", podiumPanel);
    }
    
    private JPanel createDepartmentRankingsCard() {
    JPanel panel = new JPanel(new BorderLayout());
    
    String[] depts = {"Engineering", "Marketing", "Sales", "HR", "Finance"};
    int[] scores = {1420, 1280, 1150, 980, 850};
    
    JPanel barsPanel = new JPanel();
    barsPanel.setLayout(new BoxLayout(barsPanel, BoxLayout.Y_AXIS));
    
    for (int i = 0; i < depts.length; i++) {
        JPanel deptPanel = new JPanel(new BorderLayout());
        
        JLabel deptLabel = new JLabel(depts[i]);
        deptLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        JProgressBar bar = new JProgressBar(0, 2000);
        bar.setValue(scores[i]);
        bar.setString(scores[i] + " avg");
        bar.setStringPainted(true);
        bar.setForeground(new Color(52, 152, 219));
        
        deptPanel.add(deptLabel, BorderLayout.WEST);
        deptPanel.add(bar, BorderLayout.CENTER);
        
        barsPanel.add(deptPanel);
        barsPanel.add(Box.createVerticalStrut(8));
    }
    
    panel.add(barsPanel, BorderLayout.CENTER);
    
    return createCard("👥 Department Rankings", panel);
}
    
    private JPanel createPodiumPanel(String medal, String name, String dept, String points, Color bgColor) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(bgColor);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel medalLabel = new JLabel(medal);
        medalLabel.setFont(new Font("Segoe UI", Font.PLAIN, 36));
        medalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel deptLabel = new JLabel(dept);
        deptLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        deptLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel pointsLabel = new JLabel(points);
        pointsLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        pointsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.add(medalLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(nameLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(deptLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(pointsLabel);
        
        return panel;
    }
    
    private JPanel createYourRankingCard() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(Color.WHITE);
        
        JLabel rankLabel = new JLabel("Current Rank: 15th");
        rankLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        
        JLabel pointsLabel = new JLabel("Points: 1,250");
        pointsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        JLabel deptLabel = new JLabel("Department: Engineering");
        deptLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        JLabel trendLabel = new JLabel("▲ 2 positions this week");
        trendLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        trendLabel.setForeground(new Color(39, 174, 96));
        
        JLabel nextLabel = new JLabel("🎯 Next milestone: Top 10 (250 points away)");
        nextLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        JButton viewStatsBtn = new JButton("View My Detailed Stats");
        viewStatsBtn.setBackground(new Color(52, 152, 219));
        viewStatsBtn.setForeground(Color.WHITE);
        viewStatsBtn.setMaximumSize(new Dimension(200, 35));
        viewStatsBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        content.add(rankLabel);
        content.add(Box.createVerticalStrut(10));
        content.add(pointsLabel);
        content.add(Box.createVerticalStrut(5));
        content.add(deptLabel);
        content.add(Box.createVerticalStrut(10));
        content.add(trendLabel);
        content.add(Box.createVerticalStrut(5));
        content.add(nextLabel);
        content.add(Box.createVerticalStrut(15));
        content.add(viewStatsBtn);
        
        panel.add(content, BorderLayout.CENTER);
        return createCard("👤 Your Ranking", panel);
    }
    
    private JPanel createLeaderboardTableCard() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        
        // Create table data
        String[] columns = {"Rank", "Name", "Department", "Points", "Trend"};
        Object[][] data = {
            {1, "Johnstone", "Engineering", 1650, "▲2"},
            {2, "Sarah Johnson", "Marketing", 1450, "▼1"},
            {3, "Mike Chen", "Sales", 1380, "▲3"},
            {4, "Lisa Wang", "HR", 1320, "►0"},
            {5, "Alex Kim", "Engineering", 1290, "▲1"},
            {6, "Maria Garcia", "Finance", 1270, "▼2"},
            {7, "David Kim", "Engineering", 1265, "▲1"},
            {8, "Emily Brown", "Marketing", 1260, "►0"},
            {9, "James Wilson", "Sales", 1258, "▼1"},
            {10, "Sarah Thompson", "HR", 1255, "▲2"},
            {11, "Robert Davis", "Engineering", 1253, "▼1"},
            {12, "Jennifer Lee", "Marketing", 1252, "►0"},
            {13, "Michael Clark", "Sales", 1251, "▲1"},
            {14, "Amanda White", "Finance", 1248, "▼2"},
            {15, "Jamson (You)", "Engineering", 1245, "▲2"}
        };
        
        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        JTable table = new JTable(model);
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table.setShowGrid(true);
        table.setGridColor(Color.LIGHT_GRAY);
        
        // Center align all columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        // Left align name column
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);
        table.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);
        
        // Color trend column
        DefaultTableCellRenderer trendRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, 
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                String trend = value.toString();
                if (trend.contains("▲")) {
                    c.setForeground(new Color(39, 174, 96));
                } else if (trend.contains("▼")) {
                    c.setForeground(new Color(231, 76, 60));
                } else {
                    c.setForeground(Color.GRAY);
                }
                setHorizontalAlignment(JLabel.CENTER);
                return c;
            }
        };
        table.getColumnModel().getColumn(4).setCellRenderer(trendRenderer);
        
        // Highlight current user row
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, 
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                String name = table.getValueAt(row, 1).toString();
                if (name.contains("(You)")) {
                    c.setBackground(new Color(220, 237, 255));
                } else {
                    c.setBackground(Color.WHITE);
                }
                if (isSelected) {
                    c.setBackground(new Color(52, 152, 219));
                    c.setForeground(Color.WHITE);
                }
                return c;
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        
        JLabel showingLabel = new JLabel("Showing 1-15 of 150 employees");
        showingLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        showingLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        JPanel container = new JPanel(new BorderLayout());
        container.add(panel, BorderLayout.CENTER);
        container.add(showingLabel, BorderLayout.SOUTH);
        
        return createCard("📊 Full Leaderboard", container);
    }
    
    private JPanel createBadgesCard() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        
        JPanel badgesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        badgesPanel.setBackground(Color.WHITE);
        
        String[] badges = {"🥇", "⭐", "📚", "🚀", "👑", "💡", "🏅", "🎯"};
        String[] badgeNames = {"Java Expert", "Quick Learner", "Code Master", "Team Player", 
                               "Perfect Score", "Early Adopter", "Consistent", "Goal Getter"};
        
        for (int i = 0; i < badges.length; i++) {
            JPanel badgePanel = new JPanel();
            badgePanel.setLayout(new BoxLayout(badgePanel, BoxLayout.Y_AXIS));
            badgePanel.setBackground(Color.WHITE);
            badgePanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            badgePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            
            JLabel badgeLabel = new JLabel(badges[i]);
            badgeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
            badgeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            JLabel nameLabel = new JLabel(badgeNames[i]);
            nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            badgePanel.add(badgeLabel);
            badgePanel.add(Box.createVerticalStrut(5));
            badgePanel.add(nameLabel);
            
            badgesPanel.add(badgePanel);
        }
        
        JLabel earnedLabel = new JLabel("You have earned 6 of 15 available badges");
        earnedLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        earnedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        panel.add(badgesPanel, BorderLayout.CENTER);
        panel.add(earnedLabel, BorderLayout.SOUTH);
        
        return createCard("🎖 Available Badges", panel);
    }
}