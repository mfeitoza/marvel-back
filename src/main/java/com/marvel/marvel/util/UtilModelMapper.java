package com.marvel.marvel.util;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

public final class UtilModelMapper {

  static ModelMapper modelMapper = new ModelMapper();

  private UtilModelMapper() {}

  public static <S, T> T map(S source, Class<T> targetClass) {
    return modelMapper.map(source, targetClass);
  }

  public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
    return source
      .stream()
      .map(element -> modelMapper.map(element, targetClass))
      .collect(Collectors.toList());
  }
}