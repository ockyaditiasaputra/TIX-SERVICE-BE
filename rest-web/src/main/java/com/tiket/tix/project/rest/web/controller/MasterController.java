package com.tiket.tix.project.rest.web.controller;

import com.tiket.tix.common.rest.web.model.request.MandatoryRequest;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ockyaditiasaputra
 */
@RestController
@RequestMapping("/tix-service-be/master")
@Api(value = "Master")
public class MasterController {

  @ModelAttribute
  public MandatoryRequest getMandatoryParameter(HttpServletRequest request) {
    return (MandatoryRequest) request.getAttribute("mandatory");
  }
}
