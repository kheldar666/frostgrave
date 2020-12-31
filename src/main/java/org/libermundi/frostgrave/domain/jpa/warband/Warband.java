package org.libermundi.frostgrave.domain.jpa.warband;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.libermundi.frostgrave.domain.jpa.base.StatefulEntity;
import org.libermundi.frostgrave.domain.jpa.campaign.Campaign;
import org.libermundi.frostgrave.domain.jpa.security.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(of = {"name","player","wizard","apprentice"},callSuper = true)
public class Warband extends StatefulEntity {
    @Column(length = 50, nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private User player;

    @OneToOne
    private Campaign campaign;

    @OneToOne
    private Wizard wizard;

    @OneToOne
    private Apprentice apprentice;

    @OneToMany(
        mappedBy = "warband",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @OrderColumn
    private List<Soldier> soldiers =  Lists.newArrayList();

    public Warband (String name, User player) {
        setName(name);
        setPlayer(player);
    }

}
