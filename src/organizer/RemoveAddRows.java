package organizer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

public class RemoveAddRows extends JFrame {

    private Object[] columnNames = {"Name", "Date", "Class", "Progress", "Info"};
    private Object[][] data = {
        {"hw1", "2/3/4", "acc", "in-prog", "online" },
        {"hw2", "3/5/2", "econ", "done", "in notebook" },
        {"hw3", "8/7/5", "compsci", "not started", "online" },
    };
    private JTable table;
    private DefaultTableModel model;
    private javax.swing.Timer timer = null;

    public RemoveAddRows() {
        model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        table = new JTable(model) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (isRowSelected(row) && isColumnSelected(column)) {
                    ((JComponent) c).setBorder(new LineBorder(Color.red));
                }
                return c;
            }
        };
        ListSelectionModel rowSelMod = table.getSelectionModel();
        rowSelMod.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                String str = "Selected Row(s): ";
                int[] rows = table.getSelectedRows();
                for (int i = 0; i < rows.length; i++) {
                    str += rows[i] + " ";
                }
                str += "Selected Column(s): ";
                int[] cols = table.getSelectedColumns();
                for (int i = 0; i < cols.length; i++) {
                    str += cols[i] + " ";
                }
                str += "Selected Cell: " + table.getSelectedRow() + ", " + table.getSelectedColumn();
                System.out.println(str);
                Object value = table.getValueAt(row, col);
                System.out.println(String.valueOf(value));
            }
        });
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        JButton button1 = new JButton("Remove all rows");
        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                if (model.getRowCount() > 0) {
                    for (int i = model.getRowCount() - 1; i > -1; i--) {
                        model.removeRow(i);
                    }
                }
                System.out.println("model.getRowCount() --->" + model.getRowCount());
            }
        });
        JButton button2 = new JButton("Add blank");
        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                start();
            }
        });
        JPanel southPanel = new JPanel();
        southPanel.add(button1);
        southPanel.add(button2);
        add(southPanel, BorderLayout.SOUTH);
    }

    private void start() {
        timer = new javax.swing.Timer(1, updateCol());
        timer.start();
    }


    public Action updateCol() {
        return new AbstractAction("text load action") {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                Object[] data0 = {"", "", "", "", ""};
                model.addRow(data0);
                timer.stop();
            }
        };
    }

    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                RemoveAddRows frame = new RemoveAddRows();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
