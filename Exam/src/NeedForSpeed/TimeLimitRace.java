package NeedForSpeed;

public class TimeLimitRace extends Race {
    private long goldTime;
    private Car participant;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.setGoldTime(goldTime);
    }

    private void setGoldTime(int goldTime) {
        this.goldTime = goldTime;
    }

    @Override
    public void addParticipant(int id, Car car){
        if (!car.isParked() && this.participant == null) {
            car.setRacing(true);
            this.participant = car;
        }
        super.addParticipant(id, car);
    }

    private long calcTimePerf(){
        return super.getLength() * ((this.participant.getHorsepower() / 100) * this.participant.getAcceleration());
    }

    private String calcClassification(){
        if (calcTimePerf() <= this.goldTime){
            return "Gold";
        }else if (calcTimePerf() <= (this.goldTime+15)){
            return "Silver";
        }else {
            return "Bronze";
        }
    }

    private int calcMoney(){
        String title = calcClassification();
        if (title.equals("Gold")){
            return super.getPrizePool();
        }else if (title.equals("Silver")){
            return (super.getPrizePool() * 50) / 100;
        }else {
            return (super.getPrizePool() * 30) / 100;
        }
    }


    @Override
    public String toString() {
        super.setClosed(true);
        long timePerformance = calcTimePerf();
        String classification = calcClassification();
        long money = calcMoney();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %s%n", super.getRoute(), super.getLength()));
        sb.append(String.format("%s %s - %d s.%n", this.participant.getBrand(), this.participant.getModel(),
                timePerformance));
        sb.append(String.format("%s Time, $%d.", classification, money));

        return sb.toString();
    }
}
