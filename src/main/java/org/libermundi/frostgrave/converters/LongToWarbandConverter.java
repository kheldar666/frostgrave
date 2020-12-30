package org.libermundi.frostgrave.converters;

import org.libermundi.frostgrave.domain.jpa.warband.Warband;
import org.libermundi.frostgrave.services.warband.WarbandService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LongToWarbandConverter implements Converter<Long, Warband> {
    private final WarbandService warbandService;

    public LongToWarbandConverter(WarbandService warbandService) {
        this.warbandService = warbandService;
    }

    @Override
    public Warband convert(Long source) {
        return warbandService.findById(source);
    }
}
