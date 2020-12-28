package org.libermundi.frostgrave.domain.jpa.warband;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(of = {"name"},callSuper = true)
public class Apprentice extends BaseFigurine {


}
