package com.iquantex.tspweb.table;

import com.iquantex.tspweb.model.*;
import com.iquantex.tspweb.param.HeaderParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * etf基金成分股明细
 *
 * @author xp
 * @date 2019/4/3 1300
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class EtfConstituentStockDetail {
    /**
     * 生成etf成分股明细前台报文
     *
     * @param c01EtfFndIndxCnsttInfrs
     * @param num                     取多少条
     * @param direction               排序方向
     */
    public EtfConstituentStockDetail(List<C01EtfFndIndxCnsttInfr> c01EtfFndIndxCnsttInfrs, Integer num, String direction) {
        // 组装公共字段信息
        this.headers = new ArrayList<>();
        //headers.add(new HeaderParam("fndCd", "基金证券编码"));
        headers.add(new HeaderParam("scrtCd", "证券编码"));
        headers.add(new HeaderParam("scrtNm", "证券名称"));
        headers.add(new HeaderParam("dlyChng", "最新日涨跌幅"));
        headers.add(new HeaderParam("stckNmbr", "证券数量"));
        headers.add(new HeaderParam("cshRplcFlg", "现金替代标志"));
        headers.add(new HeaderParam("cshRplcDscnRt", "现金替代溢价比例"));
        headers.add(new HeaderParam("rplcCsh", "固定替代金额"));
        headers.add(new HeaderParam("nwstPrc", "当前交易价格"));
        headers.add(new HeaderParam("stpStts", "是否停牌"));
        headers.add(new HeaderParam("estmCshMrgn", "预估现金差额"));
        headers.add(new HeaderParam("yrChng", "今年以来涨跌幅"));
        //headers.add(new HeaderParam("qttnScrtCd", "行情数据证券编码"));
        headers.add(new HeaderParam("chckTm", "更新时间"));

        Collections.sort(c01EtfFndIndxCnsttInfrs, new Comparator<C01EtfFndIndxCnsttInfr>() {
            @Override
            public int compare(C01EtfFndIndxCnsttInfr o1, C01EtfFndIndxCnsttInfr o2) {
                BigDecimal dlychange1 = new BigDecimal(Double.valueOf(o1.getDlyChng().substring(0, o1.getDlyChng().length() - 1)));
                BigDecimal dlychange2 = new BigDecimal(Double.valueOf(o2.getDlyChng().substring(0, o2.getDlyChng().length() - 1)));

                if (dlychange1.compareTo(dlychange2) > 0) {
                    return direction.equals("order") ? -1 : 1;
                }
                if (dlychange1.compareTo(dlychange2) == 0) {
                    return 0;
                }
                return direction.equals("order") ? 1 : -1;
            }
        });


        // 组装特殊字段信息，排序后取前num条
        if (num != null && num >= 0 && num < c01EtfFndIndxCnsttInfrs.size())
            this.bodys = c01EtfFndIndxCnsttInfrs.subList(0, num);
        else
            this.bodys = c01EtfFndIndxCnsttInfrs;
        log.debug("< " + this.getClass().getSimpleName() + ">" + " : End of conversion. ");
    }

    private List<HeaderParam> headers;
    private List<C01EtfFndIndxCnsttInfr> bodys;

}
