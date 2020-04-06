import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class main
{
    public static void main(String args[])
    {
    	try {
        Hotel hotel = new Hotel();
    	} catch (Exception input) {
    		System.out.println(input);
        }
        
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                GUI.createAndShowGUI();
            }
        });
    }
}
