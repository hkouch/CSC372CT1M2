import javax.swing.*;
import java.awt.event.*;

//Main class extending JFrame for GUI application
public class Main extends JFrame implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private double balance;

    //Constructor to initialize the GUI components
    public Main() {
        setTitle("Bank Balance App");
        setSize(400, 300);
        //Allow for the window listener to monitor when the user presses the X button
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //Add a window listener to handle closing events
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                displayFinalBalance();
                System.exit(0);
            }
        });

        //Create a JPanel to hold the buttons
        JPanel panel = new JPanel();
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton displayButton = new JButton("Display Balance");

        //ActionListener for the Deposit button
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String depositAmount = JOptionPane.showInputDialog("Enter deposit amount:");
                double deposit = Double.parseDouble(depositAmount);
                balance += deposit;
            }
        });

        //ActionListener for the Withdraw button
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String withdrawAmount = JOptionPane.showInputDialog("Enter withdraw amount:");
                double withdraw = Double.parseDouble(withdrawAmount);
                balance -= withdraw;
            }
        });

        //ActionListener for the Display Balance button
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Current Balance: $" + String.format("%.2f", balance));
            }
        });

        //Add buttons to the panel
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(displayButton);

        //Add the panel to the JFrame
        add(panel);
    }

    //Method to display the final balance in a JOptionPane
    private void displayFinalBalance() {
        JOptionPane.showMessageDialog(null, "Final Balance: $" + String.format("%.2f", balance));
    }

    //Main method to create an instance of the Main class and make it visible
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}