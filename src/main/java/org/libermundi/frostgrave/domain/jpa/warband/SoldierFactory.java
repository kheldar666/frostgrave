package org.libermundi.frostgrave.domain.jpa.warband;

import org.libermundi.frostgrave.utils.NameGenerator;

public class SoldierFactory {

    public static Soldier getSoldier(SoldierType soldierType) {
        NameGenerator nameGenerator = new NameGenerator(10);

        Soldier soldier = new Soldier();

        soldier.setName(nameGenerator.getName());

        soldier.setSoldierType(soldierType);

        //Setting Default Values
        soldier.setMove(6);
        soldier.setFight(2);
        soldier.setShoot(0);
        soldier.setArmor(10);
        soldier.setWill(0);
        soldier.setHealth(10);
        soldier.setCost(0);

        //Now the specifics
        switch (soldierType) {
            case THUG:
                soldier.setWill(-1);
                break;
            case THIEF:
                soldier.setMove(7);
                soldier.setFight(1);
                break;
            case WARHOUND:
                soldier.setMove(8);
                soldier.setFight(1);
                soldier.setWill(-2);
                soldier.setHealth(8);
                soldier.setCost(10);
                break;
            case INFANTRYMAN:
                soldier.setFight(3);
                soldier.setArmor(11);
                soldier.setCost(50);
                break;
            case MANATARMS:
                soldier.setFight(3);
                soldier.setArmor(12);
                soldier.setWill(1);
                soldier.setHealth(12);
                soldier.setCost(75);
                break;
            case APOTHECARY:
                soldier.setFight(1);
                soldier.setWill(3);
                soldier.setHealth(12);
                soldier.setCost(75);
                break;
            case ARCHER: case CROSSBOWMAN:
                soldier.setFight(1);
                soldier.setShoot(2);
                soldier.setArmor(11);
                soldier.setCost(75);
                break;
            case TREASUREHUNTER:
                soldier.setMove(7);
                soldier.setFight(3);
                soldier.setArmor(11);
                soldier.setWill(2);
                soldier.setHealth(12);
                soldier.setCost(100);
                break;
            case TRACKER:
                soldier.setMove(7);
                soldier.setFight(1);
                soldier.setShoot(2);
                soldier.setArmor(11);
                soldier.setWill(1);
                soldier.setHealth(12);
                break;
            case KNIGHT:
                soldier.setMove(5);
                soldier.setFight(4);
                soldier.setArmor(13);
                soldier.setWill(1);
                soldier.setHealth(12);
                soldier.setCost(125);
                break;
            case TEMPLAR:
                soldier.setMove(5);
                soldier.setFight(4);
                soldier.setArmor(12);
                soldier.setWill(1);
                soldier.setHealth(12);
                soldier.setCost(125);
                break;
            case RANGER:
                soldier.setMove(7);
                soldier.setShoot(2);
                soldier.setArmor(11);
                soldier.setWill(2);
                soldier.setHealth(12);
                soldier.setCost(125);
                break;
            case BARBARIAN:
                soldier.setFight(4);
                soldier.setWill(3);
                soldier.setHealth(14);
                soldier.setCost(125);
                break;
            case MARKSMAN:
                soldier.setMove(5);
                soldier.setShoot(2);
                soldier.setArmor(12);
                soldier.setWill(1);
                soldier.setHealth(12);
                soldier.setCost(125);
                break;
            default:
                throw new UnsupportedOperationException("That type of Soldier ( " + soldierType + " ) is not supported");
        }

        return soldier;
    }

    public static Soldier getSoldier(SoldierType soldierType, Warband warband) {
        Soldier soldier = SoldierFactory.getSoldier(soldierType);
                soldier.setWarband(warband);
        return soldier;
    }

}
