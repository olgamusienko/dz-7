public enum SolarSystem {
    MERCURY( 0, 15),
    VENUS( 5, 6 ),
    EARTH(2, 5),
    MARS(10, 4),
    JUPITER(5, 10),
    SATURN(3, 12),
    URANUS(11, 3),
    NEPTUNE(25, 12),
    PLUTO(28, 50);


    private final int distanceFromPreviousPlanet;

    private final int radius;



    SolarSystem(int distanceFromPreviousPlanet, int radius){
        this.distanceFromPreviousPlanet = distanceFromPreviousPlanet;
        this.radius = radius;
    }

    public int getIdNumber(){
        return this.ordinal();
    }

    public int getDistanceFromPreviousPlanet(){
        return this.distanceFromPreviousPlanet;
    }

    public int getRadius(){
        return this.radius;
    }

    public SolarSystem previousPlanet(){
        SolarSystem[] planets = SolarSystem.values();
        if (this.ordinal() == 0){
            return null;
        }
        return planets[this.ordinal() - 1];

    }

    public SolarSystem nextPlanet() {
        SolarSystem[] planets = SolarSystem.values();
        int nextIndex = this.ordinal() + 1;
        if (nextIndex == planets.length) {
            return null;
        }
        return planets[nextIndex];
    }

    public int distanceFromSun(){
        SolarSystem[] planets = SolarSystem.values();
        int totalDistance = 0;
        for (int i = 0; i < this.ordinal()+1; i++){
            totalDistance += planets[i].getDistanceFromPreviousPlanet() + 2*planets[i].getRadius();
        }
        totalDistance -= 2 * this.getRadius();
        return totalDistance;
    }


}


