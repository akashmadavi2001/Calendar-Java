package calendar;

import java.awt.Font;
import java.awt.Toolkit;
import java.util.Date;

public class Calendar extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Calendar.class.getName());

    public Calendar() {
        initComponents();
        setTitle("Digital Calendar");
        new MyThread().start();
        setIconImage();
    };

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("digital-clock.png")));
    };
    
    class MyThread extends Thread {

        @Override
        public void run() {

            String weekdays[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

            while (true) {
                Date d = new Date();
                String hr = (d.getHours() % 12) < 10 ? "0" + (d.getHours() % 12) : "" + (d.getHours() % 12);
                String min = d.getMinutes() < 10 ? "0" + d.getMinutes() : "" + d.getMinutes();
                String sec = d.getSeconds() < 10 ? "0" + d.getSeconds() : "" + d.getSeconds();

                String t = hr + " : " + min + " : " + sec;

                String date = d.getDate() < 10 ? "0" + d.getDate() : "" + d.getDate();
                String day = "" + weekdays[d.getDay()];
                String month = "" + months[d.getMonth()];
                String year = "" + (d.getYear() + 1900);

                cDate.setText(date);
                cDate.setFont(new Font("Digital-7", Font.PLAIN, 160));

                cDay.setText(day);
                cDay.setFont(new Font("Digital-7", Font.PLAIN, 60));

                cMonth.setText(month);
                cMonth.setFont(new Font("Digital-7", Font.PLAIN, 60));

                cYear.setText(year);
                cYear.setFont(new Font("Digital-7", Font.PLAIN, 60));

                lclock.setText(t);
                lclock.setFont(new Font("Digital-7", Font.PLAIN, 24));

                try {
                    sleep(100);
                } catch (Exception ex) {
                    break;
                };
            };
        };
    };
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cDate = new javax.swing.JLabel();
        cDay = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cMonth = new javax.swing.JLabel();
        cYear = new javax.swing.JLabel();
        lclock = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        cDate.setFont(new java.awt.Font("Segoe UI", 1, 160));
        cDate.setForeground(new java.awt.Color(255, 255, 255));
        cDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cDate.setText("00");

        cDay.setFont(new java.awt.Font("Segoe UI", 1, 48));
        cDay.setForeground(new java.awt.Color(255, 255, 255));
        cDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cDay.setText("DAYS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cDate, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cDate, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cDay, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        cMonth.setFont(new java.awt.Font("Segoe UI", 1, 48));
        cMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cMonth.setText("Month");

        cYear.setFont(new java.awt.Font("Segoe UI", 1, 48)); 
        cYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cYear.setText("Year");

        lclock.setBackground(new java.awt.Color(255, 255, 255));
        lclock.setFont(new java.awt.Font("Segoe UI", 1, 24)); 
        lclock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lclock.setText("00:00:00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cMonth, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(lclock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cYear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(cMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cYear, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lclock, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    
    public static void main(String args[]) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
       java.awt.EventQueue.invokeLater(() -> new Calendar().setVisible(true));
    }

    private javax.swing.JLabel cDate;
    private javax.swing.JLabel cDay;
    private javax.swing.JLabel cMonth;
    private javax.swing.JLabel cYear;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lclock;
}
