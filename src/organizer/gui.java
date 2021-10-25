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
        };
         
        final Class[] columnClass = new Class[] {
            String.class, String.class, String.class, String.class, String.class
        };
        //create table model with data
        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
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
        JButton button1 = new JButton("Add blank");
        button1.addActionListener(new ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name = JOptionPane.showInputDialog(button1,
                        "Assignment name:", null);
                System.out.println(name);
                String date = JOptionPane.showInputDialog(button1,
                        "Due date:", null);
                System.out.println(date);
                String className = JOptionPane.showInputDialog(button1,
                        "Class name:", null);
                System.out.println(className);
                String status = JOptionPane.showInputDialog(button1,
                        "Status:", null);
                System.out.println(status);
                String info = JOptionPane.showInputDialog(button1,
                        "Extra info:", null);
                System.out.println(info);
            }
        });
        
        //----
        JPanel southPanel = new JPanel();
        southPanel.add(button1);
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