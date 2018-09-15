public class Equipment {
    private String weapon;
    private String vehicle;
    public Equipment(String weapon, String vehicle){
        this.weapon = weapon;
        this.vehicle = vehicle;
    }

    public String getWeapon() {
        return this.weapon;
    }

    public String getVehicle() {
        return this.vehicle;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
}
