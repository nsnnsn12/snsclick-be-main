package com.snsclicksystem.main.util.modelmapper;

import java.util.List;

public interface ObjectMapper {
    <T> T copy(T target);

    <T> T overwrite(T target, T destination);

    <S, D> D convert(S source, Class<D> clazz);

    <S, D> List<D> convertList(List<S> source, Class<D> clazz);
}
