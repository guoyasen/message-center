package com.iquantex.tspweb.controller;

import com.iquantex.tspweb.model.TspMenuitem;
import com.iquantex.tspweb.param.TspMenuitemVO;
import com.iquantex.tspweb.param.TspWorkBenchVO;
import com.iquantex.tspweb.param.props;
import com.iquantex.tspweb.service.TspMenuitemService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/tsp_menuitem")
public class TspMenuitemController extends BaseController {
    Logger logger = LoggerFactory.getLogger(TspMenuitemController.class);

    @Autowired
    private TspMenuitemService tspMenuitemService;

    /**
     * 根据菜单类型和用户id来查询菜单
     *
     * @param mType
     * @param user_id
     * @return
     */
    @GetMapping("/{mType}/{user_id}")
    public String getMenuitems(@PathVariable("mType") String mType, @PathVariable("user_id") String user_id) {
        try {

            if (mType.equals("workBench")) {
                List<TspWorkBenchVO> menuitems = tspMenuitemService.getWorkBenchByUid(mType, user_id);
                return successReturn(menuitems);
            } else {
                List<TspMenuitemVO> menuitems = tspMenuitemService.getMenuitemByUid(mType, user_id);
                return successReturn(menuitems);
            }
        } catch (Exception e) {
            return failReturn(e.getMessage());
        }
    }

    /**
     * 查询菜单
     *
     * @param id 菜单id
     *@param  userId 用户
     * @return
     */
    @GetMapping("/query/{id}/{userId}")
    public String getAllMenuitems(@PathVariable("id") String id,@PathVariable("userId") String userId) {
        try {
            List<TspMenuitem> tspMenuitems = tspMenuitemService.getMenuitemById(id,userId);
            if (!id.equals("all") && tspMenuitems.size() > 0) {
                return successReturn(tspMenuitems.get(0));
            } else if (tspMenuitems.size() == 0) {
                return successReturn("不存在该记录");
            }
            return successReturn(tspMenuitems);
        } catch (Exception e) {
            return failReturn(e.getMessage());
        }
    }

    @PostMapping("/add")
    public String addMenuitems(@RequestBody TspMenuitem tspMenuitem) {
        try {
            int result =tspMenuitemService.addMenuitem(tspMenuitem);
            if (result == 1) {
                tspMenuitem=tspMenuitemService.selectMenuitemByPrimary(tspMenuitem.getId());
                return successReturn(tspMenuitem);
            } else {
                return failReturn("新增失败");
            }
        } catch (Exception e) {
            return failReturn(e.getMessage());
        }
    }

    @PostMapping("/modify")
    public String modifyMenuitems(@RequestBody TspMenuitem tspMenuitem) {
        try {
            int result = tspMenuitemService.modifyMenuitem(tspMenuitem);
            if (result == 1) {
                tspMenuitem=tspMenuitemService.selectMenuitemByPrimary(tspMenuitem.getId());
                return successReturn(tspMenuitem);
            } else {
                return failReturn("修改失败");
            }
        } catch (Exception e) {
            return failReturn(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMenuitem(@PathVariable("id") String id) {
        try {
            tspMenuitemService.deleteMenuitem(id);
            return successReturn();
        } catch (Exception e) {
            return failReturn(e.getMessage());
        }
    }

}
