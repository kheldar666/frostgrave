package org.libermundi.frostgrave.repositories.base;

import org.libermundi.frostgrave.domain.jpa.base.Identity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface UndeletableRepository<T extends Identity, ID extends Serializable> extends JpaRepository<T,ID> {
    /**
     * Allows to return the last record in the DB
     * @return T (or null if the Table is empty)
     */
    T findFirstByOrderByIdDesc();

    /**
     * Allows to fetch the first record of the DB
     * @return T (or null if the Table is empty)
     */
    T findFirstByOrderByIdAsc();


}
