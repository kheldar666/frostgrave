package org.libermundi.frostgrave.repositories.utils;

import org.libermundi.frostgrave.domain.jpa.utils.Picture;
import org.libermundi.frostgrave.repositories.base.UndeletableRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends UndeletableRepository<Picture, Long> {

}
