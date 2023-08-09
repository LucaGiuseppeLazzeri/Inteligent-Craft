public class Story {
    public static void printIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("STORY");
        GameLogic.printSeparator(30);
        System.out.println("You are in the world");
        System.out.println("You need to collect a oxygen tank, wood, metal and oil to build your spaceship");
        GameLogic.pressToContinue();

    }

    public static void printFirstActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT I - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("As you begin your journey you start travelling trough the nearby woods to reach the everlasting mountains.");
        System.out.println("The everlasting mountains are a very dangerous place. It says nobody came back alive from there.");
        System.out.println("\nAfter a long day of walking through the woods, you finally reach the everlasting mountains.");
        System.out.println("its a fake Minecraft, mine the wood");
        GameLogic.pressToContinue();
    }

    public static void printFirstActOutro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT I - OUTRO");
        GameLogic.printSeparator(30);
        System.out.println("You did it! You obtained wood");
        GameLogic.pressToContinue();

    }

    static void printSecondActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT II - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("You begin travelling across the mines.");
        System.out.println("You collected some wood from the trees in the previous area.");
        System.out.println("Luckily you are a rocket scientist and you know how to use this to build a spaceship");
        System.out.println("You know exactly where the castle of the evil emperor is, but you have to cross these haunted landlines first...");
        GameLogic.pressToContinue();
    }

    public static void printSecondActOutro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT II - OUTRO");
        GameLogic.printSeparator(30);
        System.out.println("You managed to find metal");
        System.out.println("you can nearly build your space ship");
        GameLogic.pressToContinue();
    }

    public static void printThirdActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT III INTRO");
        GameLogic.printSeparator(30);
        System.out.println("You see the huge black castle in front of you.");
        System.out.println("As you stand in front of the gates, you know there must be an oxygen cylinder inside");
        GameLogic.pressToContinue();
    }

    public static void printThirdActOutro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT III - OUTRO");
        GameLogic.printSeparator(30);
        System.out.println("You came so far. You defeated all of the Evil Emperor's minions.");
        System.out.println("As you stand in front of the door to his throne room, you know there's no going back.");
        System.out.println("You recall your lost power and restore your health.");
        System.out.println("You get the chance to learn a last trait before entering the throne room.");
        GameLogic.pressToContinue();
    }


    public static void printFourthActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT IV - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("You enter the throne room of the Evil Emperor(Joe Biden). ");
        System.out.println("You stares you dead in the eyes. You feel the darkness around you. ");
        System.out.println("He takes out the holy sword of darkness, the mightiest weapon known to man.");
        System.out.println("You need to steal his oil back");
        GameLogic.pressToContinue();
    }

    static void printEnd(Player player) {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        if (player.parts >= 4){
            System.out.println("You have collected all the parts");
            System.out.println("Congratulations, " + player.name + "! You built a space craft!");

        } else {
            System.out.println("You have collected " + player.parts + " parts. You need all five parts to build a space craft.");
        }
        GameLogic.printSeparator(30);
        System.out.println("This game was developed by Luca");
        System.out.println("I hope you enjoyed it!");
    }
}