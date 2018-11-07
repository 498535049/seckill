package com.spring.test.exception;


import com.spring.test.domain.Constants;

/**
 * 非法初始化异常
 *
 * @author asheng
 * @since 2018/7/18
 */
public class IllegalInitException extends RuntimeException {

    private static final long serialVersionUID = -3665576310160335638L;

    public IllegalInitException(Object obj) {
        super(String.format(Constants.INIT_ERROR_TIP, obj.getClass().getSimpleName()));
    }

    public IllegalInitException(Class clazz) {
        super(String.format(Constants.INIT_ERROR_TIP, clazz.getSimpleName()));
    }
}
