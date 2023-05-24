public class Main {
    public static void main(String[] args) {
        Villager kashya = new Villager("Kashya", 30);
        Villager gheed = new Villager("Gheed", 50);
        Villager warriv = new Villager("Warriv", 35);
        Villager flawia = new Villager("Flawia", 25);

        ExtraordinaryVillager akara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);
        ExtraordinaryVillager deckardCain = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);

        Villager[] villagers = {kashya, akara, gheed, deckardCain, warriv, flawia};
        Monster[] monsters = {Monsters.andariel, Monsters.blacksmith};

        Object objectDeckardCain = deckardCain;
        Object objectAkara = akara;

        kashya.sayHello();
        akara.sayHello(); // Nie można wywołać metody sayHello() na zmiennej akara
        gheed.sayHello();
        deckardCain.sayHello(); // Nie można wywołać metody sayHello() na zmiennej deckardCain
        warriv.sayHello();
        flawia.sayHello();

        int totalMonsterHealth = Monsters.monstersHealth();

        while (totalMonsterHealth > 0) {
            for (Villager villager : villagers) {
                if (villager.getHealth() > 0) {
                    System.out.println("Potwory posiadaja jeszcze " + totalMonsterHealth + " punkty zycia");
                    System.out.println("Aktualnie walczacy osadnik to " + villager.getName());

                    for (Monster monster : monsters) {
                        if (monster.getHealth() > 0) {
                            villager.attack(monster);
                            if (monster.getHealth() <= 0) {
                                monster.setDead(true);
                            }
                        }
                    }
                    totalMonsterHealth = Monsters.monstersHealth(); // aktualizacja sumy życia potworów
                }
            }
        }

        System.out.println("Obozowisko ocalone!");

        // Odzyskanie mocy
        deckardCain = (ExtraordinaryVillager) objectDeckardCain;
        akara = (ExtraordinaryVillager) objectAkara;

        // Sprawdzenie czy można wywołać metody z klasy ExtraordinaryVillager
        deckardCain.sayHello();
        akara.sayHello();
    }
}