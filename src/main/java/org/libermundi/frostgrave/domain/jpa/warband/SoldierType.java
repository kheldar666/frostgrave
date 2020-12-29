package org.libermundi.frostgrave.domain.jpa.warband;

public enum SoldierType {
    THUG(Boolean.FALSE),
    THIEF(Boolean.FALSE),
    WARHOUND(Boolean.FALSE),
    INFANTRYMAN(Boolean.FALSE),
    MANATARMS(Boolean.FALSE),
    APOTHECARY(Boolean.FALSE),
    ARCHER(Boolean.TRUE),
    CROSSBOWMAN(Boolean.TRUE),
    TREASUREHUNTER(Boolean.TRUE),
    TRACKER(Boolean.TRUE),
    KNIGHT(Boolean.TRUE),
    TEMPLAR(Boolean.TRUE),
    RANGER(Boolean.TRUE),
    BARBARIAN(Boolean.TRUE),
    MARKSMAN(Boolean.TRUE);

    private Boolean isSpecialist;

    SoldierType(Boolean isSpecialist) {
        this.isSpecialist = isSpecialist;
    }

    public Boolean isSpecialist() { return isSpecialist ;}
}
