package org.libermundi.frostgrave.domain.jpa.warband.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.libermundi.frostgrave.domain.jpa.base.StatefulEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@ToString(of = {"name","move","fight","shoot","armor","will","health"},callSuper = true)
public abstract class Figurine extends StatefulEntity {

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private int move = 0;

    @Column(nullable = false)
    private int fight = 0;

    @Column(nullable = false)
    private int shoot = 0;

    @Column(nullable = false)
    private int armor = 0;

    @Column(nullable = false)
    private int will = 0;

    @Column(nullable = false)
    private int health = 0;

}
