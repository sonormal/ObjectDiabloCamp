public class Villager implements Fighter {
    protected int health = 100;
    protected String name;
    protected int age;

    public Villager(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Greetings traveler... I'm " + name + " and I'm " + age + " years old.");
    }

    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return (int) ((100 - age * 0.5) / 10);
    }
    @Override
    public void attack(Fighter victim) {
        int damage = getDamage();
        victim.takeHit(damage);
    }

    @Override
    public void takeHit(int damage) {
        health -= damage;
    }
}