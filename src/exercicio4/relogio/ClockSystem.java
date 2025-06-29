package exercicio4.relogio;

public class ClockSystem {

    public static void main(String[] args) {
        Clock brlclock = new BRLClock();
        brlclock.setHour(25);
        brlclock.setMinute(0);
        brlclock.setSecond(25);

        System.out.println(brlclock.getTime());

        System.out.println(new USClock().convert(brlclock).getTime());
    }

}
