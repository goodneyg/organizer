package organizer;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;

public class gui extends JFrame
{
    public gui()
    {
        //headers for the table
        String[] columns = new String[] {
            "Name", "Date", "Class", "Progress", "Info"
        };
         
        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
            {"hw1", "2/3/4", "acc", "in-prog", "online" },
            {"hw2", "3/5/2", "econ", "done", "in notebook" },
            {"hw3", "8/7/5", "compsci", "not started", "online" },
            {"", "", "", "", "" }
        };
        
       
        
        Class[] columnClass = new Class[] {
            String.class, String.class, String.class, String.class, String.class
        };
        //create table model with data
        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return true;
            }
            @Override
            public Class<?> getColumnClass(int columnIndex)
            {
                return columnClass[columnIndex];
            }
            
        };
        
        JTable table = new JTable(model);
        
       
        //add the table to the frame
        this.add(new JScrollPane(table));
         
        this.setTitle("Organizer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
        //----
        JButton button1 = new JButton("Add assignment");
        button1.addActionListener(new ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name = JOptionPane.showInputDialog(button1,
                        "Assignment name:", null);
                //this is where some code would go
                System.out.println("Assignment name:" +name);
                String date = JOptionPane.showInputDialog(button1,
                        "Due date:", null);
                System.out.println("Due date:" +date);
                String className = JOptionPane.showInputDialog(button1,
                        "Class name:", null);
                System.out.println("Class name:" +className);
                String status = JOptionPane.showInputDialog(button1,
                        "Status:", null);
                System.out.println("Status:" +status);
                String info = JOptionPane.showInputDialog(button1,
                        "Extra info:", null);
                System.out.println("Extra info:" +info);
            }
        });
        
        JButton button2 = new JButton("Info/Debug");
        button2.addActionListener(new ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
                String infoPannel = JOptionPane.showInputDialog(button2,
                        "this is an info pane", null);
                System.out.println("debug" +infoPannel);
                data[1][1] = "test";
                
                System.out.println(Arrays.deepToString(data));
                
        	}
        });
        
        //----
        JPanel southPanel = new JPanel();
        southPanel.add(button1);
        southPanel.add(button2);
        add(southPanel, BorderLayout.SOUTH);
    }
    
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new gui();
            }
        });
    }   
}