/**
 *  introspectedTable.getFullyQualifiedTable().getComment()
 * PpLineWeldReq.java
 * Copyright(C) 2015-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2017-07-23 Created
 */
package java.request;

import java.io.Serializable;
import java.util.Date;

public class PpLineWeldReq implements Serializable {
    private Long id;

    private Long pipeId;

    private String pageCode;

    private String jiont;

    private String wpsno;

    private String jlocation;

    private String jclass;

    private Date finishDate;

    private String jsize;

    /**
     * 管道壁厚设置表@
     */
    private String thickness;

    /**
     * 数据字典@
     */
    private String jtype;

    /**
     * 数据字典@
     */
    private String weldingProcess;

    /**
     * 数据字典@
     */
    private String fixedRotat;

    /**
     * 焊工代号@
     */
    private String rootWelder;

    private String examitem;

    /**
     * 焊工代号@
     */
    private String coverWelder;

    /**
     * 数据字典@
     */
    private Long visual;

    private String pieceNo1;

    private String weldingMatial;

    private String pieceNo2;

    private String heatNo1;

    private String heatNo2;

    private String alterCode;

    /**
     * 数据字典@
     */
    private String alterType;

    private String dailyNo;

    private String hardessRec;

    private String heatRec;

    private String rtLot;

    private String rtSample;

    private String remark;

    private Date createTime;

