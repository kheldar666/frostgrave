package org.libermundi.frostgrave.domain.jpa.campaign;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.libermundi.frostgrave.domain.jpa.base.StatefulEntity;
import org.libermundi.frostgrave.domain.jpa.security.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(of = {"name", "admin"},callSuper = true)
public class Campaign extends StatefulEntity {

    @Column(length=50,nullable = false)
    private String name;


    @ManyToOne
    private User admin;
}
