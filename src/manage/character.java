package manage;
import java.util.Random;

public class character{

    public String name;
    private String status;
    public int hp;
<<<<<<< HEAD
    private int critChange;
    private int dodgeChance;
    private int resistChance;
=======
    public int critChange;
    public int dodgeChance;
    public int resistChance;
    public int [] location;
>>>>>>> 0c713f00d05ccecc0ac4a7d7bd668c67c5911720

    public character(String _name){
        name = _name;
        status = "Alive";
        hp = 30;
        critChange = 20; // percent
        dodgeChance = 30; // percent
        resistChance = 10; // percent
        location = new int[] {0,0};
    }

    public void move(int x, int y){
        location[0] += x;
        location[1] += y;
    }

    public double scout(character target){
        int x1 = this.location[0];
        int y1 = this.location[1];
        int x2 = target.location[0];
        int y2 = target.location[1];
        double distance = Math.sqrt(
                    Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)
                );
        return distance;
    }


    public String emote(String requestTalk){
        String talk;
        switch (requestTalk){
            case "greet" : talk = "My name is " + this.name; break;
            case "drink" : talk = this.name + " wants beer"; break;
            default      : talk = "I dont know what to say...";
        }
        return talk;
    }

    private double damageModifier(){
        Random rand = new Random();
        float modifier = 1;

        // Critical strike
        if (rand.nextInt(100) + 1 <= critChange) {
            System.out.println("Critical strike!");
            modifier = 2; // Double the damage
        }

        // Dodge strike
        if (rand.nextInt(100) + 1 <= dodgeChance) {
            System.out.println("Target dodges...");
<<<<<<< HEAD
            modifier = 0; // No damage
=======
            modifier = 0; // Remove all damage
>>>>>>> 0c713f00d05ccecc0ac4a7d7bd668c67c5911720
        }

	    // Resist damage
        if (rand.nextInt(100) + 1 <= resistChance) {
            System.out.println("Target resists...");
<<<<<<< HEAD
            modifier = 0; // No damage
=======
            modifier = 0; // Remove all damage
>>>>>>> 0c713f00d05ccecc0ac4a7d7bd668c67c5911720
        }

        return modifier;
    }

    public void attack(character target){
        int baseDamage = 5;
        int range = 3;
        int damage = (int) Math.round(baseDamage * damageModifier());
        if(this.scout(target) < range){
            target.hp = target.hp - damage;
            if(target.hp < 1){
                target.status = "Dead";
            }
        }else{
            System.out.println("Target is out of range");
        }

    }
}
