
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GUI extends JPanel
{
    public GUI()
    {
        //super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(1000, 1000));
        mainPanel.setLayout(null);
        createMainPanel(mainPanel);
        tabbedPane.addTab("MAIN FLOOR", null, mainPanel);

        JPanel facilitiesPanel = new JPanel();
        facilitiesPanel.setLayout(null);
        createFacilitiesPanel(facilitiesPanel);
        tabbedPane.addTab("FACILITIES", null, facilitiesPanel);

        JPanel f2Panel = new JPanel();
        createFloorPanel(f2Panel, 2);
        tabbedPane.addTab("FLOOR 2", null, f2Panel);

        JPanel f3Panel = new JPanel();
        createFloorPanel(f3Panel, 3);
        tabbedPane.addTab("FLOOR 3", null, f3Panel);

        add(tabbedPane);

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    private void createMainPanel(JPanel panel)
    {
        JLabel hotelName = new JLabel("Hotel Name");
        hotelName.setBounds(50, 0, 200, 100);
        hotelName.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(hotelName);

        JLabel hotelDesc = new JLabel("Hotel Desc");
        hotelDesc.setBounds(50, 50, 200, 100);
        hotelDesc.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(hotelDesc);

        JLabel hotelAnnouncements = new JLabel("Announcements:");
        hotelAnnouncements.setBounds(50, 100, 200, 100);
        hotelAnnouncements.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(hotelAnnouncements);

        JLabel announcements[] = new JLabel[10];
    }

    private void createFacilitiesPanel(JPanel panel)
    {
        createFacilitiesNames(panel);
        createFacilitiesButtons(panel);
    }

    private void createFacilitiesNames(JPanel panel)
    {
        JLabel pool = new JLabel("Pool");
        pool.setBounds(50, 0, 200, 100);
        pool.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(pool);

        JLabel gym = new JLabel("Gym");
        gym.setBounds(50, 200, 200, 100);
        gym.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(gym);

        JLabel resturant = new JLabel("Resturant");
        resturant.setBounds(50, 400, 200, 100);
        resturant.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(resturant);

        JLabel bar = new JLabel("Bar");
        bar.setBounds(50, 600, 200, 100);
        bar.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(bar);

        JLabel lounge = new JLabel("Lounge");
        lounge.setBounds(50, 800, 200, 100);
        lounge.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(lounge);
    }

    private void createFacilitiesButtons(JPanel panel)
    {
        JButton changeTimePool = new JButton("Change Time");
        changeTimePool.setBounds(800, 50, 200, 50);
        panel.add(changeTimePool);
        JButton changeAvailibilityPool = new JButton("Change Availibility");
        changeAvailibilityPool.setBounds(800, 100, 200, 50);
        panel.add(changeAvailibilityPool);

        JButton changeTimeGym = new JButton("Change Time");
        changeTimeGym.setBounds(800, 250, 200, 50);
        panel.add(changeTimeGym);
        JButton changeAvailibilityGym = new JButton("Change Availibility");
        changeAvailibilityGym.setBounds(800, 300, 200, 50);
        panel.add(changeAvailibilityGym);

        JButton changeTimeResturant = new JButton("Change Time");
        changeTimeResturant.setBounds(800, 450, 200, 50);
        panel.add(changeTimeResturant);
        JButton changeAvailibilityResturant = new JButton("Change Availibility");
        changeAvailibilityResturant.setBounds(800, 500, 200, 50);
        panel.add(changeAvailibilityResturant);

        JButton changeTimeBar = new JButton("Change Time");
        changeTimeBar.setBounds(800, 650, 200, 50);
        panel.add(changeTimeBar);
        JButton changeAvailibilityBar = new JButton("Change Availibility");
        changeAvailibilityBar.setBounds(800, 700, 200, 50);
        panel.add(changeAvailibilityBar);

        JButton changeTimeLounge = new JButton("Change Time");
        changeTimeLounge.setBounds(800, 850, 200, 50);
        panel.add(changeTimeLounge);
        JButton changeAvailibilityLounge = new JButton("Change Availibility");
        changeAvailibilityLounge.setBounds(800, 900, 200, 50);
        panel.add(changeAvailibilityLounge);
    }

    private void createFacilityDesc(JPanel panel)
    {

    }

    private void createFloorPanel(JPanel panel, int floor)
    {
        String roomNumber;
        JButton room;
        int i = 1;

        while(i <= 10)
        {
            roomNumber = floor + "0" + i;
            if(i == 10)
            {
                roomNumber = floor + Integer.toString(i);
            }

            room = new JButton(roomNumber);
            room.setPreferredSize(new Dimension(100, 100));
            room.setFont(new Font("Verdana", Font.PLAIN, 18));
            panel.add(room);
            i++;
        }
    }

    public static void createAndShowGUI()
    {
        //Create and set up the window.
        JFrame frame = new JFrame("Hotel Service Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new GUI(), BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}