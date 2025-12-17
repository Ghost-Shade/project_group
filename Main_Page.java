
package project_group;
import java.awt.*;
import javax.swing.*;
public class Main_Page extends javax.swing.JFrame {
    
    //Method to initialize all Panels
    private void setupMainContentArea(){
        cardLayout = new CardLayout();
        mainContentPanel.setLayout(cardLayout);
        mainContentPanel.setBackground(Color.WHITE);
        
//        JScrollPane scrollPane = new JScrollPane(mainContentPanel);
//
//        scrollPane.setVerticalScrollBarPolicy(
//            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
//        );
//        scrollPane.setHorizontalScrollBarPolicy(
//            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
//        );
        

        
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(jPanel2, BorderLayout.WEST);
        jPanel1.add(mainContentPanel,BorderLayout.CENTER);
    }
    private void initializePanels(){
        try{
            settingsPanel = new SettingsPanels();
            leaderBoardPanel = new LeaderBoardPanels();
            
            learningModulesPanel = new LearningModulesPanels();
            learningModulesPanel.setMainPage(this);//Pass reference
            
            moduleReadingPanel = new ModulePlayerPanel();
            moduleReadingPanel.setMainPage(this);
            
            progressAnalyticsPanel = new ProgressAnalyticsPanels();
            dashboardPanel = new DashboardPanels();
            
            
            JScrollPane dashboardScroll = new JScrollPane(dashboardPanel);
            JScrollPane learningScroll = new JScrollPane(learningModulesPanel);
            JScrollPane progressScroll = new JScrollPane(progressAnalyticsPanel);
            JScrollPane leaderboardScroll = new JScrollPane(leaderBoardPanel);
            JScrollPane settingsScroll = new JScrollPane(settingsPanel);
            
            configureScrollPane(dashboardScroll);
            configureScrollPane(learningScroll);
            configureScrollPane(progressScroll);
            configureScrollPane(leaderboardScroll);
            configureScrollPane(settingsScroll);
            
            //Adding Panels to mainContentPanel with Unique names
            mainContentPanel.add(dashboardPanel, "Dashboard");
            mainContentPanel.add(settingsPanel,"Settings");
            mainContentPanel.add(leaderBoardPanel,"Leaderboard");
            mainContentPanel.add(learningModulesPanel, "Modules");
            mainContentPanel.add(moduleReadingPanel, "Reading");
            mainContentPanel.add(progressAnalyticsPanel, "Progress");
            
            
        }catch(Exception e){
            logger.log(java.util.logging.Level.SEVERE, "Error initializing panels", e);
            javax.swing.JOptionPane.showMessageDialog(this, 
            "Error loading panels: " + e.getMessage(), 
            "Error", 
            javax.swing.JOptionPane.ERROR_MESSAGE);

        }
    }
    
    private void configureScrollPane(JScrollPane scrollPane){
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
    }
    
//    private void setupNavigation(){
//        DashboardButton.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                cardLayout.show(mainContentPanel, "Dashboard" );
//                highlightActiveButton(DashboardButton);
//            }
//        });
//    }

    
    private void highlightActiveButton(JButton activeButton){
        //ResetButtons To Default
        JButton[] buttons = {LogoutButton, SettingsButton, LeaderBoardBtn, ProgressAnalyBtn, LearnModulesBtn, DashboardButton};
        
        for(JButton button : buttons){
            button.setBackground(new Color(0,102,255)); //Orif=ginal Color
            button.setForeground(Color.BLACK);
//            button.setFont(new Font());
        }
        //Higlight active Button
        activeButton.setBackground(new Color(0,102,102));
        activeButton.setForeground(Color.WHITE);
//        activeButton.setFont(new Font());
    }
    
    public void showModulePlayer(){
        cardLayout.show(mainContentPanel, "ModulePlayer");
        //We Do not Highlight the Module Player Buttons becaues it isnt in the Main Nav
    }
    
    public void showLearningModules(){
        cardLayout.show(mainContentPanel, "Modules");
        highlightActiveButton(LearnModulesBtn);
    }
    
    private void loadUserData(){
        AuthDBManager.User currentUser = AuthDBManager.getCurrentUser();
        if(currentUser != null){
            jLabel1.setText("Welcome, "+currentUser.getFullName());
        }
    }
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Main_Page.class.getName());
    /**
     * Creates new form Main_Page
     */
//    private javax.swing.JPanel mainContentPanel;
    private java.awt.CardLayout cardLayout;
