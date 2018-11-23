package com.tiket.tix.project.rest.web.controller;

import com.tiket.tix.common.rest.web.model.request.MandatoryRequest;
import com.tiket.tix.common.rest.web.model.response.BaseResponse;
import com.tiket.tix.common.rest.web.model.response.CommonResponse;
import com.tiket.tix.master.library.entity.constant.enums.ResponseCode;
import com.tiket.tix.master.library.model.response.ChannelIdResponse;
import com.tiket.tix.master.library.service.api.ChannelIdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author ockyaditiasaputra
 */
@RestController
@RequestMapping("/tix-service-be/channelId")
@Api(value = "Channel Id")
public class ChannelIdController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ChannelIdController.class);

  @Autowired
  private ChannelIdService channelIdService;
  private BeanMapper mapper = Mapper.BEAN_MAPPER;

  @ApiOperation(value = "Find All ChannelId")
  @GetMapping(path = "/findAll")
  public Mono<BaseResponse<List<ChannelIdResponse>>> findAllChannelId(
      @ApiIgnore @Valid @ModelAttribute MandatoryRequest mandatoryRequest) {

    LOGGER.info("findAllChannelId mandatoryRequest = {}", mandatoryRequest);

    return channelIdService
        .findAllChannelId(mandatoryRequest)
        .map(channelId -> mapper.map(channelId))
        .collectList()
        .map(channelId ->
            CommonResponse.constructResponse(
                ResponseCode.SUCCESS.getCode(),
                ResponseCode.SUCCESS.getMessage(),
                null, channelId)
        )
        .subscribeOn(Schedulers.elastic()).publishOn(Schedulers.elastic()
        );
  }

  @ModelAttribute
  public MandatoryRequest getMandatoryParameter(HttpServletRequest request) {
    return (MandatoryRequest) request.getAttribute("mandatory");
  }
}
