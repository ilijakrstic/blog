package com.blog.model.ajax;

import com.blog.model.comment.Comments;

public class AjaxResponseBody {
    private String msg;
    private String code;
    private Comments comment;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Comments getComment() {
        return comment;
    }

    public void setComment(Comments comment) {
        this.comment = comment;
    }
    
    
}
