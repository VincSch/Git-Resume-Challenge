package com.vschwarzer.gitresume.web.controller.common;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Base controller can be used as parent class for other controllers
 * Created by Vincent Schwarzer on 01.11.15.
 */
@RestController
@RequestMapping("/api")
public class BaseController {

    protected final Logger LOG = Logger.getLogger(this.getClass().getName());

}
