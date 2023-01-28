package ITStep.learning.oop;


import java.time.LocalDate;
import java.util.Date;


public class Newspaper extends Literature{
    LocalDate date = LocalDate.now(); // получаем текущую дату
    int year = date.getYear();
    int month = date.getMonthValue();
    int dayOfMonth = date.getDayOfMonth();

    public Newspaper(int year, int month, int dayOfMonth, String title) {
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        super.setTitle(title);
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return  super.getTitle() + " (" +  this.year + "/" + this.month + "/" + this.dayOfMonth+ ")" ;
    }
}
