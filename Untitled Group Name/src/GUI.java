
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GUI extends JPanel
{
    private Hotel hotel;

    public GUI()
    {
        try
        {
            hotel = new Hotel();
        }
        catch (Exception input)
        {
            System.out.println(input.getMessage());
        }

        //super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(1000, 1000));
        mainPanel.setLayout(null);
        createMainPanel(mainPanel);
        tabbedPane.addTab("MAIN FLOOR", null, mainPanel);

        JPanel facilitiesPanel = new JPanel();
        facilitiesPanel.setLayout(null);
        createFacilityPanel(facilitiesPanel);
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
        JLabel hotelName = new JLabel(hotel.getName());
        hotelName.setBounds(50, 0, 200, 100);
        hotelName.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(hotelName);

        JLabel hotelDesc = new JLabel(hotel.getDescription());
        hotelDesc.setBounds(50, 50, 500, 100);
        hotelDesc.setFont(new Font("Verdana", Font.PLAIN, 14));
        panel.add(hotelDesc);

        JLabel hotelAnnouncements = new JLabel("Announcements:");
        hotelAnnouncements.setBounds(50, 300, 200, 100);
        hotelAnnouncements.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(hotelAnnouncements);
    }

    private void createFacilityPanel(JPanel panel)
    {
        addFacilityNames(panel);
        addFacilityAvailability(panel);
        addFacilityDesc(panel);
        addFacilityTime(panel);
    }

    private void addFacilityNames(JPanel panel)
    {
        JLabel pool = new JLabel(hotel.getFacility(0).getName());
        pool.setBounds(50, 0, 500, 100);
        pool.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(pool);

        JLabel gym = new JLabel(hotel.getFacility(1).getName());
        gym.setBounds(50, 200, 500, 100);
        gym.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(gym);

        JLabel resturant = new JLabel(hotel.getFacility(2).getName());
        resturant.setBounds(50, 400, 500, 100);
        resturant.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(resturant);

        JLabel bar = new JLabel(hotel.getFacility(3).getName());
        bar.setBounds(50, 600, 500, 100);
        bar.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(bar);

        JLabel lounge = new JLabel(hotel.getFacility(4).getName());
        lounge.setBounds(50, 800, 500, 100);
        lounge.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(lounge);
    }

    private void addFacilityTime(JPanel panel)
    {
        JLabel poolTime = new JLabel(hotel.getFacility(0).getTime());
        poolTime.setBounds(400, 0, 200, 100);
        poolTime.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(poolTime);

        JLabel gymTime = new JLabel(hotel.getFacility(0).getTime());
        gymTime.setBounds(400, 200, 200, 100);
        gymTime.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(gymTime);

        JLabel resturantTime = new JLabel(hotel.getFacility(0).getTime());
        resturantTime.setBounds(400, 400, 200, 100);
        resturantTime.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(resturantTime);

        JLabel barTime = new JLabel(hotel.getFacility(0).getTime());
        barTime.setBounds(400, 600, 200, 100);
        barTime.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(barTime);

        JLabel loungeTime = new JLabel(hotel.getFacility(0).getTime());
        loungeTime.setBounds(400, 800, 200, 100);
        loungeTime.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(loungeTime);

        JButton changeTimePool = new JButton("Change Time");
        changeTimePool.setBounds(800, 50, 200, 50);
        addDialogueBoxTime(changeTimePool, 0, poolTime);
        panel.add(changeTimePool);

        JButton changeTimeGym = new JButton("Change Time");
        changeTimeGym.setBounds(800, 250, 200, 50);
        addDialogueBoxTime(changeTimeGym, 1, gymTime);
        panel.add(changeTimeGym);

        JButton changeTimeResturant = new JButton("Change Time");
        changeTimeResturant.setBounds(800, 450, 200, 50);
        addDialogueBoxTime(changeTimeResturant, 2, resturantTime);
        panel.add(changeTimeResturant);

        JButton changeTimeBar = new JButton("Change Time");
        changeTimeBar.setBounds(800, 650, 200, 50);
        addDialogueBoxTime(changeTimeBar, 3, barTime);
        panel.add(changeTimeBar);

        JButton changeTimeLounge = new JButton("Change Time");
        changeTimeLounge.setBounds(800, 850, 200, 50);
        addDialogueBoxTime(changeTimeLounge, 4, loungeTime);
        panel.add(changeTimeLounge);
    }

    private void addFacilityAvailability(JPanel panel)
    {
        JLabel poolAvailability = new JLabel(availabilitySwap(hotel.getFacility(0).getAvailability()));
        poolAvailability.setBounds(600, 0, 200, 100);
        poolAvailability.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(poolAvailability);

        JLabel gymAvailability = new JLabel(availabilitySwap(hotel.getFacility(1).getAvailability()));
        gymAvailability.setBounds(600, 200, 200, 100);
        gymAvailability.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(gymAvailability);

        JLabel resturantAvailability = new JLabel(availabilitySwap(hotel.getFacility(2).getAvailability()));
        resturantAvailability.setBounds(600, 400, 200, 100);
        resturantAvailability.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(resturantAvailability);

        JLabel barAvailability = new JLabel(availabilitySwap(hotel.getFacility(3).getAvailability()));
        barAvailability.setBounds(600, 600, 200, 100);
        barAvailability.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(barAvailability);

        JLabel loungeAvailability = new JLabel(availabilitySwap(hotel.getFacility(4).getAvailability()));
        loungeAvailability.setBounds(600, 800, 200, 100);
        loungeAvailability.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(loungeAvailability);

        JButton changeAvailabilityPool = new JButton("Change Availability");
        changeAvailabilityPool.setBounds(800, 100, 200, 50);
        addDialogueBoxAvailability(changeAvailabilityPool, 0, poolAvailability);
        panel.add(changeAvailabilityPool);

        JButton changeAvailabilityGym = new JButton("Change Availability");
        changeAvailabilityGym.setBounds(800, 300, 200, 50);
        addDialogueBoxAvailability(changeAvailabilityGym, 0, gymAvailability);
        panel.add(changeAvailabilityGym);

        JButton changeAvailabilityResturant = new JButton("Change Availability");
        changeAvailabilityResturant.setBounds(800, 500, 200, 50);
        addDialogueBoxAvailability(changeAvailabilityResturant, 0, resturantAvailability);
        panel.add(changeAvailabilityResturant);

        JButton changeAvailabilityBar = new JButton("Change Availability");
        changeAvailabilityBar.setBounds(800, 700, 200, 50);
        addDialogueBoxAvailability(changeAvailabilityBar, 0, barAvailability);
        panel.add(changeAvailabilityBar);

        JButton changeAvailabilityLounge = new JButton("Change Availability");
        changeAvailabilityLounge.setBounds(800, 900, 200, 50);
        addDialogueBoxAvailability(changeAvailabilityLounge, 0, loungeAvailability);
        panel.add(changeAvailabilityLounge);
    }


    private void addFacilityDesc(JPanel panel)
    {
        JLabel poolDesc = new JLabel(hotel.getFacility(0).getDescription());
        poolDesc.setBounds(50, 50, 500, 100);
        poolDesc.setFont(new Font("Verdana", Font.PLAIN, 14));
        panel.add(poolDesc);

        JLabel gymDesc = new JLabel(hotel.getFacility(1).getDescription());
        gymDesc.setBounds(50, 250, 500, 100);
        gymDesc.setFont(new Font("Verdana", Font.PLAIN, 14));
        panel.add(gymDesc);

        JLabel resturantDesc = new JLabel(hotel.getFacility(2).getDescription());
        resturantDesc.setBounds(50, 450, 500, 100);
        resturantDesc.setFont(new Font("Verdana", Font.PLAIN, 14));
        panel.add(resturantDesc);

        JLabel barDesc = new JLabel(hotel.getFacility(3).getDescription());
        barDesc.setBounds(50, 650, 500, 100);
        barDesc.setFont(new Font("Verdana", Font.PLAIN, 14));
        panel.add(barDesc);

        JLabel loungeDesc = new JLabel(hotel.getFacility(4).getDescription());
        loungeDesc.setBounds(50, 850, 500, 100);
        loungeDesc.setFont(new Font("Verdana", Font.PLAIN, 14));
        panel.add(loungeDesc);
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

    private void changeTime(int index, JLabel label)
    {
        JFrame box = new JFrame();
        String newData = JOptionPane.showInputDialog(box, "Enter new time:  ");

        hotel.getFacility(index).setTime(newData);
        label.setText(newData);
    }

    private void addDialogueBoxTime(JButton button, int index, JLabel label)
    {
        button.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        changeTime(index, label);
                    }
                }
                );
    }

    private void changeAvailability(int index, JLabel label)
    {
        hotel.getFacility(index).setAvailablity(!hotel.getFacility(index).getAvailability());
        label.setText(availabilitySwap(hotel.getFacility(index).getAvailability()));
    }

    private void addDialogueBoxAvailability(JButton button, int index, JLabel label)
    {
        button.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        changeAvailability(index, label);
                    }
                }
                );
    }

    private String availabilitySwap(boolean bool)
    {
        String string = null;

        if(bool == true)
        {
            string = "OPEN";
        }
        else
        {
            string = "CLOSED";
        }

        return string;
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