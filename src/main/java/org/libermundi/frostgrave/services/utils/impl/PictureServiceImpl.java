package org.libermundi.frostgrave.services.utils.impl;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.compress.utils.IOUtils;
import org.libermundi.frostgrave.domain.jpa.utils.Picture;
import org.libermundi.frostgrave.repositories.utils.PictureRepository;
import org.libermundi.frostgrave.services.base.impl.AbstractServiceImpl;
import org.libermundi.frostgrave.services.utils.PictureService;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Service("PictureService")
@Transactional(rollbackFor = Exception.class, propagation= Propagation.REQUIRED)
public class PictureServiceImpl extends AbstractServiceImpl<Picture> implements PictureService {

    public PictureServiceImpl(PictureRepository pictureRepository) {
        setRepository(pictureRepository, Picture.class);
    }

    @Override
    public Picture savePicture(MultipartFile picture) {
        try {
            Picture picToSave = createNew(picture.getBytes(), picture.getContentType());

            save(picToSave);

            return picToSave;

        } catch (IOException e) {
            log.error("Failed to save the Picture.", e);
        }
        return null;
    }

    @Override
    public Picture getPicture(Resource resource) {
        try {
            InputStream is = resource.getInputStream();
            return createNew(IOUtils.toByteArray(is),"image/jpeg");
        } catch (IOException e) {
            log.error("Error while loading Picture from Resource : " + resource.getFilename());
        }
        return null;
    }

    @Override
    public void initData() {
        //Nothing to do
    }

    private Picture createNew(byte[] data, String contenttype){
        Picture picture = new Picture();

        Byte[] dataByte = new Byte[data.length];

        int i = 0;
        for (byte b : data){
            dataByte[i++] = b;
        }

        picture.setData(dataByte);
        picture.setContentType(contenttype);
        return picture;
    }
}
