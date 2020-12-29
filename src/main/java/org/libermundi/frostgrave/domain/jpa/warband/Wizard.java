package org.libermundi.frostgrave.domain.jpa.warband;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.libermundi.frostgrave.domain.jpa.utils.Picture;
import org.libermundi.frostgrave.domain.jpa.warband.base.Figurine;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(of = {"name","school", "level"},callSuper = true)
public class Wizard extends Figurine {
    @Enumerated(EnumType.STRING)
    @Column(length=12,nullable=false)
    private School school;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Picture avatar;

    @Column(nullable = false)
    private int level = 0;

    public Wizard(String name, School school) {
        setName(name);
        setSchool(school);
        setLevel(0);
        setMove(6);
        setFight(2);
        setShoot(0);
        setArmor(10);
        setWill(4);
        setHealth(14);
    }
}
