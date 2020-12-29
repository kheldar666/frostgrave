package org.libermundi.frostgrave.domain.jpa.warband;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.libermundi.frostgrave.domain.jpa.warband.base.Figurine;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(of = {"name"},callSuper = true)
public class Apprentice extends Figurine {
    public Apprentice(String name, Wizard wizard) {
        setName(name);
        setMove(wizard.getMove());
        setFight(wizard.getFight()-2);
        setShoot(wizard.getShoot());
        setArmor(10);
        setWill(wizard.getWill()-2);
        setHealth(wizard.getHealth()-2);
    }
}
