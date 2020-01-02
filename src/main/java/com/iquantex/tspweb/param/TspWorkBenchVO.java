package com.iquantex.tspweb.param;

import lombok.Getter;
import lombok.Setter;

@Getter
public class TspWorkBenchVO {

    private String name;
    private String i;
    private String groupId;
    private String groupName;
    private String component;
    private String iconType;
    private String compDesc;
    private String ruleId;
    private String typeId;
    private props props;
    private String idempotentKey;
    private Integer handle;

    public void setIdempotentKey(String idempotentKey) {
        if (this.props == null) {
            this.props = new props();
        }
        this.props.idempotentKey = idempotentKey;

    }

    public void setHandle(Integer handle) {
        if (this.props == null) {
            this.props = new props();
        }
        this.props.handle=handle;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setI(String i) {
        this.i = i;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public void setIconType(String iconType) {
        this.iconType = iconType;
    }

    public void setCompDesc(String compDesc) {
        this.compDesc = compDesc;
    }

    public void setRuleId(String ruleId) {
        if (this.props == null) {
            this.props = new props();
        }
        this.props.ruleId = ruleId;
    }

    public void setTypeId(String typeId) {
        if (this.props == null) {
            this.props = new props();
        }
        this.props.typeId = typeId;
    }




}









