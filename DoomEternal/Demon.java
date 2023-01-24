public class Demon {
    String demonName;
    int demonHealth;
    int demonDamage;


    DoomSlayer Doomslayernumber;
    DemonKillcount doomkillcount;

    Demon( String DdemonName, int DdemonHealth, int DdemonDamage, DoomSlayer Doomslayernumb, DemonKillcount doomkillcount){
        this.demonName = DdemonName;
        this.demonHealth = DdemonHealth;
        this.demonDamage = DdemonDamage;
        this.Doomslayernumber = Doomslayernumb;
       

    }

         void DoomSlayerStatus() {
            System.out.println("The Slayer " + Doomslayernumber.Doomslayernumber + " killed " + demonName + " " + doomkillcount + " times "  );

        }





}