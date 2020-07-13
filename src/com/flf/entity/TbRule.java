package com.flf.entity;

import org.apache.commons.lang.StringUtils;

public class TbRule {
    private Integer id;
    private String ruleName;//规则名称
    private String assType; //关联类型
    private String assObj;//关联对象
    private Float rate;//阈值
    private String ruleTimeF;//时间规则
    private String ruleTimeT;//时间规则
    private String warnTime;//预警时机
    private String warnType;//事件类型
    private String creator;//创建人
    private String creatTime;//创建时间
    private Integer warnDeal;//上报的预警数
    private Integer warnIgn;//忽略的预警数
    private Integer warnTodo;//未处理的预警数
    private Page page;
    public String getAssTypeName(){
        if (!StringUtils.isBlank(assType)){
            switch (assType){
                case "1": return "抽检地区";
                case "2": return "食品分类";
                case "3": return "食品分类";
                case "4": return "包装分类";
                case "5": return "区域类型";
                case "6": return "检测项目";
                default:
                    return "";
            }
        }else return "";
    }
    public String getWarnTimeName(){
        if (!StringUtils.isBlank(warnTime)){
            switch (warnTime){
                case "1": return "立即触发";
                case "2": return "定时触发";
                default:
                    return "";
            }
        }else return "";
    }
    public String getWarnTypeName(){
        if (!StringUtils.isBlank(warnType)){
            switch (warnType){
                case "1": return "邮件通知";
                case "2": return "短信通知";
                default:
                    return "";
            }
        }else return "";
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getAssType() {
        return assType;
    }

    public void setAssType(String assType) {
        this.assType = assType;
    }

    public String getAssObj() {
        return assObj;
    }

    public void setAssObj(String assObj) {
        this.assObj = assObj;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getRuleTimeF() {
        return ruleTimeF;
    }

    public void setRuleTimeF(String ruleTimeF) {
        this.ruleTimeF = ruleTimeF;
    }

    public String getRuleTimeT() {
        return ruleTimeT;
    }

    public void setRuleTimeT(String ruleTimeT) {
        this.ruleTimeT = ruleTimeT;
    }

    public String getWarnTime() {
        return warnTime;
    }

    public void setWarnTime(String warnTime) {
        this.warnTime = warnTime;
    }

    public String getWarnType() {
        return warnType;
    }

    public void setWarnType(String warnType) {
        this.warnType = warnType;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getWarnDeal() {
        return warnDeal;
    }

    public void setWarnDeal(Integer warnDeal) {
        this.warnDeal = warnDeal;
    }

    public Integer getWarnIgn() {
        return warnIgn;
    }

    public void setWarnIgn(Integer warnIgn) {
        this.warnIgn = warnIgn;
    }

    public Integer getWarnTodo() {
        return warnTodo;
    }

    public void setWarnTodo(Integer warnTodo) {
        this.warnTodo = warnTodo;
    }
}
