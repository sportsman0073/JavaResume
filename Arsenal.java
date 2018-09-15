public class Arsenal {
    private Equipment equipment;
    private SuperPowers superPowers;
    public Arsenal(Equipment equipment, SuperPowers superPowers){
        this.equipment = equipment;
        this.superPowers = superPowers;
    }

    public void setEquips(Equipment equipment) {
        this.equipment = equipment;
    }

    public void setSuperPowers(SuperPowers superPowers) {
        this.superPowers = superPowers;
    }

    public Equipment getEquips() {
        return this.equipment;
    }

    public SuperPowers getSuperPowers() {
        return this.superPowers;
    }
}
