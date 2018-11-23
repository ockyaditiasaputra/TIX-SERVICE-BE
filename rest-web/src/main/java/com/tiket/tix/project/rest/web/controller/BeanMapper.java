package com.tiket.tix.project.rest.web.controller;

import com.tiket.tix.common.rest.web.model.request.MandatoryRequest;
import com.tiket.tix.master.library.entity.dao.ChannelId;
import com.tiket.tix.master.library.model.request.ChannelIdRequest;
import com.tiket.tix.master.library.model.response.ChannelIdResponse;
import org.mapstruct.Mapper;

/**
 * @author Harvan Irsyadi
 * @version 2.0.0
 * @since 2.0.0 (23 Jul 2018)
 */
@Mapper
public interface BeanMapper {

  ChannelId map(ChannelIdRequest channelIdRequest, MandatoryRequest mandatoryRequest);

  ChannelIdResponse map(ChannelId channelId);
}