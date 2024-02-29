package com.snsclicksystem.main.util.modelmapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ObjectMapperImpl implements ObjectMapper{
    private final ModelMapper modelMapper;
    public ObjectMapperImpl(){
        this.modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
                .setSkipNullEnabled(true).setAmbiguityIgnored(true);
    }
    public <T> T copy(T target){
        return modelMapper.map(target, (Type) target.getClass());
    }

    public <T> T overwrite(T newOne, T oldOne){
        T result = copy(oldOne);
        modelMapper.map(newOne, result);
        return result;
    }

    public <S, D> D convert(S source, Class<D> clazz){
        return modelMapper.map(source, (Type) clazz);
    }
    public <S, D> List<D> convertList(List<S> source, Class<D> clazz){
        if(ObjectUtils.isEmpty(source)) return new ArrayList<>();
        return source.stream().map(item -> convert(item, clazz)).toList();
    }
}
