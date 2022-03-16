public class LevelUpListener implements Runnable{

    Hero hero;
    int baseExp;

    public LevelUpListener(Hero hero) {
        this.hero = hero;
    }


    @Override
    public void run() {
        while(true) {
            baseExp = hero.getLevel() * 100;
            if(hero.getExperience() > baseExp) {
                levelUp();
                System.out.println("Level " + hero.getLevel() + " achieved!");
            }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void levelUp(){
        hero.setLevel().setAgility().setStrength().setHealth(hero.getHealth() + 10);
    }
}
