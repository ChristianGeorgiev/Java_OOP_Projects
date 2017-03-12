package NeedForSpeed;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private Map<Integer, Car> participants;
    private boolean isClosed;

    protected Race(int length, String route, int prizePool) {
        this.setLength(length);
        this.setRoute(route);
        this.setPrizePool(prizePool);
        this.participants = new LinkedHashMap<>();
        this.isClosed = false;
    }

    protected void addParticipant(int id, Car car){
        if (!car.isParked()) {
            car.setRacing(true);
            this.participants.put(id, car);
        }
    }

    protected Map<Integer, Car> getParticipants(){
        return Collections.unmodifiableMap(this.participants);
    }

    protected int getLength() {
        return this.length;
    }

    private void setLength(int length) {
        this.length = length;
    }

    protected String getRoute() {
        return this.route;
    }

    private void setRoute(String route) {
        this.route = route;
    }

    protected int getPrizePool(){
        return this.prizePool;
    }

    private void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }

    protected boolean isClosed() {
        return this.isClosed;
    }

    protected void setClosed(boolean closed) {
        isClosed = closed;
    }



}
