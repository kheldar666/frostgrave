package org.libermundi.frostgrave.domain.jpa.warband;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.libermundi.frostgrave.domain.jpa.base.StatefulEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
@ToString(of = {"name","move","fight","shoot"},callSuper = true)
public abstract class BaseFigurine extends StatefulEntity {

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private int move = 6;

    @Column(nullable = false)
    private int fight = 2;

    @Column(nullable = false)
    private int shoot = 0;

    @Column(nullable = false)
    private int armor = 10;

    @Column(nullable = false)
    private int will = -1;

    @Column(nullable = false)
    private int health = 1;

}
