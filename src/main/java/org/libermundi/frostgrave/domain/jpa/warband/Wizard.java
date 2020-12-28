package org.libermundi.frostgrave.domain.jpa.warband;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.libermundi.frostgrave.domain.jpa.utils.Picture;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(of = {"name","school", "level"},callSuper = true)
public class Wizard extends BaseFigurine {
    @Enumerated(EnumType.STRING)
    @Column(length=12,nullable=false)
    private School school = School.UNDEFINED;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Picture avatar;

    @Column(nullable = false)
    private int level = 0;

}
