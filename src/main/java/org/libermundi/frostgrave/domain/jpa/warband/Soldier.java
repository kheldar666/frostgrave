package org.libermundi.frostgrave.domain.jpa.warband;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.libermundi.frostgrave.domain.jpa.warband.SoldierType;
import org.libermundi.frostgrave.domain.jpa.warband.Warband;
import org.libermundi.frostgrave.domain.jpa.warband.base.Figurine;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Soldier extends Figurine {
    @ManyToOne(fetch = FetchType.LAZY)
    private Warband warband;

    @Column
    private int cost;

    @Enumerated(EnumType.STRING)
    @Column(length=20,nullable=false)
    private SoldierType soldierType;

}
