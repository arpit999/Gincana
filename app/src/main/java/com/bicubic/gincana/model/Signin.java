package com.bicubic.gincana.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 05-Dec-16.
 */

public class Signin {


    /**
     * response : {"result":false,"errorCode":1,"errorDescription":"Invalid Username/Password","userId":""}
     */

    @SerializedName("response")
    private ResponseBean response;

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public static class ResponseBean {
        @Override
        public String toString() {
            return "ResponseBean{" +
                    "result=" + result +
                    ", errorCode=" + errorCode +
                    ", errorDescription='" + errorDescription + '\'' +
                    ", userId='" + userId + '\'' +
                    '}';
        }

        /**
         * result : false
         * errorCode : 1
         * errorDescription : Invalid Username/Password
         * userId :
         */


        @SerializedName("result")
        private boolean result;
        @SerializedName("errorCode")
        private int errorCode;
        @SerializedName("errorDescription")
        private String errorDescription;
        @SerializedName("userId")
        private String userId;

        public boolean isResult() {
            return result;
        }

        public void setResult(boolean result) {
            this.result = result;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorDescription() {
            return errorDescription;
        }

        public void setErrorDescription(String errorDescription) {
            this.errorDescription = errorDescription;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
