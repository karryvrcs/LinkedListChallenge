package dev.lpa;

public class Places {
    private String town;
    private int distance;

    public Places(String town, int distance) {
        this.town = town;
        this.distance = distance;
    }

    public String getTown() {
        return town;
    }

    public int getDistance() {
        return distance;
    }
}
