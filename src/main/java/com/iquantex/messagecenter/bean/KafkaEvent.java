package com.iquantex.messagecenter.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KafkaEvent {
    // 事件来源
    private String source;

    // 事件详细信息
    private Object data;
}
