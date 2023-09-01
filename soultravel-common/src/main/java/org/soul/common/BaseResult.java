package org.soul.common;

import com.google.common.collect.Lists;
import org.soul.constant.ResultConstant;

import java.io.Serializable;
import java.util.List;

public class BaseResult implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final int FAILED = 0;
    public static final int SUCCESS = 1;
    public static final int VALIDATOR = 2;
    private int code;
    private String message;
    private Object data;

    public BaseResult() {
    }

    public BaseResult(String message) {
        this.message = message;
    }

    public BaseResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static BaseResult failResultCreate(String message) {
        return new BaseResult(0, message, (Object)null);
    }

    public static BaseResult failResultCreate(String message, Object data) {
        return new BaseResult(0, message, data);
    }

    public static BaseResult successResultCreate(Object data) {
        return new BaseResult(1, ResultConstant.SUCCESS.getMessage(), data);
    }

    public static BaseResult successResultCreate(String message, Object data) {
        return new BaseResult(1, message, data);
    }

    public static BaseResult validatorResultCreate(String data) {
        List<ResultValidator> messageList = Lists.newArrayList();
        messageList.add(new ResultValidator(data));
        return new BaseResult(2, ResultConstant.VALIDATOR.getMessage(), messageList);
    }

    public static BaseResult appValidatorResultCreate(String message) {
        return new BaseResult(2, message, (Object)null);
    }

    /** @deprecated */
    @Deprecated
    public static BaseResult appFailResultCreate(String message) {
        return new BaseResult(0, message, (Object)null);
    }

    public static BaseResult checkCountOneResult(int didCount) {
        return checkCountResult(didCount, 1);
    }

    public static BaseResult checkCountResult(int didCount, int willDoCount) {
        BaseResult result = new BaseResult();
        if (didCount <= 0) {
            result.setCode(0);
            result.setMessage("处理失败");
        } else if (didCount < willDoCount) {
            result.setCode(1);
            result.setMessage("批量操作部分成功！");
        } else {
            result.setCode(1);
            result.setMessage("操作成功");
        }

        result.setData(didCount);
        return result;
    }

    public static BaseResult checkBooleanResult(boolean flag) {
        return checkBooleanResult(flag, (Object)null);
    }

    public static BaseResult checkBooleanResult(boolean flag, Object data) {
        BaseResult result = new BaseResult();
        if (flag) {
            result.setCode(1);
            result.setMessage("操作成功");
        } else {
            result.setCode(0);
            result.setMessage("操作失败");
        }

        result.setData(data);
        return result;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return 1 == this.code;
    }

    public String toString() {
        return "BaseResult{code=" + this.code + ", message='" + this.message + '\'' + ", data=" + this.data + '}';
    }
}
