
public class LinearEq extends Question {
    LinearEq() {
      super();
      this.setLabel(generateProblem1());
    }
    
    public String generateProblem1() {
        return "<html>Solve " + equationGen((int) (Math.random()*3) + 1) + ". <br>Round your answer to three decimal places or express your answer as a fraction.</html>";
    }

    public String equationGen(int num) {
        double a,b,c;
        a = b = c = 0;

        //ensures coefficients can't be equal to zero, to each other to avoid division by zero errors, and to each other's absolute value to avoid untrue expressions like 0 = -2
        while (a == 0 || b == 0 || c == 0 || (Math.abs(a) == Math.abs(b)) || (Math.abs(b) == Math.abs(c)) || (Math.abs(a) == Math.abs(c))) {
            a = (int) (Math.random() * 10) - 5;
            b = (int) (Math.random() * 10) - 5;
            c = (int) (Math.random() * 10) - 5;
        }

        //generates a preset equation based off a randomly generated number and sets the answer variable to the calculated answer based off that equation
        if (num == 1) {
            setAnswer(Double.parseDouble(getDFormatter().format((c - a) / b)));
            return a + " + " + b + "x = " + c;
        } else if (num == 2) {
            setAnswer(Double.parseDouble(getDFormatter().format(-b / (a + c))));
            return a + "x + " + b + " + " + c + "x = 0";
        } else if (num == 3) {
            setAnswer(Double.parseDouble(getDFormatter().format((c - a) / (a * b))));
            return b + "(" + a + ")x + " + a + " = " + c;
        } else { //just in case a bug happens
            return "An error has occurred. Please email nguyenbriankhoi3238@students.esuhsd.org to report this bug and try again later.";
        }
    }
}
