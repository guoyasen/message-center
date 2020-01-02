package com.iquantex.tspweb.service.settjob.task;

import com.iquantex.tspweb.model.RpstorSettChildtask;
import com.iquantex.tspweb.service.settjob.RpstorJobBuilder;
import com.iquantex.tspweb.service.settjob.RpstorSettChildTaskIBasic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 重置job状态
 *
 * @author shenzhengjie
 * @date 2019/2/18 13:57
 */
@Slf4j
@Service
public class ResetStatusJob extends RpstorSettChildTaskIBasic {

    @Autowired
    private RpstorJobBuilder rpstorJobBuilder;

    @Override
    public int execute() {
        rpstorJobBuilder.resetJobTree(1);
        return RpstorSettChildtask.c_status_done;
    }
}
