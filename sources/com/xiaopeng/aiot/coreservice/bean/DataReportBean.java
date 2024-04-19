package com.xiaopeng.aiot.coreservice.bean;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DataReportBean implements Serializable {
    private String dataContent;
    private String dataType;
    private String groupId;
    private String groupName;
    private long reportTime;
    private String vin;

    public String getVin() {
        return this.vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataContent() {
        return this.dataContent;
    }

    public void setDataContent(String dataContent) {
        this.dataContent = dataContent;
    }

    public long getReportTime() {
        return this.reportTime;
    }

    public void setReportTime(long reportTime) {
        this.reportTime = reportTime;
    }

    public String toString() {
        return "DataReportBean{vin='" + this.vin + "', groupId='" + this.groupId + "', groupName='" + this.groupName + "', dataType='" + this.dataType + "', dataContent='" + this.dataContent + "', reportTime=" + this.reportTime + '}';
    }
}
