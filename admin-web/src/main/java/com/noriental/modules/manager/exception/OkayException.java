package com.noriental.modules.manager.exception;

/***
 * *   ____  ___________  ___________           ________   ____  __.  _____ _____.___.
 * *   \   \/  /\______ \ \_   _____/           \_____  \ |    |/ _| /  _  \\__  |   |
 * *    \     /  |    |  \ |    __)     ______   /   |   \|      <  /  /_\  \/   |   |
 * *    /     \  |    `   \|     \     /_____/  /    |    \    |  \/    |    \____   |
 * *   /___/\  \/_______  /\___  /              \_______  /____|__ \____|__  / ______|
 * *    	 \_/        \/     \/                       \/        \/       \/\/
 * *
 * *   功能描述：请在此处加入功能描述
 * *
 * *   @DATE    2019-11-28
 * *   @AUTHOR  JT.L
 ***/
public class OkayException extends RuntimeException {

    public OkayException() {
    }

    public OkayException(String message) {
        super(message);
    }

    public OkayException(String message, Throwable cause) {
        super(message, cause);
    }

    public OkayException(Throwable cause) {
        super(cause);
    }

    public OkayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}