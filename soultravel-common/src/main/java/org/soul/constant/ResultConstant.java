package org.soul.constant;

public enum ResultConstant {
    FAILED(0, "操作失败！请刷新重试"),
    SUCCESS(1, "操作成功！"),
    VALIDATOR(2, "输入错误！");

    private int code;
    private String message;

    private ResultConstant(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
