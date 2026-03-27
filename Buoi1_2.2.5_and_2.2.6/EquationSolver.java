import javax.swing.JOptionPane;

public class EquationSolver {
    public static void main(String[] args) {
        String strA = JOptionPane.showInputDialog(null, "Solve ax + b = 0\nEnter a:");
        double a = Double.parseDouble(strA);
        
        String strB = JOptionPane.showInputDialog(null, "Enter b:");
        double b = Double.parseDouble(strB);

        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "Infinitely many solutions!");
            } else {
                JOptionPane.showMessageDialog(null, "No solution!");
            }
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "Solution x = " + x);
        }
        System.exit(0);
    }
}