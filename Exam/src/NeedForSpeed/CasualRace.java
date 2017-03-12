package NeedForSpeed;

import java.util.List;
import java.util.stream.Collectors;

public class CasualRace extends Race {
    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }



    @Override
    public String toString(){
        super.setClosed(true);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %s%n", super.getRoute(), super.getLength()));

        List<Car> sortedCars = super.getParticipants().values().stream().sorted((a, b) ->
                Long.compare(b.getOverallPerformance(), a.getOverallPerformance()))
                .collect(Collectors.toList());

        for (int i = 0; i < sortedCars.size(); i++) {
            int moneyWon = 0;
            switch (i){
                case 0:
                    moneyWon = (super.getPrizePool() * 50) / 100;
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
                default:
                    break;
            }
        }
        return sb.toString();
    }

}
