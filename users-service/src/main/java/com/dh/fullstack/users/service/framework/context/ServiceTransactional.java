package com.dh.fullstack.users.service.framework.context;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Santiago Mamani
 */
@Service
@Scope("prototype")
@Transactional
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceTransactional {

}
