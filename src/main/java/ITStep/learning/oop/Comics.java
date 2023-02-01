package ITStep.learning.oop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comics extends Literature {
    private int number;
    private Date date;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.y");
    public Comics( String title, int number, String  date) throws ParseException {
        super.setTitle(title);
        this.number = number;
        this.date = dateFormat.parse(date);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("Comics: %s No%d (%s)", super.getTitle(),
                this.number, dateFormat.format(this.date));
    }
}
