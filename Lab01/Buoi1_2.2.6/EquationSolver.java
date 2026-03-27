import javax.swing.JOptionPane;

public class EquationSolver {
    public static void main(String[] args) {
        String menu = "Choose equation type:\n"
                    + "1. Linear equation (ax + b = 0)\n"
                    + "2. Linear system (2 variables)\n"
                    + "3. Quadratic equation (ax^2 + bx + c = 0)";
        String choice = JOptionPane.showInputDialog(null, menu);

        if (choice.equals("1")) {
            double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
            double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));
            if (a == 0) {
                JOptionPane.showMessageDialog(null, b == 0 ? "Infinite solutions" : "No solution");
            } else {
                JOptionPane.showMessageDialog(null, "x = " + (-b / a));
            }
        } 
        else if (choice.equals("2")) {
            double a11 = Double.parseDouble(JOptionPane.showInputDialog("a11:"));
            double a12 = Double.parseDouble(JOptionPane.showInputDialog("a12:"));
            double b1 = Double.parseDouble(JOptionPane.showInputDialog("b1:"));
            double a21 = Double.parseDouble(JOptionPane.showInputDialog("a21:"));
            double a22 = Double.parseDouble(JOptionPane.showInputDialog("a22:"));
            double b2 = Double.parseDouble(JOptionPane.showInputDialog("b2:"));

            double D = a11 * a22 - a21 * a12;
            double D1 = b1 * a22 - b2 * a12;
            double D2 = a11 * b2 - a21 * b1;

            if (D != 0) {
                JOptionPane.showMessageDialog(null, "x1 = " + (D1 / D) + ", x2 = " + (D2 / D));
            } else {
                JOptionPane.showMessageDialog(null, (D1 == 0 && D2 == 0) ? "Infinite solutions" : "No solution");
            }
        } 
        else if (choice.equals("3")) {
            double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
            double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));
            double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c:"));

            if (a == 0) {
                JOptionPane.showMessageDialog(null, "Not a quadratic equation!");
            } else {
                double delta = b * b - 4 * a * c;
                if (delta < 0) JOptionPane.showMessageDialog(null, "No real roots");
                else if (delta == 0) JOptionPane.showMessageDialog(null, "x = " + (-b / (2 * a)));
                else {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    JOptionPane.showMessageDialog(null, "x1 = " + x1 + ", x2 = " + x2);
                }
            }
        }
        System.exit(0);
    }
}