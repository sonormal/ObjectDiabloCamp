public abstract class Monster implements Fighter {
    protected int health;
    protected int damage;

    private boolean isDead;

    public Monster(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void attack(Fighter victim) {
        victim.takeHit(damage);
    }

    @Override
    public void takeHit(int damage) {
        health -= damage;
        System.out.println("Monster took " + damage + " damage.");
    }
    public void setDead(boolean dead) {
        isDead = dead;
    }
}