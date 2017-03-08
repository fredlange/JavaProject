package manage;
import java.util.Random;

public class character{

    public String name;
    public String status;
    public int hp;
    public int critChange;
    public int dodgeChance;
    public int resistChance;
    public int [] location;

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

    public double damageModifier(){
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
            modifier = 0; // Remove all damage
        }

	    // Resist damage
        if (rand.nextInt(100) + 1 <= resistChance) {
            System.out.println("Target resists...");
            modifier = 0; // Remove all damage
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
