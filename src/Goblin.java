public class Goblin extends Creature{

    public Goblin(Builder builder) {
        super(builder.name, builder.health, builder.strength, builder.agility, builder.level);
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

        public Builder levelUp() {
            this.level++;
            return this;
        }

        public Goblin build() {
            return new Goblin(this);
        }
    }

    @Override
    public String toString() {
        return "Goblin created!";
    }
}
