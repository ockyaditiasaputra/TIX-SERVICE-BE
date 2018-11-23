package com.tiket.tix.project.rest.web.controller;

import org.mapstruct.factory.Mappers;

/**
 * @author Harvan Irsyadi
 * @version 2.0.0
 * @since 2.0.0 (31 Aug 2018)
 */
public class Mapper {

  public static final BeanMapper BEAN_MAPPER = Mappers.getMapper(BeanMapper.class);
}