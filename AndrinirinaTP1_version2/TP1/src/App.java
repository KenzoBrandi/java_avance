import western.*;
public class App {
    public static void main(String[] args) {
        //Les personnages
        Barman barman = new Barman("Joseph");
        Cowboy cowboy = new Cowboy("Jeff");
        Sheriff sheriff = new Sheriff("Mc Carty");
        Lady lady = new Lady("Jane", "Yellow");
        Ruffian ruffian = new Ruffian("Greg");
        RuffianLady ruffianLady = new RuffianLady("Penelop", "Pink");
        Ripou ripou = new Ripou("Philou");

        //L'histoire commence ici
        Story.narrate("_Once upon a time in far far west land lived a cowboy called "+cowboy.getName()+"\n"
                    + "One day, a young lady named "+ lady.getName()+" was kidnapped by "+ruffian.getName()
        );
        lady.speak("Help! Help!! Please...");
        ruffian.kidnap(lady);
        Story.narrate(cowboy.getName()+" was near by, drinking "+cowboy.getDrink()+" at "+ barman.getBarname());
        cowboy.drink(barman);
        barman.speak("You hear that??");
        Story.narrate("He got out immediately");
        Story.chase(cowboy,ruffian);
        cowboy.handOver(sheriff);
        Story.narrate("But, there are undercover lady and sheriff that are still out there waiting to attack...\n"
                    + "The "+ ruffianLady.getLook()+" "+ ruffianLady.getName() + " and the "+ ripou.getLook() +" "+ripou.getName()
        );

    }
}