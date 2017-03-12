package NeedForSpeed;

import java.util.List;
import java.util.stream.Collectors;

public class CircuitRace extends Race{
    private int laps;
    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.setLaps(laps);
    }

    private void setLaps(int laps) {
        this.laps = laps;
    }
    
    private void decreaseDurability(){
        for (Integer id : super.getParticipants().keySet()) {
            super.getParticipants().get(id).decreaseDurability(laps, super.getLength());
        }
    }

    @Override
    public String toString(){
        decreaseDurability();
        super.setClosed(true);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %s%n", super.getRoute(), super.getLength() * this.laps));

        List<Car> sortedCars = super.getParticipants().values().stream().sorted((a, b) ->
                Long.compare(b.getOverallPerformance(), a.getOverallPerformance()))
                .collect(Collectors.toList());

        for (int i = 0; i < sortedCars.size(); i++) {
            int moneyWon = 0;
            switch (i){
                case 0:
                    moneyWon = (super.getPrizePool() * 40) / 100;
                    sb.append(String.format("%d. %s %s %dPP - $%d", i+1, sortedCars.get(i).getBrand(),
                            sortedCars.get(i).getModel(), sortedCars.get(i).getOverallPerformance(), moneyWon));
                    break;
                case 1:
                    moneyWon = (super.getPrizePool() * 30) / 100;
                    sb.append(String.format("%n%d. %s %s %dPP - $%d", i+1, sortedCars.get(i).getBrand(),
                            sortedCars.get(i).getModel(), sortedCars.get(i).getOverallPerformance(), moneyWon));
                    break;
                case 2:
                    moneyWon = (super.getPrizePool() * 20) / 100;
                    sb.append(String.format("%n%d. %s %s %dPP - $%d", i+1, sortedCars.get(i).getBrand(),
                            sortedCars.get(i).getModel(), sortedCars.get(i).getOverallPerformance(), moneyWon));
                    break;
                case 3:
                    moneyWon = (super.getPrizePool() * 10) / 100;
                    sb.append(String.format("%n%d. %s %s %dPP - $%d", i+1, sortedCars.get(i).getBrand(),
                            sortedCars.get(i).getModel(), sortedCars.get(i).getOverallPerformance(), moneyWon));
                    break;
                default:
                    break;
            }
        }
        return sb.toString();
    }
}
