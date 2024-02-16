import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private double balance;

    public Main() {
        setTitle("Bank Balance App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                displayFinalBalance();
                System.exit(0);
            }
        });

        JPanel panel = new JPanel();
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton displayButton = new JButton("Display Balance");

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String depositAmount = JOptionPane.showInputDialog("Enter deposit amount:");
                double deposit = Double.parseDouble(depositAmount);
                balance += deposit;
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String withdrawAmount = JOptionPane.showInputDialog("Enter withdraw amount:");
                double withdraw = Double.parseDouble(withdrawAmount);
                balance -= withdraw;
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Current Balance: $" + String.format("%.2f", balance));
            }
        });

        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(displayButton);

        add(panel);
    }

    private void displayFinalBalance() {
        JOptionPane.showMessageDialog(null, "Final Balance: $" + String.format("%.2f", balance));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
