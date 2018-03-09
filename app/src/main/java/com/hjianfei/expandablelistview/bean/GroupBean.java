package com.hjianfei.expandablelistview.bean;

import java.util.List;


public class GroupBean {
    private String groupName;
    private List<ChildBean> childs;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<ChildBean> getChilds() {
        return childs;
    }

    public void setChilds(List<ChildBean> childs) {
        this.childs = childs;
    }
}
