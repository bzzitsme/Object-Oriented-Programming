package Main;

public class Time {
    private int hour, minute, second;

    private Time() {

    }

    private Time(int hour, int minute, int second) {
        if (hour < 24 && minute < 60 && second < 60) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
    }

    private String toUniversal() {
        String hour = (this.hour < 10) ? "0" : "";
        hour += this.hour;

        String minute = (this.minute < 10) ? "0" : "";
        minute += this.minute;

        String second = (this.second < 10) ? "0" : "";
        second += this.second;

        return hour + ":" + minute + ":" + second;
    }

    private String toStandard() {
        String state = (this.hour < 12) ? "AM" : "PM";
        return toUniversal() + " " + state;
    }

    private void add(Time time) {
        int minute = (this.second + time.second) / 60;
        int hour = (this.minute + time.minute + second) / 60;

        this.second = (this.second + time.second) % 60;
        this.minute = (this.minute + time.minute + minute) % 60;
        this.hour = (this.hour + time.hour + hour) % 24;
    }

    public static void main(String[] args) {
        Time t = new Time(23, 5, 6);

        System.out.println(t.toUniversal());
        System.out.println(t.toStandard());

        Time t2 = new Time(4, 23, 33);
        t.add(t2);

        System.out.println(t.toUniversal());
        System.out.println(t.toStandard());
    }
}
