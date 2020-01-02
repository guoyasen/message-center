package com.iquantex.tspweb.service;

import com.iquantex.tspweb.common.RestTemplateUtil;
import com.iquantex.tspweb.dao.java.SubRuleMapper;
import com.iquantex.tspweb.model.SubRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SubRuleService {
    private static final Logger LOG = LoggerFactory.getLogger(SubRuleService.class);

    @Autowired
    private SubRuleMapper subRuleDao;

    @Autowired
    private RestTemplateUtil restTemplateUtil;


    /**
     * 根据规则id查询该规则下的细则列表
     * @param ruleId
     * @return
     */
    public List<SubRule> getSubRules(String ruleId){
        Example example = new Example(SubRule.class);
        example.createCriteria().andEqualTo("ruleId", ruleId);
        return subRuleDao.selectByExample(example);
    }

    /**
     * 更新细则
     * @param subRule
     * @return
     */
    @Transactional
    public int updateSubRule(SubRule subRule){
        int res = subRuleDao.updateByPrimaryKeySelective(subRule);
        //更新内存中的条款数据
        try {
            // tsp-server1
            String url = restTemplateUtil.tspUrl + "/refdata/rules";
            String returnInfo = restTemplateUtil.exchangeByDefault(url, HttpMethod.PUT, null);
            LOG.info(String.format("return info: <%s>. ", returnInfo));

            // tsp-server2
            String url2 = restTemplateUtil.tspUrl2 + "/refdata/rules";
            String returnInfo2 = restTemplateUtil.exchangeByDefault(url2, HttpMethod.PUT, null);
            LOG.info(String.format("return info2: <%s>. ", returnInfo2));

        } catch (Exception e) {
            // 更新server端失败后,抛出异常信息返回给前端,并且事物回滚
            throw new RuntimeException("更新server内存规则数据失败", e);
        }
        return res;
    }

    /**
     * 删除细则
     * @param subRuleId
     * @return
     */
    public int deleteSubRule(String subRuleId){
        return subRuleDao.deleteByPrimaryKey(subRuleId);
    }
}
