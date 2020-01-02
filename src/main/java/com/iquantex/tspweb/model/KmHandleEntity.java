package com.iquantex.tspweb.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class KmHandleEntity implements Serializable {
    public KmHandleEntity(String n_logid, String vc_consig_date, String vc_consig_person, String vc_index_data,
                          String vc_order_num, String vc_order_data, String vc_fund_name, String n_institutional_share,
                          String n_noinstitutional_value, String vc_dealcode, String n_bond_value, String n_investvalue,
                          String vc_seccode, String vc_trade, String n_comyieds, String n_valuyieds) {
        this.setHead(new Head());
        this.setBody(new Body(n_logid, vc_consig_date, vc_consig_person, vc_index_data,
                vc_order_num, vc_order_data, vc_fund_name, n_institutional_share,
                n_noinstitutional_value, vc_dealcode, n_bond_value, n_investvalue,
                vc_seccode, vc_trade, n_comyieds, n_valuyieds));
        this.head.setService_cd("BizComplianceReviewService");
        this.head.setTrans_cd("InitBusiness");
        this.head.setSvr_ver("v1.0");
        this.head.setInf_typ("1");
        this.head.setReq_sys_cd("TSP");
        this.head.setTarget_sys_cd("KM");
        String reqtm = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String bizNO = reqtm + new Random().nextInt(99);
        this.head.setTrace_no("TSP" + bizNO);
        this.head.setBiz_logno(bizNO);
        this.head.setReq_tm(reqtm);
    }

    private Head head;

    private Body body;

    public void setHead(Head head) {
        this.head = head;
    }

    public Head getHead() {
        return this.head;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Body getBody() {
        return this.body;
    }
}

class Head {
    public Head() {
    }

    private String trace_no;

    private String biz_logno;

    private String service_cd;

    private String trans_cd;

    private String svr_ver;

    private String inf_typ;

    private String req_sys_cd;

    private String target_sys_cd;

    private String txn_dt;

    private String req_tm;

    public void setTrace_no(String trace_no) {
        this.trace_no = trace_no;
    }

    public String getTrace_no() {
        return this.trace_no;
    }

    public void setBiz_logno(String biz_logno) {
        this.biz_logno = biz_logno;
    }

    public String getBiz_logno() {
        return this.biz_logno;
    }

    public void setService_cd(String service_cd) {
        this.service_cd = service_cd;
    }

    public String getService_cd() {
        return this.service_cd;
    }

    public void setTrans_cd(String trans_cd) {
        this.trans_cd = trans_cd;
    }

    public String getTrans_cd() {
        return this.trans_cd;
    }

    public void setSvr_ver(String svr_ver) {
        this.svr_ver = svr_ver;
    }

    public String getSvr_ver() {
        return this.svr_ver;
    }

    public void setInf_typ(String inf_typ) {
        this.inf_typ = inf_typ;
    }

    public String getInf_typ() {
        return this.inf_typ;
    }

    public void setReq_sys_cd(String req_sys_cd) {
        this.req_sys_cd = req_sys_cd;
    }

    public String getReq_sys_cd() {
        return this.req_sys_cd;
    }

    public void setTarget_sys_cd(String target_sys_cd) {
        this.target_sys_cd = target_sys_cd;
    }

    public String getTarget_sys_cd() {
        return this.target_sys_cd;
    }

    public void setTxn_dt(String txn_dt) {
        this.txn_dt = txn_dt;
    }

    public String getTxn_dt() {
        return this.txn_dt;
    }

    public void setReq_tm(String req_tm) {
        this.req_tm = req_tm;
    }

    public String getReq_tm() {
        return this.req_tm;
    }
}

class Body {
    /**
     * @param n_logid                 记录标识
     * @param vc_consig_date          委托日期
     * @param vc_consig_person        下单人
     * @param vc_index_data           触发风控内容
     * @param vc_order_num            指令序号
     * @param vc_order_data           指令内容
     * @param vc_fund_name            组合名称
     * @param n_institutional_share   机构持有人占用份额(触发风控内容为:"临近90日信用债"时为必填字段)
     * @param n_noinstitutional_value 扣除机构持有人份额后基金对应的净资产(触发风控内容为:"临近90日信用债"时为必填字段)
     * @param vc_dealcode             债券代码 (触发风控内容为:"临近90日信用债"时为必填字段)
     * @param n_bond_value            该债券目前持仓市值(触发风控内容为:"临近90日信用债"时为必填字段)
     * @param n_investvalue           拟投资指令金额(触发风控内容为:"临近90日信用债"时为必填字段)
     * @param vc_seccode              证券代码
     * @param vc_trade                交易方向(枚举数值：买入,卖出,融资,融券（期限）)
     * @param n_comyieds              指令收益率
     * @param n_valuyieds             中债或中证估值收益率(%)
     */
    public Body(String n_logid, String vc_consig_date, String vc_consig_person, String vc_index_data,
                String vc_order_num, String vc_order_data, String vc_fund_name, String n_institutional_share,
                String n_noinstitutional_value, String vc_dealcode, String n_bond_value, String n_investvalue,
                String vc_seccode, String vc_trade, String n_comyieds, String n_valuyieds) {
        this.vc_logid = n_logid;
        this.vc_consig_date = vc_consig_date;
        this.vc_consig_person = vc_consig_person;
        this.vc_index_data = vc_index_data;
        this.vc_order_num = vc_order_num;
        this.vc_order_data = vc_order_data;
        this.vc_fund_name = vc_fund_name;
        this.n_institutional_share = n_institutional_share;
        this.n_noinstitutional_value = n_noinstitutional_value;
        this.vc_dealcode = vc_dealcode;
        this.n_bond_value = n_bond_value;
        this.n_investvalue = n_investvalue;
        this.vc_seccode = vc_seccode;
        this.vc_trade = vc_trade;
        this.n_comyieds = n_comyieds;
        this.n_valuyieds = n_valuyieds;
    }

    //记录标识
    private String vc_logid;
    //委托日期
    private String vc_consig_date;
    //下单人
    private String vc_consig_person;
    //触发风控内容
    private String vc_index_data;
    //指令序号
    private String vc_order_num;
    //指令内容
    private String vc_order_data;
    //组合名称
    private String vc_fund_name;
    //机构持有人占用份额(触发风控内容为:"临近90日信用债"时为必填字段)
    private String n_institutional_share;
    //扣除机构持有人份额后基金对应的净资产(触发风控内容为:"临近90日信用债"时为必填字段)
    private String n_noinstitutional_value;
    //债券代码 (触发风控内容为:"临近90日信用债"时为必填字段)
    private String vc_dealcode;
    //该债券目前持仓市值(触发风控内容为:"临近90日信用债"时为必填字段)
    private String n_bond_value;
    //拟投资指令金额(触发风控内容为:"临近90日信用债"时为必填字段)
    private String n_investvalue;
    //证券代码
    private String vc_seccode;
    //交易方向(枚举数值：买入,卖出,融资,融券（期限）)
    private String vc_trade;
    //指令收益率
    private String n_comyieds;
    //中债或中证估值收益率(%)
    private String n_valuyieds;


    public void setVc_logid(String vc_logid) {
        this.vc_logid = vc_logid;
    }

    public String getVc_logid() {
        return this.vc_logid;
    }

    public void setVc_consig_date(String vc_consig_date) {
        this.vc_consig_date = vc_consig_date;
    }

    public String getVc_consig_date() {
        return this.vc_consig_date;
    }

    public void setVc_consig_person(String vc_consig_person) {
        this.vc_consig_person = vc_consig_person;
    }

    public String getVc_consig_person() {
        return this.vc_consig_person;
    }

    public void setVc_index_data(String vc_index_data) {
        this.vc_index_data = vc_index_data;
    }

    public String getVc_index_data() {
        return this.vc_index_data;
    }

    public void setVc_order_num(String vc_order_num) {
        this.vc_order_num = vc_order_num;
    }

    public String getVc_order_num() {
        return this.vc_order_num;
    }

    public void setVc_order_data(String vc_order_data) {
        this.vc_order_data = vc_order_data;
    }

    public String getVc_order_data() {
        return this.vc_order_data;
    }

    public void setVc_fund_name(String vc_fund_name) {
        this.vc_fund_name = vc_fund_name;
    }

    public String getVc_fund_name() {
        return this.vc_fund_name;
    }

    public void setN_institutional_share(String n_institutional_share) {
        this.n_institutional_share = n_institutional_share;
    }

    public String getN_institutional_share() {
        return this.n_institutional_share;
    }

    public void setN_noinstitutional_value(String n_noinstitutional_value) {
        this.n_noinstitutional_value = n_noinstitutional_value;
    }

    public String getN_noinstitutional_value() {
        return this.n_noinstitutional_value;
    }

    public void setVc_dealcode(String vc_dealcode) {
        this.vc_dealcode = vc_dealcode;
    }

    public String getVc_dealcode() {
        return this.vc_dealcode;
    }

    public void setN_bond_value(String n_bond_value) {
        this.n_bond_value = n_bond_value;
    }

    public String getN_bond_value() {
        return this.n_bond_value;
    }

    public void setN_investvalue(String n_investvalue) {
        this.n_investvalue = n_investvalue;
    }

    public String getN_investvalue() {
        return this.n_investvalue;
    }

    public void setVc_seccode(String vc_seccode) {
        this.vc_seccode = vc_seccode;
    }

    public String getVc_seccode() {
        return this.vc_seccode;
    }

    public void setVc_trade(String vc_trade) {
        this.vc_trade = vc_trade;
    }

    public String getVc_trade() {
        return this.vc_trade;
    }

    public void setN_comyieds(String n_comyieds) {
        this.n_comyieds = n_comyieds;
    }

    public String getN_comyieds() {
        return this.n_comyieds;
    }

    public void setN_valuyieds(String n_valuyieds) {
        this.n_valuyieds = n_valuyieds;
    }

    public String getN_valuyieds() {
        return this.n_valuyieds;
    }
}
