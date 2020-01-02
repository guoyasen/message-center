package com.iquantex.tspweb.service.settjob.task;


import com.iquantex.tspweb.model.RpstorSettChildtask;
import com.iquantex.tspweb.service.AuthDataService;
import com.iquantex.tspweb.service.settjob.RpstorSettChildTaskIBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 更新o32映射市场名称缓存
 *
 * @author shenZhengJie
 * @date 2018/12/21 9:48
 */
@Service
public class UpdateO32InstMarketNameDictJob extends RpstorSettChildTaskIBasic {

    @Autowired
    private AuthDataService authDataService;

    @Override
    public int execute() {
        //更新o32代码和市场名称映射字典
        authDataService.updateO32SecuCodeToMarketName();
        //每日清除指令推送websocket记录
        authDataService.clearWebsocketPushInstRecord();
        return RpstorSettChildtask.c_status_done;
    }
}
