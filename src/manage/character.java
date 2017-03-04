package manage;
import java.util.Random;

public class character{

    public String name;
    public String status;
    public int hp;
    public int critChange;
    public int dodgeChance;

    public character(String _name){
        name = _name;
        status = "Alive";
        hp = 30;
        critChange = 20; // percent
        dodgeChance = 30; // percent
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
            boolean critical = true;
            System.out.println("Critical strike!");
            modifier = 2; // Double the damage
        }

        // Dodge strike
        if (rand.nextInt(100) + 1 <= dodgeChance) {
            boolean critical = true;
            System.out.println("Target dodges...");
            modifier = 0; // Double the damage
        }

        return modifier;
    }

    public void attack(character target){
        int baseDamage = 5;
        int damage = (int) Math.round(baseDamage * damageModifier());
        target.hp = target.hp - damage;
        if(target.hp < 1){
            target.status = "Dead";
        }
    }
}
