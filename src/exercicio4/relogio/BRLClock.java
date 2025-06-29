package exercicio4.relogio;

public non-sealed class BRLClock extends Clock {

    @Override
    public Clock convert(Clock clock) {
        switch (clock){
            case USClock usClock -> {
                this.second = usClock.getSecond();
                this.minute = usClock.getMinute();
                this.hour = (usClock.getPeriodIndicator().equals("PM")) ?
                        usClock.getHour() + 12 :
                        usClock.getHour();
            }
            case BRLClock brlClock -> this.hour = brlClock.getHour();
        }
        return this;
    }
}
