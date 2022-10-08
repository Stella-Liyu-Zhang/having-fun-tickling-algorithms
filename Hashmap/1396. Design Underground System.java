class UndergroundSystem {
    private final String DELIMETER = ",";

    private Map<Integer, Event> arrivals;
    private Map<String, Average> averages;

    public UndergroundSystem() {
        arrivals = new HashMap<>();
        averages = new HashMap<>();
    }

    // Check in
    public void checkIn(int id, String stationName, int t) {
        arrivals.put(id, new Event(id, stationName, t));

    }

    // check out
    public void checkOut(int id, String stationName, int t) {
        Event arrivalEvent = arrivals.get(id);
        arrivals.remove(id);

        int diff = t - arrivalEvent.time;

        String key = arrivalEvent.stationName + DELIMETER + stationName;

        Average average = averages.containsKey(key) ? averages.get(key) : new Average();
        average.updateAverage(diff);
        averages.put(key, average);

    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + DELIMETER + endStation;
        if (averages.containsKey(key)) {
            return averages.get(key).getAverage();
        } else {
            return -1;
        }

    }

    class Event {
        public int id;
        public String stationName;
        public int time;

        public Event(int id, String stationName, int time) {
            this.id = id;
            this.stationName = stationName;
            this.time = time;
        }
    }

    class Average {
        public double total = 0;
        public int count = 0;

        public void updateAverage(int diff) {
            count++;
            total += diff;
        }

        public double getAverage() {
            return total / count;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */