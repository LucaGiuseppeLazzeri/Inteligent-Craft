// SID: 2119372 ARU Cambridge 2023 Software principles MOD003484 TRI2 F01CAM live breif 2
public class Enemy extends Character{
    public static String[] enemies = {"Horses, "+ "Herobrine, "+ "Joe Biden, "+"Elon Musk, "};
    int playerXp;
    public Enemy(String name, int playerXp) {
        super (name, (int) (Math.random() *playerXp + playerXp/3 + 5), (int) (Math.random () * (playerXp/4 + 2) +1)) ;
        this.playerXp = playerXp;
    }

    @Override
    public int attack(){
        return (int)(Math.random() * (playerXp/4 + 1) + xp/4 + 3);
    }
    @Override
    public int defend(){
        return (int)(Math.random() * (playerXp/4 + 1) + xp/4 + 3);
    }

}
