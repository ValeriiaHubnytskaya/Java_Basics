package ITStep.learning.oop;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Newspaper extends Literature implements Printed{
    private Date date;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.y");

    public Newspaper(String date, String title) throws ParseException {
        super.setTitle(title);
        this.date = dateFormat.parse(date);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return  String.format("Newspaper: %s  (%s)", super.getTitle(),
                 dateFormat.format(this.date));
    }
}