    private Integer delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pp_line_weld
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.ID
     *
     * @return the value of pp_line_weld.ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.ID
     *
     * @param id the value for pp_line_weld.ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.PIPE_ID
     *
     * @return the value of pp_line_weld.PIPE_ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Long getPipeId() {
        return pipeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.PIPE_ID
     *
     * @param pipeId the value for pp_line_weld.PIPE_ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setPipeId(Long pipeId) {
        this.pipeId = pipeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.PAGE_CODE
     *
     * @return the value of pp_line_weld.PAGE_CODE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getPageCode() {
        return pageCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.PAGE_CODE
     *
     * @param pageCode the value for pp_line_weld.PAGE_CODE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setPageCode(String pageCode) {
        this.pageCode = pageCode == null ? null : pageCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.JIONT
     *
     * @return the value of pp_line_weld.JIONT
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getJiont() {
        return jiont;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.JIONT
     *
     * @param jiont the value for pp_line_weld.JIONT
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setJiont(String jiont) {
        this.jiont = jiont == null ? null : jiont.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.WPSNO
     *
     * @return the value of pp_line_weld.WPSNO
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getWpsno() {
        return wpsno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.WPSNO
     *
     * @param wpsno the value for pp_line_weld.WPSNO
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setWpsno(String wpsno) {
        this.wpsno = wpsno == null ? null : wpsno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.JLOCATION
     *
     * @return the value of pp_line_weld.JLOCATION
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getJlocation() {
        return jlocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.JLOCATION
     *
     * @param jlocation the value for pp_line_weld.JLOCATION
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setJlocation(String jlocation) {
        this.jlocation = jlocation == null ? null : jlocation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.JCLASS
     *
     * @return the value of pp_line_weld.JCLASS
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getJclass() {
        return jclass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.JCLASS
     *
     * @param jclass the value for pp_line_weld.JCLASS
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setJclass(String jclass) {
        this.jclass = jclass == null ? null : jclass.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.FINISH_DATE
     *
     * @return the value of pp_line_weld.FINISH_DATE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Date getFinishDate() {
        return finishDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.FINISH_DATE
     *
     * @param finishDate the value for pp_line_weld.FINISH_DATE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.JSIZE
     *
     * @return the value of pp_line_weld.JSIZE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getJsize() {
        return jsize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.JSIZE
     *
     * @param jsize the value for pp_line_weld.JSIZE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setJsize(String jsize) {
        this.jsize = jsize == null ? null : jsize.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.THICKNESS
     *
     * @return the value of pp_line_weld.THICKNESS
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getThickness() {
        return thickness;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.THICKNESS
     *
     * @param thickness the value for pp_line_weld.THICKNESS
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setThickness(String thickness) {
        this.thickness = thickness == null ? null : thickness.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.JTYPE
     *
     * @return the value of pp_line_weld.JTYPE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getJtype() {
        return jtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.JTYPE
     *
     * @param jtype the value for pp_line_weld.JTYPE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setJtype(String jtype) {
        this.jtype = jtype == null ? null : jtype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.WELDING_PROCESS
     *
     * @return the value of pp_line_weld.WELDING_PROCESS
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getWeldingProcess() {
        return weldingProcess;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.WELDING_PROCESS
     *
     * @param weldingProcess the value for pp_line_weld.WELDING_PROCESS
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setWeldingProcess(String weldingProcess) {
        this.weldingProcess = weldingProcess == null ? null : weldingProcess.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.FIXED_ROTAT
     *
     * @return the value of pp_line_weld.FIXED_ROTAT
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getFixedRotat() {
        return fixedRotat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.FIXED_ROTAT
     *
     * @param fixedRotat the value for pp_line_weld.FIXED_ROTAT
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setFixedRotat(String fixedRotat) {
        this.fixedRotat = fixedRotat == null ? null : fixedRotat.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.ROOT_WELDER
     *
     * @return the value of pp_line_weld.ROOT_WELDER
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getRootWelder() {
        return rootWelder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.ROOT_WELDER
     *
     * @param rootWelder the value for pp_line_weld.ROOT_WELDER
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setRootWelder(String rootWelder) {
        this.rootWelder = rootWelder == null ? null : rootWelder.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.EXAMITEM
     *
     * @return the value of pp_line_weld.EXAMITEM
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getExamitem() {
        return examitem;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.EXAMITEM
     *
     * @param examitem the value for pp_line_weld.EXAMITEM
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setExamitem(String examitem) {
        this.examitem = examitem == null ? null : examitem.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.COVER_WELDER
     *
     * @return the value of pp_line_weld.COVER_WELDER
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getCoverWelder() {
        return coverWelder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.COVER_WELDER
     *
     * @param coverWelder the value for pp_line_weld.COVER_WELDER
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setCoverWelder(String coverWelder) {
        this.coverWelder = coverWelder == null ? null : coverWelder.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.VISUAL
     *
     * @return the value of pp_line_weld.VISUAL
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Long getVisual() {
        return visual;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.VISUAL
     *
     * @param visual the value for pp_line_weld.VISUAL
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setVisual(Long visual) {
        this.visual = visual;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.PIECE_NO1
     *
     * @return the value of pp_line_weld.PIECE_NO1
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getPieceNo1() {
        return pieceNo1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.PIECE_NO1
     *
     * @param pieceNo1 the value for pp_line_weld.PIECE_NO1
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setPieceNo1(String pieceNo1) {
        this.pieceNo1 = pieceNo1 == null ? null : pieceNo1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.WELDING_MATIAL
     *
     * @return the value of pp_line_weld.WELDING_MATIAL
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getWeldingMatial() {
        return weldingMatial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.WELDING_MATIAL
     *
     * @param weldingMatial the value for pp_line_weld.WELDING_MATIAL
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setWeldingMatial(String weldingMatial) {
        this.weldingMatial = weldingMatial == null ? null : weldingMatial.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.PIECE_NO2
     *
     * @return the value of pp_line_weld.PIECE_NO2
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getPieceNo2() {
        return pieceNo2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.PIECE_NO2
     *
     * @param pieceNo2 the value for pp_line_weld.PIECE_NO2
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setPieceNo2(String pieceNo2) {
        this.pieceNo2 = pieceNo2 == null ? null : pieceNo2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.HEAT_NO1
     *
     * @return the value of pp_line_weld.HEAT_NO1
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getHeatNo1() {
        return heatNo1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.HEAT_NO1
     *
     * @param heatNo1 the value for pp_line_weld.HEAT_NO1
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setHeatNo1(String heatNo1) {
        this.heatNo1 = heatNo1 == null ? null : heatNo1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.HEAT_NO2
     *
     * @return the value of pp_line_weld.HEAT_NO2
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getHeatNo2() {
        return heatNo2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.HEAT_NO2
     *
     * @param heatNo2 the value for pp_line_weld.HEAT_NO2
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setHeatNo2(String heatNo2) {
        this.heatNo2 = heatNo2 == null ? null : heatNo2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.ALTER_CODE
     *
     * @return the value of pp_line_weld.ALTER_CODE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getAlterCode() {
        return alterCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.ALTER_CODE
     *
     * @param alterCode the value for pp_line_weld.ALTER_CODE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setAlterCode(String alterCode) {
        this.alterCode = alterCode == null ? null : alterCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.ALTER_TYPE
     *
     * @return the value of pp_line_weld.ALTER_TYPE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getAlterType() {
        return alterType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.ALTER_TYPE
     *
     * @param alterType the value for pp_line_weld.ALTER_TYPE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setAlterType(String alterType) {
        this.alterType = alterType == null ? null : alterType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.DAILY_NO
     *
     * @return the value of pp_line_weld.DAILY_NO
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getDailyNo() {
        return dailyNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.DAILY_NO
     *
     * @param dailyNo the value for pp_line_weld.DAILY_NO
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setDailyNo(String dailyNo) {
        this.dailyNo = dailyNo == null ? null : dailyNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.HARDESS_REC
     *
     * @return the value of pp_line_weld.HARDESS_REC
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getHardessRec() {
        return hardessRec;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.HARDESS_REC
     *
     * @param hardessRec the value for pp_line_weld.HARDESS_REC
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setHardessRec(String hardessRec) {
        this.hardessRec = hardessRec == null ? null : hardessRec.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.HEAT_REC
     *
     * @return the value of pp_line_weld.HEAT_REC
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getHeatRec() {
        return heatRec;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.HEAT_REC
     *
     * @param heatRec the value for pp_line_weld.HEAT_REC
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setHeatRec(String heatRec) {
        this.heatRec = heatRec == null ? null : heatRec.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.RT_LOT
     *
     * @return the value of pp_line_weld.RT_LOT
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getRtLot() {
        return rtLot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.RT_LOT
     *
     * @param rtLot the value for pp_line_weld.RT_LOT
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setRtLot(String rtLot) {
        this.rtLot = rtLot == null ? null : rtLot.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.RT_SAMPLE
     *
     * @return the value of pp_line_weld.RT_SAMPLE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getRtSample() {
        return rtSample;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.RT_SAMPLE
     *
     * @param rtSample the value for pp_line_weld.RT_SAMPLE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setRtSample(String rtSample) {
        this.rtSample = rtSample == null ? null : rtSample.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.REMARK
     *
     * @return the value of pp_line_weld.REMARK
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.REMARK
     *
     * @param remark the value for pp_line_weld.REMARK
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.CREATE_TIME
     *
     * @return the value of pp_line_weld.CREATE_TIME
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.CREATE_TIME
     *
     * @param createTime the value for pp_line_weld.CREATE_TIME
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_weld.DEL_FLAG
     *
     * @return the value of pp_line_weld.DEL_FLAG
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_weld.DEL_FLAG
     *
     * @param delFlag the value for pp_line_weld.DEL_FLAG
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_line_weld
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PpLineWeldReq other = (PpLineWeldReq) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPipeId() == null ? other.getPipeId() == null : this.getPipeId().equals(other.getPipeId()))
            && (this.getPageCode() == null ? other.getPageCode() == null : this.getPageCode().equals(other.getPageCode()))
            && (this.getJiont() == null ? other.getJiont() == null : this.getJiont().equals(other.getJiont()))
            && (this.getWpsno() == null ? other.getWpsno() == null : this.getWpsno().equals(other.getWpsno()))
            && (this.getJlocation() == null ? other.getJlocation() == null : this.getJlocation().equals(other.getJlocation()))
            && (this.getJclass() == null ? other.getJclass() == null : this.getJclass().equals(other.getJclass()))
            && (this.getFinishDate() == null ? other.getFinishDate() == null : this.getFinishDate().equals(other.getFinishDate()))
            && (this.getJsize() == null ? other.getJsize() == null : this.getJsize().equals(other.getJsize()))
            && (this.getThickness() == null ? other.getThickness() == null : this.getThickness().equals(other.getThickness()))
            && (this.getJtype() == null ? other.getJtype() == null : this.getJtype().equals(other.getJtype()))
            && (this.getWeldingProcess() == null ? other.getWeldingProcess() == null : this.getWeldingProcess().equals(other.getWeldingProcess()))
            && (this.getFixedRotat() == null ? other.getFixedRotat() == null : this.getFixedRotat().equals(other.getFixedRotat()))
            && (this.getRootWelder() == null ? other.getRootWelder() == null : this.getRootWelder().equals(other.getRootWelder()))
            && (this.getExamitem() == null ? other.getExamitem() == null : this.getExamitem().equals(other.getExamitem()))
            && (this.getCoverWelder() == null ? other.getCoverWelder() == null : this.getCoverWelder().equals(other.getCoverWelder()))
            && (this.getVisual() == null ? other.getVisual() == null : this.getVisual().equals(other.getVisual()))
            && (this.getPieceNo1() == null ? other.getPieceNo1() == null : this.getPieceNo1().equals(other.getPieceNo1()))
            && (this.getWeldingMatial() == null ? other.getWeldingMatial() == null : this.getWeldingMatial().equals(other.getWeldingMatial()))
            && (this.getPieceNo2() == null ? other.getPieceNo2() == null : this.getPieceNo2().equals(other.getPieceNo2()))
            && (this.getHeatNo1() == null ? other.getHeatNo1() == null : this.getHeatNo1().equals(other.getHeatNo1()))
            && (this.getHeatNo2() == null ? other.getHeatNo2() == null : this.getHeatNo2().equals(other.getHeatNo2()))
            && (this.getAlterCode() == null ? other.getAlterCode() == null : this.getAlterCode().equals(other.getAlterCode()))
            && (this.getAlterType() == null ? other.getAlterType() == null : this.getAlterType().equals(other.getAlterType()))
            && (this.getDailyNo() == null ? other.getDailyNo() == null : this.getDailyNo().equals(other.getDailyNo()))
            && (this.getHardessRec() == null ? other.getHardessRec() == null : this.getHardessRec().equals(other.getHardessRec()))
            && (this.getHeatRec() == null ? other.getHeatRec() == null : this.getHeatRec().equals(other.getHeatRec()))
            && (this.getRtLot() == null ? other.getRtLot() == null : this.getRtLot().equals(other.getRtLot()))
            && (this.getRtSample() == null ? other.getRtSample() == null : this.getRtSample().equals(other.getRtSample()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_line_weld
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPipeId() == null) ? 0 : getPipeId().hashCode());
        result = prime * result + ((getPageCode() == null) ? 0 : getPageCode().hashCode());
        result = prime * result + ((getJiont() == null) ? 0 : getJiont().hashCode());
        result = prime * result + ((getWpsno() == null) ? 0 : getWpsno().hashCode());
        result = prime * result + ((getJlocation() == null) ? 0 : getJlocation().hashCode());
        result = prime * result + ((getJclass() == null) ? 0 : getJclass().hashCode());
        result = prime * result + ((getFinishDate() == null) ? 0 : getFinishDate().hashCode());
        result = prime * result + ((getJsize() == null) ? 0 : getJsize().hashCode());
        result = prime * result + ((getThickness() == null) ? 0 : getThickness().hashCode());
        result = prime * result + ((getJtype() == null) ? 0 : getJtype().hashCode());
        result = prime * result + ((getWeldingProcess() == null) ? 0 : getWeldingProcess().hashCode());
        result = prime * result + ((getFixedRotat() == null) ? 0 : getFixedRotat().hashCode());
        result = prime * result + ((getRootWelder() == null) ? 0 : getRootWelder().hashCode());
        result = prime * result + ((getExamitem() == null) ? 0 : getExamitem().hashCode());
        result = prime * result + ((getCoverWelder() == null) ? 0 : getCoverWelder().hashCode());
        result = prime * result + ((getVisual() == null) ? 0 : getVisual().hashCode());
        result = prime * result + ((getPieceNo1() == null) ? 0 : getPieceNo1().hashCode());
        result = prime * result + ((getWeldingMatial() == null) ? 0 : getWeldingMatial().hashCode());
        result = prime * result + ((getPieceNo2() == null) ? 0 : getPieceNo2().hashCode());
        result = prime * result + ((getHeatNo1() == null) ? 0 : getHeatNo1().hashCode());
        result = prime * result + ((getHeatNo2() == null) ? 0 : getHeatNo2().hashCode());
        result = prime * result + ((getAlterCode() == null) ? 0 : getAlterCode().hashCode());
        result = prime * result + ((getAlterType() == null) ? 0 : getAlterType().hashCode());
        result = prime * result + ((getDailyNo() == null) ? 0 : getDailyNo().hashCode());
        result = prime * result + ((getHardessRec() == null) ? 0 : getHardessRec().hashCode());
        result = prime * result + ((getHeatRec() == null) ? 0 : getHeatRec().hashCode());
        result = prime * result + ((getRtLot() == null) ? 0 : getRtLot().hashCode());
        result = prime * result + ((getRtSample() == null) ? 0 : getRtSample().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }
}