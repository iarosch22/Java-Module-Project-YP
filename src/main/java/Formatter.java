public class Formatter {
    String roublesFormat;
    double paid;

    public String formatPaid(double paid) {
        this.paid = Math.floor(paid) % 10;

        if (this.paid == 1.0) {
            this.roublesFormat = "рублю";
        } else if (this.paid > 1.0 && this.paid <= 4.0) {
            this.roublesFormat = "рубля";
        } else {
            this.roublesFormat = "рублей";
        }

        return String.format("%.2f " + this.roublesFormat, paid);
    }
}
