package manage;

public class character{

    public String name;
    public String status;
    public int hp;

    public character(String _name){

        name = _name;
        status = "Alive";
        hp = 30;

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

    public void attack(character target){
        int damage = 5;
        target.hp = target.hp - damage;
        if(target.hp < 1){
            target.status = "Dead";
        }
    }
}
