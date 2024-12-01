/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AdminDashboard;

import Events.Event;
import Events.EventList;
import UserDashboard.BookedEvent;
import UserDashboard.EventBookingHelper;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.util.List;
import java.util.Set;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

/**
 *
 * @author MaHir0
 */
public class EventBookedByUser extends javax.swing.JFrame {
    private final EventList eventList = new EventList();
    String name;
    String email;
    String u_id;
    String image;
    /**
     * Creates new form EventBookedByUser
     */
    public EventBookedByUser(User user) {
        setTitle("Booked Events");
        this.u_id = String.valueOf(user.getU_id());
        this.name = user.getFullName();
        this.email = user.getEmail();
        this.image = user.getImage();
        initComponents();
        setLocationRelativeTo(null);
        setImageToLabel(jLabel4, image);
    }
    private void setImageToLabel(JLabel label, String imagePath) {
        try {
            // Check if the image file exists
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                ImageIcon imageIcon = new ImageIcon(imagePath); // Load the image
                // Scale the image to fit the label
                Image scaledImage = imageIcon.getImage().getScaledInstance(label.getWidth(),
                        label.getHeight(),
                        Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(scaledImage));
            } else {
                label.setText("Image not found");
                label.setHorizontalAlignment(SwingConstants.CENTER);
            }
        } catch (Exception e) {
            e.printStackTrace();
            label.setText("Error loading image");
            label.setHorizontalAlignment(SwingConstants.CENTER);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        eventJPanel = new javax.swing.JScrollPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel5.setText("Event Booked");

        jLabel7.setFont(new java.awt.Font("Cambria", 3, 18)); // NOI18N
        jLabel7.setText(name);

        jLabel8.setText(email);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))))
                    .addComponent(eventJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel8))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
        );

        // Now you can call loadEventCards() to load the event cards into the scroll pane
        JScrollBar verticalScrollBar = eventJPanel.getVerticalScrollBar();

        // Increase the unit increment (scroll step with mouse wheel)
        verticalScrollBar.setUnitIncrement(30);  // Default is usually around 16, increase for faster scrolling

        // Increase the block increment (scroll step with page up/down or arrow keys)
        verticalScrollBar.setBlockIncrement(60);
        JPanel panelInsideScroll = new JPanel();
        panelInsideScroll.setLayout(new BoxLayout(panelInsideScroll, BoxLayout.Y_AXIS));  // Vertical layout
        eventJPanel.setViewportView(panelInsideScroll);

        // Now you can call loadEventCards() to load the event cards into the scroll pane
        loadEventCards(eventList.getEvents(), u_id);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void loadEventCards(List<Event> events, String u_id) {
        // Get the set of booked events for the user
        Set<BookedEvent> bookedEvents = EventBookingHelper.getBookedEvents(u_id);

        // Debugging: Check booked events
        System.out.println("Booked Events for user (" + u_id + "): " + bookedEvents);

        // Initialize the inner panel of the JScrollPane if not already set
        JPanel panelInsideScroll = (JPanel) eventJPanel.getViewport().getView();
        if (panelInsideScroll == null) {
            panelInsideScroll = new JPanel();
            panelInsideScroll.setLayout(new BoxLayout(panelInsideScroll, BoxLayout.Y_AXIS)); // Use a vertical BoxLayout
            eventJPanel.setViewportView(panelInsideScroll);
        }

        // Clear existing event cards
        panelInsideScroll.removeAll();

        // Counter to track added event cards
        int eventCardCount = 0;

        // Iterate through booked events and add cards
        for (BookedEvent bookedEvent : bookedEvents) {
            // Find the corresponding Event object by eventId
            Event event = events.stream()
                    .filter(e -> e.getE_id().equals(bookedEvent.getEventId()))
                    .findFirst()
                    .orElse(null);

            if (event != null) {
                System.out.println("Creating card for booked event: " + event.getName());

                // Create the event card with the booking date
                JPanel eventCard = EventBookingCheckByAdmin.buildCompleteEventPanel(bookedEvent, u_id);

                if (eventCard != null) {
                    // Ensure alignment and add to the panel
                    eventCard.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panelInsideScroll.add(eventCard);
                    eventCardCount++;
                } else {
                    System.out.println("Failed to create event card for event: " + event.getName());
                }
            } else {
                System.out.println("No event found for booked event: " + bookedEvent.getEventId());
            }
        }

        // Log the number of cards added
        System.out.println("Total event cards added: " + eventCardCount);

        // Add empty placeholders if no event cards were added
        if (eventCardCount < 3) {
            for (int i = eventCardCount; i < 3; i++) {
                JPanel emptyEventCard = new JPanel();
                emptyEventCard.setPreferredSize(new Dimension(600, 100));
                emptyEventCard.setBackground(Color.WHITE);
                emptyEventCard.setAlignmentX(Component.LEFT_ALIGNMENT);
                panelInsideScroll.add(emptyEventCard);
            }
        }

        // Refresh the panel to display updated content
        panelInsideScroll.revalidate();
        panelInsideScroll.repaint();
        System.out.println("Repainted event panel.");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane eventJPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
