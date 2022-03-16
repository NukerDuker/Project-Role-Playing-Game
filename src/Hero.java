

public class Hero extends Creature{

    private final String name;
    private int health;
    private int strength;
    private int agility;
    private int level;
    private int experience;
    private int healPotion;

    public Hero(Builder builder) {
        this.name = builder.name;
        this.health = builder.health;
        this.strength = builder.strength;
        this.agility = builder.agility;
        this.level = 1;
        this.experience = 0;
        healPotion = 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getLevel() {
        return level;
    }

    public static class Builder{

        private String name;
        private int health;
        private int strength;
        private int agility;
        private int level;

        private Builder(){};

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

        public Hero build() {
            return new Hero(this);
        }
    }

    @Override
    public String attack(Creature enemy, int randomResist) {
        boolean hit = this.agility * 3 >= randomResist;
        if (hit) {
            boolean criticalHit = this.agility * 3 <= randomResist + 5;
            int damage = this.strength;
            if (criticalHit) {
                damage = this.strength * 2;
            }

        }
        return null;
    }

    @Override
    public String toString() {
        return "Hero " + name + " created!";
    }

    public void drinkHealPotion() {

    }
}
