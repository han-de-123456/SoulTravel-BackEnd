package org.soul.common;

import java.io.Serializable;

public class ResultValidator implements Serializable {
    private String errorMsg;

    public ResultValidator(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
