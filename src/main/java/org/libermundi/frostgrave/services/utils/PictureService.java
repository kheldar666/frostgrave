package org.libermundi.frostgrave.services.utils;

import org.libermundi.frostgrave.domain.jpa.utils.Picture;
import org.libermundi.frostgrave.services.base.BaseService;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface PictureService extends BaseService<Picture> {
    Picture savePicture(MultipartFile picture);
    Picture getPicture(Resource resource);
}
