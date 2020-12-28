package org.libermundi.frostgrave.domain.jpa.warband;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Soldier extends BaseFigurine {
    @ManyToOne(fetch = FetchType.LAZY)
    private Warband warband;

}
