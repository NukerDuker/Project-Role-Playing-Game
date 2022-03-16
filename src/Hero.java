

public class Hero extends Creature {



    private int experience;
    private int healPotion;
    private int gold;
    private int maxHealth;

    public Hero(Builder builder) {
        super(builder.name, builder.health, builder.strength, builder.agility, 1);
        maxHealth = builder.health;
        experience = 0;
    }

    public Hero addExperience(int experience) {
        this.experience += experience;
        return this;
    }

    public Hero addGold(int gold) {
        this.gold += gold;
        return this;
    }

    public Hero buy(int price) {
        if(price > gold) {
            System.out.println("Sorry, you don`t have enough money! You need " + (price - gold) + " more. Go on and get it!" );
        } else {
            gold -= price;
            healPotion++;
        }
        return this;
    }

    public static class Builder {

        private String name;
        private int health;
        private int strength;
        private int agility;
        private int level;

        private Builder() {
        }

        public static Builder newInstance() {
            return new Builder();
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setHealth(int health) {
            this.health = health;
            return this;
        }

        public Builder setStrength(int strength) {
            this.strength = strength;
            return this;
        }

        public Builder setAgility(int agility) {
            this.agility = agility;
            return this;
        }

        public Builder levelUp() {
            this.level++;
            return this;
        }

        public Hero build() {
            return new Hero(this);
        }
    }

    @Override
    public String toString() {
        return "Hero " + getName() + " created!";
    }

    @Override
    public void attack(Creature enemy, int randomResist) {
        System.out.print("Hero ");
        super.attack(enemy, randomResist);
    }

    public void drinkPotion() {
        //Зелье добавляет +20 здоровья
        if (healPotion > 0) {
            healPotion--;
            setHealth(getHealth() + 20);
            //Здоровье не может быть больше максимального
            if (getHealth() > maxHealth) {
                setHealth(maxHealth);
            }

        }
    }
}