//    private JPanel mainContentPanel;
    
    //PanelInstances
    private SettingsPanels settingsPanel;
    private LeaderBoardPanels leaderBoardPanel;
    private LearningModulesPanels learningModulesPanel;
    private ModulePlayerPanel moduleReadingPanel;
    private ProgressAnalyticsPanels progressAnalyticsPanel;
    private DashboardPanels dashboardPanel;
    
    
    //Constructorr
    public Main_Page() {
        initComponents();
        jButton1.setBorderPainted(false);
        //Modifying Constructor to initialize everything
//        cardLayout = (CardLayout) mainContentPanel.getLayout();
        setupMainContentArea();
        initializePanels();
//        setupNavigation();
        loadUserData();
        
        cardLayout.show(mainContentPanel, "Dashboard");
        highlightActiveButton(DashboardButton);//DashboardButton
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        DashboardButton = new javax.swing.JButton();
        LeaderBoardBtn = new javax.swing.JButton();
        ProgressAnalyBtn = new javax.swing.JButton();
        LearnModulesBtn = new javax.swing.JButton();
        SettingsButton = new javax.swing.JButton();
        LogoutButton = new javax.swing.JButton();
        mainContentPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1174, 1558));

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(2174, 1289));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 900));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 831));

        jButton1.setText("Sign Out");

        DashboardButton.setBackground(new java.awt.Color(0, 102, 255));
        DashboardButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        DashboardButton.setForeground(new java.awt.Color(0, 0, 0));
        DashboardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Home.png"))); // NOI18N
        DashboardButton.setText("Dashboard");
        DashboardButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        DashboardButton.setBorderPainted(false);
        DashboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashboardButtonActionPerformed(evt);
            }
        });

        LeaderBoardBtn.setBackground(new java.awt.Color(0, 102, 255));
        LeaderBoardBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        LeaderBoardBtn.setForeground(new java.awt.Color(0, 0, 0));
        LeaderBoardBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Leaderboard.png"))); // NOI18N
        LeaderBoardBtn.setText("Leaderboard");
        LeaderBoardBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LeaderBoardBtn.setBorderPainted(false);
        LeaderBoardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaderBoardBtnActionPerformed(evt);
            }
        });

        ProgressAnalyBtn.setBackground(new java.awt.Color(0, 102, 255));
        ProgressAnalyBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        ProgressAnalyBtn.setForeground(new java.awt.Color(0, 0, 0));
        ProgressAnalyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Performance Goal.png"))); // NOI18N
        ProgressAnalyBtn.setText("Progress & Analytics");
        ProgressAnalyBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ProgressAnalyBtn.setBorderPainted(false);
        ProgressAnalyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProgressAnalyBtnActionPerformed(evt);
            }
        });

        LearnModulesBtn.setBackground(new java.awt.Color(0, 102, 255));
        LearnModulesBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        LearnModulesBtn.setForeground(new java.awt.Color(0, 0, 0));
        LearnModulesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Learning.png"))); // NOI18N
        LearnModulesBtn.setText("Learning Modules");
        LearnModulesBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LearnModulesBtn.setBorderPainted(false);
        LearnModulesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LearnModulesBtnActionPerformed(evt);
            }
        });

        SettingsButton.setBackground(new java.awt.Color(0, 102, 255));
        SettingsButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        SettingsButton.setForeground(new java.awt.Color(0, 0, 0));
        SettingsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Settings.png"))); // NOI18N
        SettingsButton.setText("Settings");
        SettingsButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        SettingsButton.setBorderPainted(false);
        SettingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsButtonActionPerformed(evt);
            }
        });

        LogoutButton.setBackground(new java.awt.Color(0, 102, 255));
        LogoutButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        LogoutButton.setForeground(new java.awt.Color(0, 0, 0));
        LogoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Logout.png"))); // NOI18N
        LogoutButton.setText("Logout");
        LogoutButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LogoutButton.setBorderPainted(false);
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(LearnModulesBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DashboardButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ProgressAnalyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(LeaderBoardBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SettingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LogoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(DashboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LearnModulesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProgressAnalyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LeaderBoardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SettingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1022, 1022, 1022)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_START);

        mainContentPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout mainContentPanelLayout = new javax.swing.GroupLayout(mainContentPanel);
        mainContentPanel.setLayout(mainContentPanelLayout);
        mainContentPanelLayout.setHorizontalGroup(
            mainContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1924, Short.MAX_VALUE)
        );
        mainContentPanelLayout.setVerticalGroup(
            mainContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1239, Short.MAX_VALUE)
        );

        jPanel1.add(mainContentPanel, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel2.setText("Employee Education Dashboard");
        jPanel4.add(jLabel2, java.awt.BorderLayout.LINE_START);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Profile.png"))); // NOI18N
        jLabel1.setText("Welcome, Jamson");
        jPanel4.add(jLabel1, java.awt.BorderLayout.LINE_END);

        jPanel5.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 269, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardButtonActionPerformed
        cardLayout.show(mainContentPanel,"Dashboard");
        highlightActiveButton(DashboardButton);
    }//GEN-LAST:event_DashboardButtonActionPerformed

    private void LeaderBoardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaderBoardBtnActionPerformed
        cardLayout.show(mainContentPanel, "Leaderboard");
        highlightActiveButton(LeaderBoardBtn);
    }//GEN-LAST:event_LeaderBoardBtnActionPerformed

    private void ProgressAnalyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProgressAnalyBtnActionPerformed
        cardLayout.show(mainContentPanel, "Progress");
        highlightActiveButton(ProgressAnalyBtn);
        
    }//GEN-LAST:event_ProgressAnalyBtnActionPerformed

    private void LearnModulesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LearnModulesBtnActionPerformed
        cardLayout.show(mainContentPanel, "Modules");
        highlightActiveButton(LearnModulesBtn);
        
    }//GEN-LAST:event_LearnModulesBtnActionPerformed

    private void SettingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsButtonActionPerformed
        cardLayout.show(mainContentPanel, "Settings");
        highlightActiveButton(SettingsButton);
    }//GEN-LAST:event_SettingsButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to logout",
                "Confirm Logout",
                JOptionPane.YES_NO_OPTION
        );
        if (confirm == JOptionPane.YES_OPTION) {
            AuthFrame authFrame = new AuthFrame();
            authFrame.setVisible(true);
            dispose();
        }
        
    }//GEN-LAST:event_LogoutButtonActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
//            logger.log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> new Main_Page().setVisible(true));
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DashboardButton;
    private javax.swing.JButton LeaderBoardBtn;
    private javax.swing.JButton LearnModulesBtn;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JButton ProgressAnalyBtn;
    private javax.swing.JButton SettingsButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel mainContentPanel;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.MenuBar menuBar2;
    // End of variables declaration//GEN-END:variables
}
