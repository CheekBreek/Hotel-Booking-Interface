
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(1000, 1000));
        mainPanel.setBackground(new Color(196, 234, 255));
        mainPanel.setLayout(null);
        createMainPanel(mainPanel);
        tabbedPane.addTab("MAIN FLOOR", null, mainPanel);

        JPanel facilitiesPanel = new JPanel();
        facilitiesPanel.setBackground(new Color(196, 234, 255));
        facilitiesPanel.setLayout(null);
        createFacilityPanel(facilitiesPanel);
        tabbedPane.addTab("FACILITIES", null, facilitiesPanel);

        JPanel f2Panel = new JPanel();
        f2Panel.setBackground(new Color(196, 234, 255));
        createFloorPanel(f2Panel, 2);
        f2Panel.setLayout(null);
        tabbedPane.addTab("FLOOR 2", null, f2Panel);

        JPanel f3Panel = new JPanel();
        f3Panel.setBackground(new Color(196, 234, 255));
        createFloorPanel(f3Panel, 3);
        f3Panel.setLayout(null);
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

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(100, 400, 800, 300);
        listAnnouncements(textArea);
        panel.add(scroll);

        JButton searchRoom = new JButton("Search Rooms");
        searchRoom.setPreferredSize(new Dimension(200, 100));
        searchRoom.setBounds(200, 850, 200, 100);
        addActionSearchRoom(searchRoom);
        panel.add(searchRoom);

        JButton makeAnnouncement = new JButton("Make Announcement");
        makeAnnouncement.setPreferredSize(new Dimension(200, 100));
        makeAnnouncement.setBounds(400, 850, 200, 100);
        addActionAddAnnouncement(makeAnnouncement, textArea);
        panel.add(makeAnnouncement);

        JButton removeAnnouncement = new JButton("Remove Announcement");
        removeAnnouncement.setPreferredSize(new Dimension(200, 100));
        removeAnnouncement.setBounds(600, 850, 200, 100);
        addActionRemoveAnnouncement(removeAnnouncement, textArea);
        panel.add(removeAnnouncement);
    }

    private void searchRoom()
    {
        JFrame dialogueBox = new JFrame();
        String input = JOptionPane.showInputDialog(dialogueBox, "Enter number of guests: ");
        int numGuest = 0;
        int floor = 0;
        int room = 0;

        JFrame outputBox = new JFrame("Room List");
        outputBox.setBounds(500, 400, 300, 300);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(500, 400, 300, 300);
        outputBox.add(scroll);

        if(input != null)
        {
            numGuest = Integer.parseInt(input);
            while(floor < 2)
            {
                while(room < 10)
                {
                    if(hotel.getRoom(floor, room).isBooked() != true && numGuest <= hotel.getRoom(floor, room).getCapacity())
                    {
                        if(room + 1 == 10)
                        {
                            textArea.append(Integer.toString(floor + 2) + Integer.toString(room + 1) + "\n");
                        }
                        else
                        {
                            textArea.append(Integer.toString(floor + 2) + "0" +Integer.toString(room + 1) + "\n");
                        }
                    }

                    room++;
                }
                room = 0;
                floor++;
            }
        }

        outputBox.setVisible(true);
    }

    private void addActionSearchRoom(JButton button)
    {
        button.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        searchRoom();
                    }
                }
                );
    }

    private void addAnnouncement()
    {
        JFrame box = new JFrame();
        String newData = JOptionPane.showInputDialog(box, "Enter new announcement:  ");

        if(newData != null)
        {
            hotel.addAnnouncement(newData + "\n", "");
        }
    }

    private void addActionAddAnnouncement(JButton button, JTextArea textArea)
    {
        button.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        addAnnouncement();
                        textArea.setText(null);
                        listAnnouncements(textArea);
                    }
                }
                );
    }

    private void removeAnnouncement()
    {
        JFrame box = new JFrame();
        String newData = JOptionPane.showInputDialog(box, "Enter the announcement you want to delete:  ");

        if(newData != null)
        {
            hotel.removeAnnouncement(Integer.parseInt(newData) - 1);
        }
    }

    private void addActionRemoveAnnouncement(JButton button, JTextArea textArea)
    {
        button.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        removeAnnouncement();
                        textArea.setText(null);
                        listAnnouncements(textArea);
                    }
                }
                );
    }

    private void listAnnouncements(JTextArea textArea)
    {
        int loop = 0;
        while(loop < hotel.getAnnouncementsLength())
        {
            textArea.append((loop + 1) + ". " + hotel.getAnnouncement(loop));
            loop++;
        }
    }

    //FACILITY FUNCTIONS

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
        changeTimePool.setBounds(750, 50, 200, 50);
        addDialogueBoxTime(changeTimePool, 0, poolTime);
        panel.add(changeTimePool);

        JButton changeTimeGym = new JButton("Change Time");
        changeTimeGym.setBounds(750, 250, 200, 50);
        addDialogueBoxTime(changeTimeGym, 1, gymTime);
        panel.add(changeTimeGym);

        JButton changeTimeResturant = new JButton("Change Time");
        changeTimeResturant.setBounds(750, 450, 200, 50);
        addDialogueBoxTime(changeTimeResturant, 2, resturantTime);
        panel.add(changeTimeResturant);

        JButton changeTimeBar = new JButton("Change Time");
        changeTimeBar.setBounds(750, 650, 200, 50);
        addDialogueBoxTime(changeTimeBar, 3, barTime);
        panel.add(changeTimeBar);

        JButton changeTimeLounge = new JButton("Change Time");
        changeTimeLounge.setBounds(750, 850, 200, 50);
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
        changeAvailabilityPool.setBounds(750, 100, 200, 50);
        addDialogueBoxAvailability(changeAvailabilityPool, 0, poolAvailability);
        panel.add(changeAvailabilityPool);

        JButton changeAvailabilityGym = new JButton("Change Availability");
        changeAvailabilityGym.setBounds(750, 300, 200, 50);
        addDialogueBoxAvailability(changeAvailabilityGym, 0, gymAvailability);
        panel.add(changeAvailabilityGym);

        JButton changeAvailabilityResturant = new JButton("Change Availability");
        changeAvailabilityResturant.setBounds(750, 500, 200, 50);
        addDialogueBoxAvailability(changeAvailabilityResturant, 0, resturantAvailability);
        panel.add(changeAvailabilityResturant);

        JButton changeAvailabilityBar = new JButton("Change Availability");
        changeAvailabilityBar.setBounds(750, 700, 200, 50);
        addDialogueBoxAvailability(changeAvailabilityBar, 0, barAvailability);
        panel.add(changeAvailabilityBar);

        JButton changeAvailabilityLounge = new JButton("Change Availability");
        changeAvailabilityLounge.setBounds(750, 900, 200, 50);
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

    private void changeTime(int index, JLabel label)
    {
        JFrame box = new JFrame();
        String newData = JOptionPane.showInputDialog(box, "Enter new time:  ");

        if(newData != null)
        {
            hotel.getFacility(index).setTime(newData);
            label.setText(newData);
        }
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

    //FLOOR FUNCTIONS

    private void createFloorPanel(JPanel panel, int floor)
    {
        JLabel custName = new JLabel();
        JLabel startDate = new JLabel();
        JLabel endDate = new JLabel();
        JLabel checkedIn = new JLabel();

        custName.setBounds(100, 100, 600, 100);
        custName.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(custName);

        startDate.setBounds(100, 300, 600, 100);
        startDate.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(startDate);

        endDate.setBounds(100, 500, 600, 100);
        endDate.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(endDate);

        checkedIn.setBounds(100, 700, 600, 100);
        checkedIn.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(checkedIn);

        custName.setText("Customer Name: ");
        startDate.setText("Start Date: ");
        endDate.setText("End Date: ");
        checkedIn.setText("Check In Status: ");

        String roomNumber;
        JButton room;
        int loop = 1;

        while(loop <= 10)
        {
            roomNumber = floor + "0" + loop;
            if(loop == 10)
            {
                roomNumber = floor + Integer.toString(loop);
            }

            room = new JButton(roomNumber);
            addActionRoomButton(room, floor - 2, loop - 1, custName, startDate, endDate, checkedIn);
            room.setPreferredSize(new Dimension(100, 100));
            room.setBounds((loop - 1)*100, 0, 100, 100);
            room.setFont(new Font("Verdana", Font.PLAIN, 18));
            panel.add(room);
            loop++;
        }

        JButton makeBooking = new JButton("Make Booking");
        makeBooking.setPreferredSize(new Dimension(200, 100));
        makeBooking.setBounds(300, 850, 200, 100);
        addActionMakeBooking(makeBooking, custName, startDate, endDate, checkedIn);
        panel.add(makeBooking);

        JButton changeCheckIn = new JButton("Check In/Check Out");
        changeCheckIn.setPreferredSize(new Dimension(200, 100));
        changeCheckIn.setBounds(500, 850, 200, 100);
        addActionCheckIn(changeCheckIn);
        panel.add(changeCheckIn);
    }

    private void updateRoomGUI(int floor, int room, JLabel custName, JLabel startDate, JLabel endDate, JLabel checkedIn)
    {
        if(hotel.getRoom(floor, room).isBooked() == true)
        {
            custName.setText("Customer Name: " + hotel.getRoom(floor, room).getName());
            startDate.setText("Start Date: " + dateToString(hotel.getRoom(floor, room).getStartDate()));
            endDate.setText("End Date: " + dateToString(hotel.getRoom(floor, room).getEndDate()));
            checkedIn.setText("Check In Status: " + checkInBoolToString(hotel.getRoom(floor, room).isCheckedIn()));
        }
        else
        {
            custName.setText("Customer Name: ");
            startDate.setText("Start Date: ");
            endDate.setText("End Date: ");
            checkedIn.setText("Check In Status: ");
        }

    }


    private void addActionRoomButton(JButton button, int floor, int room, JLabel custName, JLabel startDate, JLabel endDate, JLabel checkedIn)
    {
        button.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        updateRoomGUI(floor, room, custName, startDate, endDate, checkedIn);
                    }
                }
                );
    }

    private void makeBooking(JLabel custName, JLabel startDateLabel, JLabel endDateLabel, JLabel checkedIn)
    {
        JFrame box = new JFrame();

        JTextField roomNumber = new JTextField(40);
        JTextField name = new JTextField(40);
        JTextField dateOfBirth = new JTextField(40);
        JTextField address = new JTextField(40);
        JTextField start = new JTextField(40);
        JTextField end = new JTextField(40);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Room Number:"));
        myPanel.add(roomNumber);
        myPanel.setLayout(new GridLayout(0,1));
        myPanel.add(new JLabel("Name:"));
        myPanel.add(name);
        myPanel.add(new JLabel("Date of Birth (MMDDYYYY):"));
        myPanel.add(dateOfBirth);
        myPanel.add(new JLabel("Address:"));
        myPanel.add(address);
        myPanel.add(new JLabel("Start Date (MMDDYYYY):"));
        myPanel.add(start);
        myPanel.add(new JLabel("End Date (MMDDYYYY):"));
        myPanel.add(end);

        int result = JOptionPane.showConfirmDialog(box, myPanel,
                "Please Enter Reservation Information", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION)
        {
            int floorNum = Integer.valueOf(roomNumber.getText().substring(0, 1)) - 2;
            int roomNum = Integer.valueOf(roomNumber.getText().substring(1, 3)) - 1;
            Date birthday = new Date(
                    Integer.parseInt(dateOfBirth.getText().substring(0, 2)),
                    Integer.parseInt(dateOfBirth.getText().substring(2, 4)),
                    Integer.parseInt(dateOfBirth.getText().substring(4, 8)));
            Date startDate = new Date(
                    Integer.parseInt(start.getText().substring(0, 2)),
                    Integer.parseInt(start.getText().substring(2, 4)),
                    Integer.parseInt(start.getText().substring(4, 8)));
            Date endDate = new Date(
                    Integer.parseInt(end.getText().substring(0, 2)),
                    Integer.parseInt(end.getText().substring(2, 4)),
                    Integer.parseInt(end.getText().substring(4, 8)));

            hotel.getRoom(floorNum, roomNum).bookRoom(name.getText(), birthday, address.getText(), startDate, endDate);
            updateRoomGUI(floorNum, roomNum, custName, startDateLabel, endDateLabel, checkedIn);
        }
    }

    private void addActionMakeBooking(JButton button, JLabel custName, JLabel startDate, JLabel endDate, JLabel checkedIn)
    {
        button.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        makeBooking(custName, startDate, endDate, checkedIn);
                    }
                }
                );
    }

    private void changeCheckIn()
    {
        JFrame box = new JFrame();
        String newData = JOptionPane.showInputDialog(box, "Which room would you like to Check In/Check Out?: ");


        if(newData != null)
        {
            int floor = Integer.parseInt(newData.substring(0, 1)) - 2;
            int room = Integer.parseInt(newData.substring(1, 3)) - 1;

            if(hotel.getRoom(floor, room).isBooked() == true)
            {
                if(hotel.getRoom(floor, room).isCheckedIn() == false)
                {
                    hotel.getRoom(floor, room).checkIn();
                }
                else
                {
                    hotel.getRoom(floor, room).checkOut();
                }
            }

            //checkIn.setText(checkInBoolToString(!hotel.getRoom(floor, room).isCheckedIn()));
        }
    }

    private void addActionCheckIn(JButton button)
    {
        button.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        changeCheckIn();
                    }
                }
                );
    }

    private String checkInBoolToString(boolean bool)
    {
        String string = null;

        if(bool == true)
        {
            string = "Checked in";
        }
        else
        {
            string = "Not checked in";
        }

        return string;
    }


    private String dateToString(Date date)
    {
        String month = (new DateFormatSymbols().getMonths()[date.getMonth() - 1]);
        String day = Integer.toString(date.getDay());
        String year = Integer.toString(date.getYear());

        return month + " " + day + " " + year;
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