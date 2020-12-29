package org.libermundi.frostgrave.domain.jpa.warband;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.libermundi.frostgrave.domain.jpa.warband.base.Figurine;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(of = {"name","school", "level"},callSuper = true)
public class Captain extends Figurine {
    @Column(nullable = false)
    private int level = 0;

}
