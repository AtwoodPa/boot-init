package com.pp.boot.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 *
 * @author supanpan
 * @create 2024/05/08 16:31
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handleException(Exception e) {
        log.error("An error occurred: " + e.getMessage(), e);
        // 处理所有异常，返回500 Internal Server Error
        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        log.error("Runtime error occurred: " + e.getMessage(), e);
        // 处理运行时异常，返回400 Bad Request
        return new ResponseEntity<>("Runtime error occurred: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

//    /**
//     * 处理未登录异常
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(Exception.class)
//    public String exceptionHandler(Exception e, Model model) {
//        String message = "";
//        if (e instanceof NoLoginException) {
//            message = "请先登录";
//        }else {// 未知异常
//            message = "未知异常";
//        }
//        model.addAttribute("message", message);
//        return "error";
//    }
}
