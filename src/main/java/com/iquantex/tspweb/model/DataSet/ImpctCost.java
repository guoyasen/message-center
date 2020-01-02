package com.iquantex.tspweb.model.DataSet;

import com.iquantex.tspweb.model.TradeimpactcostVw;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
public class ImpctCost implements Serializable {
    private String ttlEqty = "总股本(万股)";
    private String rstrShrsTtl = "限售股合计(万股)";
    private String nonTrdbShr = "非流通股合计(万股)";
    private String trdbShrsTtl = "流通股合计(万股)";
    private String ttlAShr = "A股合计(万股)";
    private String fltdAShr = "流通A股(万股)";
    private String rstrAShr = "限售A股(万股)";
    private String pldgNmbr = "质押数量(万股)";
    private String stckPlLvl = "公司库类别";
    private List<LabelValue> list;

    public void AddLabelValueList(List<TradeimpactcostVw> tradeimpactcostVws){
        if(list==null){
            list =new ArrayList<>();
        }
        for(TradeimpactcostVw vw:tradeimpactcostVws){
            LabelValue labelValue=new LabelValue();
            labelValue.setScrtCd(vw.getScrtCd());
            labelValue.setScrtNm(vw.getScrtNm());
            labelValue.setLbNm(vw.getLabelNm());
            labelValue.setTtlEqty(vw.getTtlEqty().toString());
            labelValue.setRstrShrsTtl(vw.getRstrShrsTtl().toString());
            labelValue.setNonTrdbShr(vw.getNonTrdbShr().toString());
            labelValue.setTrdbShrsTtl(vw.getTrdbShrsTtl().toString());
            labelValue.setTtlAShr(vw.getTtlAshr().toString());
            labelValue.setFltdAShr(vw.getFltdAshr().toString());
            labelValue.setRstrAShr(vw.getRstrAshr().toString());
            labelValue.setPldgNmbr(vw.getPldgNmbr());
            labelValue.setStckPlLvl(vw.getStckPlLvl());
            list.add(labelValue);
        }
    }
}

@Getter
@Setter
class LabelValue {
    private String scrtCd; //证券代码
    private String scrtNm; //证券名称
    private String lbNm; //标签名称名称，以分号隔开
    private String ttlEqty; //总股本(万股)
    private String rstrShrsTtl; //限售股合计(万股)
    private String nonTrdbShr; //非流通股合计(万股)
    private String trdbShrsTtl; //流通股合计(万股)
    private String ttlAShr; //A股合计(万股)
    private String fltdAShr; //流通A股(万股)
    private String rstrAShr; //限售A股(万股)
    private String pldgNmbr; //质押数量(万股)
    private String stckPlLvl; //公司库类别
}
