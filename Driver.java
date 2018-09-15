import java.io.*;
import java.util.*;
import java.net.URL;

public class Driver {
    private ArrayList<SuperHero> heroList = new ArrayList<>();
    private ArrayList<SuperHero> marvelHeroList = new ArrayList<>();
    private ArrayList<SuperHero> dcHeroList = new ArrayList<>();
    private Arsenal arsenals;
    private Equipment[] equipment;
    private String name;
    private String world;
    private String weapon;
    private String vehicle;
    private String[] powersS;
    private ArrayList power = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public Driver(){
    }

//    public Driver(String world, String name, String weapon, String vehicle, ArrayList powers){
//        this.name = name;
//        this.world = world;
//        this.weapon = weapon;
//        this.vehicle = vehicle;
//        this.power = powers;
//    }
    public void addHero(){
        String powers = "";
            System.out.println("Enter world:");
            this.world = scanner.nextLine();
            System.out.println("Enter name:");
            this.name = scanner.nextLine();
        for (int i = 0; i < heroList.size(); i++) {
            if (heroList.get(i).getName().equals(name)) {
                return;
            }
        }
            System.out.println("Enter weapon:");
            this.weapon = scanner.nextLine();
            System.out.println("Enter vehicle:");
            this.vehicle = scanner.nextLine();

            power.clear();
        do {
            System.out.println("Enter powers:");
            powers = scanner.nextLine();
            power.add(powers);
        }while(!powers.equals(""));

        power.remove(powers);
        Equipment equipment = new Equipment(weapon,vehicle);
        String[] temp = new String[power.size()];
        powersS = (String[]) power.toArray(temp);
//        SuperPowers powers = new SuperPowers(power);
        Arsenal arsenals = new Arsenal(equipment, new SuperPowers(powersS));
        SuperHero superHeroes;

        if (world.equalsIgnoreCase("Marvel")) {
            superHeroes = new Marvel(arsenals,name);
        } else {
            superHeroes = new DC(arsenals,name);
        }

        heroList.add(superHeroes);
//        if(world.equals("DC Univers")){
//            dcHeroList.add(superHeroes);
//        }else if(world.equals("Marvel")){
//            marvelHeroList.add(superHeroes);
//        }
        System.out.println(name+ "added.");
    }
    public void modifyHero(String name){
        int count = 0;
        String powers = "";
        if(heroList != null) {
            for (int i = 0; i < heroList.size(); i++) {
                if (name != null && heroList.get(i).getName().equals(name)) {
                    System.out.printf("1 - Change weapon:\n" +
                            "2 - Change vehicle:\n" +
                            "3 - Change powers:\n");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 1) {
                        System.out.println("Enter a new weapon");
                        String newWeapon = scanner.nextLine();
                        heroList.get(i).getArsenal().getEquips().setWeapon(newWeapon);
                    } else if (choice == 2) {
                        System.out.println("Enter a new vehicle");
                        String newVehicle = scanner.nextLine();
                        heroList.get(i).getArsenal().getEquips().setVehicle(newVehicle);
                    } else if (choice == 3) {
                        power.clear();
                        do {
                            System.out.println("Enter powers: ");
                            powers = scanner.nextLine();
                            power.add(powers);
                        } while (!powers.equals(""));
                        power.remove(powers);
                        String[] temp = new String[power.size()];
                        String[] powersS = (String[]) power.toArray(temp);
                        heroList.get(i).getArsenal().setSuperPowers(new SuperPowers(powersS));
                    }

//                    Equipment equipment = new Equipment(weapon, vehicle);
//                    String[] temp = new String[power.size()];
//                    String[] powersS = (String[]) power.toArray(temp);
//        SuperPowers powers = new SuperPowers(power);
//                    Arsenal arsenals = new Arsenal(equipment, new SuperPowers(powersS));
//                    SuperHero superHeroes = new SuperHero(arsenals, name);
                        return;
                }
            }
            System.out.println("No hero in the list goes by that name.");
        }
    }
    public void removeHero(String name) {
        for (int i = 0; i < heroList.size(); i++) {
            if (heroList.get(i).getName().equals(name)) {
//                int t = heroList.indexOf(name);
                heroList.remove(i);
            }
//            for (int j = 0; j < marvelHeroList.size(); j++) {
//                if (marvelHeroList.get(j).getName().equals(name)) {
//                    marvelHeroList.remove(j);
//
//                }
//            }
//            for (int k = 0; k < dcHeroList.size(); k++) {
//                if (dcHeroList.get(k).getName().equals(name)) {
//                    dcHeroList.remove(k);
//                }
//            }
        }
    }
    public void printDetail(String name){
        for (int i = 0; i < heroList.size(); i++) {
            if (heroList.get(i).getName().equals(name)) {
                int j = heroList.indexOf(name);
                SuperHero hero = heroList.get(i);
                hero.toString();

                if(heroList.get(i) instanceof Marvel){
                    world = "Marvel";
                }else{
                    world = "DC Universe";
                }

                System.out.println("World: "+this.world);
                System.out.println("Name: "+heroList.get(i).getName());
                System.out.println("====== Equipment ======");
                System.out.println("Weapon: "+heroList.get(i).getArsenal().getEquips().getWeapon());
                System.out.println("Vehicle: "+heroList.get(i).getArsenal().getEquips().getVehicle());
                System.out.println("======= Powers ========");
                for (int k = 0; k < heroList.get(i).getArsenal().getSuperPowers().getPowers().length ; k++) {
                    int num = k+1;
                    System.out.println(num+": "+heroList.get(i).getArsenal().getSuperPowers().getPowers()[k]);
                }
            }
        }
    }
    public void printHeroes(){
        System.out.println("====== World: Marvel =======");
        int counter = 1;
        for (int i = 0; i < heroList.size(); i++) {
            if (heroList.get(i) instanceof Marvel) {
                System.out.println((counter++) + ": " + heroList.get(i).getName());
            }
        }
        counter=1;
        System.out.println("==== World: DC Universe ====");

        for (int i = 0; i < heroList.size(); i++) {
            if (heroList.get(i) instanceof DC) {
                System.out.println((counter++) + ": " + heroList.get(i).getName());
            }
        }


//            heroList instanceof  ? ((world) heroList) : null;


//        for (int i = 0; i < marvelHeroList.size(); i++) {
//            int placement = i+1;
//            System.out.println(placement +": "+ marvelHeroList.get(i).getName());
//        }
//
//        System.out.println("==== World: DC Universe ====");
//        for (int i = 0; i < dcHeroList.size(); i++) {
//            int placement = i+1;
//            System.out.println(placement +": "+dcHeroList.get(i).getName());
//        }


    }
    public void addFromFile(String filename) throws Exception {
        BufferedReader f1 = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = f1.readLine()) != null) {
            String[] people = line.split("\n");
            for (int i = 0; i < people.length; i++) {
                if (!people[i].isEmpty()) {
                    String[] list = people[i].split(":");
                    this.world = list[0].replace(" ", "");
                    String[] makingHero = list[1].split(";");
                    this.name = makingHero[0].substring(1,makingHero[0].length());
                    this.weapon = makingHero[1].substring(1,makingHero[1].length());
                    this.vehicle = makingHero[2].substring(1,makingHero[2].length());
                    String power = makingHero[3].substring(1,makingHero[3].length());
                    this.powersS = power.split(", ");
                    Equipment equipment = new Equipment(weapon, vehicle);
//        SuperPowers powers = new SuperPowers(power);
                    Arsenal arsenals = new Arsenal(equipment, new SuperPowers(powersS));
                    SuperHero superHeroes = new SuperHero(arsenals, name);
                    if (world.equalsIgnoreCase("Marvel")) {
                        superHeroes = new Marvel(arsenals, name);
                    } else {
                        superHeroes = new DC(arsenals, name);
                    }

                    heroList.add(superHeroes);
                }
            }
            //works if have problem could have extra space around words
        }
    }
    public void writeToFile(String filename) throws IOException {
        String[] superPowers;
        String powers = "";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < heroList.size(); i++) {
            superPowers = new String[heroList.get(i).getArsenal().getSuperPowers().getPowers().length];
            if (heroList.get(i) instanceof Marvel){
                world = "Marvel";
            }else{
                world = "DC Universe";
            }


            if (heroList.get(i).getArsenal().getSuperPowers().equals("")) {
                superPowers[0] = "none";
                heroList.get(i).getArsenal().setSuperPowers(new SuperPowers(superPowers));
                powers = "none";
            }

            writer.write(world+": ");
            writer.append(heroList.get(i).getName() + "; ");
            writer.append(heroList.get(i).getArsenal().getEquips().getWeapon() + "; ");
            writer.append(heroList.get(i).getArsenal().getEquips().getVehicle() + "; ");
            powers = "";
            for (int j = 0; j < heroList.get(i).getArsenal().getSuperPowers().getPowers().length; j++) {
                if(j == heroList.get(i).getArsenal().getSuperPowers().getPowers().length-1){
                    powers += heroList.get(i).getArsenal().getSuperPowers().getPowers()[j];
                }else {
                    powers += heroList.get(i).getArsenal().getSuperPowers().getPowers()[j] + ", ";
                }
            }
            writer.append(powers + ";\n");

//            Equipment equipment = new Equipment(weapon, vehicle);
////        SuperPowers powers = new SuperPowers(power);
//            Arsenal arsenals = new Arsenal(equipment, new SuperPowers(powersS));
//            SuperHero superHeroes = new SuperHero(arsenals, name);
//            if (world.equalsIgnoreCase("Marvel")) {
//                superHeroes = new Marvel(arsenals, name);
//            } else {
//                superHeroes = new DC(arsenals, name);
//            }
//            heroList.add(superHeroes);
        }
        writer.close();
        //works but again could be spacing problem with turn in
    }
    public void miner(String world, String input) throws Exception {
        if (world.equals("http://marvel.wikia.com/wiki/Category:Characters")) {
            URL marvel = new URL("http://marvel.wikia.com/wiki/Category:Characters");
            marvel.openStream();
            arsenals = null;
            String hero = "";
            String line = "";
            String time="";
            String openLetter = ("http://marvel.wikia.com/index.php?title=Category:Characters&from=" + input.toUpperCase());
            URL characters = new URL(openLetter);
            String search = "/wiki/";
            String l = "";
            Scanner s = new Scanner(characters.openStream());
            while ((s.hasNextLine())) {
                line = s.nextLine();

                try{
                    if((line.substring(13, 19)).equals(search) || (line.substring(17, 23)).equals(search)){
                       time = line.substring(19,line.length());
                        l = time.substring(time.indexOf(">")+1,time.indexOf("<"));
                        hero = l;
                        name = hero;
                        SuperHero superHero = new SuperHero(arsenals, name);
                        world = "Marvel";
                        if (world.equalsIgnoreCase("Marvel")) {
                            superHero = new Marvel(arsenals, name);
                        } else {
                            superHero = new DC(arsenals, name);
                        }

                        heroList.add(superHero);
                    }
                }catch(StringIndexOutOfBoundsException e){
                }

            }
//
//            name = hero;
//            SuperHero superHero = new SuperHero(arsenals, name);
//            heroList.add(superHero);
//            marvelHeroList.add(superHero);

        }else if(world.equals("http://dc.wikia.com/wiki/Category:Characters")) {
            URL dc = new URL("http://dc.wikia.com/wiki/Category:Characters");
            dc.openStream();
            arsenals = null;
            String hero = "";
            String line = "";
            String time = "";
            String openLetter = ("http://dc.wikia.com/index.php?title=Category:Characters&from=" + input.toUpperCase());
            URL characters = new URL(openLetter);
            String search = "/wiki/";
            String l = "";
            Scanner s = new Scanner(characters.openStream());
            while ((s.hasNextLine())) {
                line = s.nextLine();

                try {
                    if ((line.substring(13, 19)).equals(search)||(line.substring(17, 23)).equals(search)) {
                        time = line.substring(19, line.length());
                        l = time.substring(time.indexOf(">") + 1, time.indexOf("<"));
                        hero = l;
                        name = hero;
                        SuperHero superHero = new SuperHero(arsenals, name);
                        world = "DC Universe";
                        if (world.equalsIgnoreCase("Marvel")) {
                            superHero = new Marvel(arsenals, name);
                        } else {
                            superHero = new DC(arsenals, name);
                        }

                        heroList.add(superHero);
                    }
                } catch (StringIndexOutOfBoundsException e) {
                }
            }
        }
    }
    public ArrayList<SuperHero> getHeroList(){
        return this.heroList;
    }
    public void run() {
        String leave = "y";
        do{
            //Scanner s = new Scanner(System.in);
//            System.out.println("Main Menu:");
            System.out.printf("0 - Hero from the Internet\n" +
                    "1 - Add Hero\n" +
                    "2 - Modify Hero\n" +
                    "3 - Remove Hero\n" +
                    "4 - Print Hero Details\n" +
                    "5 - Print all Heroes\n" +
                    "6 - Read from file\n" +
                    "7 - Write to file\n" +
                    "8 - Exit\n");

                while (!scanner.hasNextInt()) {
                    System.out.printf("0 - Hero from the Internet\n" +
                            "1 - Add Hero\n" +
                            "2 - Modify Hero\n" +
                            "3 - Remove Hero\n" +
                            "4 - Print Hero Details\n" +
                            "5 - Print all Heroes\n" +
                            "6 - Read from file\n" +
                            "7 - Write to file\n" +
                            "8 - Exit\n");
                    scanner.nextLine();
                }

            int menu = scanner.nextInt();
                scanner.nextLine();

            if(menu==0){
                System.out.println("Enter a Super Hero world");
                String newWorld = scanner.nextLine();
                if(newWorld.equals("Marvel")){
                    System.out.println("Enter the first Character of the hero");
                    String firstChar = scanner.nextLine();
                    String website = "http://marvel.wikia.com/wiki/Category:Characters";
                    try {
                        miner(website,firstChar);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else if (newWorld.equals("DC Universe")){
                    System.out.println("Enter the first Character of the hero");
                    String firstChar = scanner.nextLine();
                    String website = "http://dc.wikia.com/wiki/Category:Characters";
                    try {
                        miner(website, firstChar);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            } else if(menu == 1){
                addHero();
            }else if(menu == 2){
                System.out.println("Enter Hero Name:");
                String modifyHeroName = scanner.nextLine();
                modifyHero(modifyHeroName);
            }
            else if(menu == 3){
                System.out.println("Enter Hero Name:");
                String badHero = scanner.nextLine();
                removeHero(badHero);
            }else if(menu == 4){
                System.out.println("Enter Hero Name:");
                String heroName = scanner.nextLine();
                printDetail(heroName);
            }else if(menu == 5){
                printHeroes();
            }else if(menu == 6){
                System.out.println("Enter a Filename:");
                String file = scanner.nextLine();
                try {
                    addFromFile(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else if(menu == 7){
                System.out.println("Enter a Filename:");
                String file = scanner.nextLine();
                try {
                    writeToFile(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            } else if(menu == 8){
                return;
            }
            System.out.println("Return to menu? (y/n)");
            leave = scanner.nextLine();


        }while(leave.equals("y"));


    }
    public static void main(String[] args) throws Exception {
        Driver t = new Driver();
        try{
            t.run();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}