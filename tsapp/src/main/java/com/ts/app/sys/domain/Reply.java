package com.ts.app.sys.domain;

import java.util.Date;

public class Reply {
    private Integer replyid;

    private Integer evaluateid;

    private String repaycontent;

    private String isreaded;

    private Integer createuserid;

    private Date createdate;

    private Integer updateuserid;

    private Date updatedate;

    private String deleteflag;

    public Integer getReplyid() {
        return replyid;
    }

    public void setReplyid(Integer replyid) {
        this.replyid = replyid;
    }

    public Integer getEvaluateid() {
        return evaluateid;
    }

    public void setEvaluateid(Integer evaluateid) {
        this.evaluateid = evaluateid;
    }

    public String getRepaycontent() {
        return repaycontent;
    }

    public void setRepaycontent(String repaycontent) {
        this.repaycontent = repaycontent == null ? null : repaycontent.trim();
    }

    public String getIsreaded() {
        return isreaded;
    }

    public void setIsreaded(String isreaded) {
        this.isreaded = isreaded == null ? null : isreaded.trim();
    }

    public Integer getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(Integer createuserid) {
        this.createuserid = createuserid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getUpdateuserid() {
        return updateuserid;
    }

    public void setUpdateuserid(Integer updateuserid) {
        this.updateuserid = updateuserid;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(String deleteflag) {
        this.deleteflag = deleteflag == null ? null : deleteflag.trim();
    }
}