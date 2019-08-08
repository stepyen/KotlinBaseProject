package com.stepyen.commonsdk.entity;


/**
 * date：2019-06-23
 * author：stepyen
 * description： 版本更新
 */
public class UpdateWrap {
    private int id;              // 唯一标识
    private String content;     // 更新内容
    private String filepath;    // 文件路径
    private String versionname;//版本号
    private int versioncode;//版本号
    private String dodatetime;  // 更新时间
    private int forceupdate;    // 是否是强行更行  1是   0不是
    private int type;           // 设备1安卓  0 ios



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getDodatetime() {
        return dodatetime;
    }

    public void setDodatetime(String dodatetime) {
        this.dodatetime = dodatetime;
    }

    public boolean getForceupdate() {
        return forceupdate == 1;
    }

    public void setForceupdate(int forceupdate) {
        this.forceupdate = forceupdate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getVersionname() {
        return versionname;
    }


    public void setVersionname(String versionname) {
        this.versionname = versionname;
    }

    public int getVersioncode() {
        return versioncode;
    }

    public void setVersioncode(int versioncode) {
        this.versioncode = versioncode;
    }
}
