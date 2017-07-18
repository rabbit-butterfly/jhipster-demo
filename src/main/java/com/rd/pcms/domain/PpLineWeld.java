package com.rd.pcms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * 焊接记录表
 * @auther:renntrabbit@foxmail.com
 * @date:Tue Jul 18 17:06:29 CST 2017
 * table:pp_line_weld
 */
@ApiModel(description = "焊接记录表 @auther:renntrabbit@foxmail.com @date:Tue Jul 18 17:06:29 CST 2017 table:pp_line_weld")
@Entity
@Table(name = "pp_line_weld")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PpLineWeld implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    @Column(name = "pipe_id", length = 19, nullable = false)
    private String pipeId;

    /**
     * PIPE_ID
     */
    @Size(min = 0, max = 20)
    @ApiModelProperty(value = "PIPE_ID")
    @Column(name = "page_code", length = 20)
    private String pageCode;

    /**
     * PAGE_CODE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "PAGE_CODE")
    @Column(name = "jiont", length = 50)
    private String jiont;

    /**
     * JIONT
     */
    @Size(min = 0, max = 32)
    @ApiModelProperty(value = "JIONT")
    @Column(name = "wpsno", length = 32)
    private String wpsno;

    /**
     * WPSNO
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "WPSNO")
    @Column(name = "jlocation", length = 50)
    private String jlocation;

    /**
     * JLOCATION
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "JLOCATION")
    @Column(name = "jclass", length = 50)
    private String jclass;

    /**
     * JCLASS
     */
    @ApiModelProperty(value = "JCLASS")
    @Column(name = "finish_date")
    private Instant finishDate;

    /**
     * FINISH_DATE
     */
    @Size(min = 0, max = 5)
    @ApiModelProperty(value = "FINISH_DATE")
    @Column(name = "jsize", length = 5)
    private String jsize;

    /**
     * JSIZE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "JSIZE")
    @Column(name = "thickness", length = 50)
    private String thickness;

    /**
     * 管道壁厚设置表@
     */
    @Size(min = 0, max = 20)
    @ApiModelProperty(value = "管道壁厚设置表@")
    @Column(name = "jtype", length = 20)
    private String jtype;

    /**
     * 数据字典@
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "数据字典@")
    @Column(name = "welding_process", length = 50)
    private String weldingProcess;

    /**
     * 数据字典@
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "数据字典@")
    @Column(name = "fixed_rotat", length = 50)
    private String fixedRotat;

    /**
     * 数据字典@
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "数据字典@")
    @Column(name = "root_welder", length = 50)
    private String rootWelder;

    /**
     * 焊工代号@
     */
    @Size(min = 0, max = 32)
    @ApiModelProperty(value = "焊工代号@")
    @Column(name = "examitem", length = 32)
    private String examitem;

    /**
     * EXAMITEM
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "EXAMITEM")
    @Column(name = "cover_welder", length = 50)
    private String coverWelder;

    /**
     * 焊工代号@
     */
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "焊工代号@")
    @Column(name = "visual", length = 19)
    private String visual;

    /**
     * 数据字典@
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "数据字典@")
    @Column(name = "piece_no_1", length = 50)
    private String pieceNo1;

    /**
     * PIECE_NO1
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "PIECE_NO1")
    @Column(name = "welding_matial", length = 50)
    private String weldingMatial;

    /**
     * WELDING_MATIAL
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "WELDING_MATIAL")
    @Column(name = "piece_no_2", length = 50)
    private String pieceNo2;

    /**
     * PIECE_NO2
     */
    @Size(min = 0, max = 64)
    @ApiModelProperty(value = "PIECE_NO2")
    @Column(name = "heat_no_1", length = 64)
    private String heatNo1;

    /**
     * HEAT_NO1
     */
    @Size(min = 0, max = 64)
    @ApiModelProperty(value = "HEAT_NO1")
    @Column(name = "heat_no_2", length = 64)
    private String heatNo2;

    /**
     * HEAT_NO2
     */
    @Size(min = 0, max = 64)
    @ApiModelProperty(value = "HEAT_NO2")
    @Column(name = "alter_code", length = 64)
    private String alterCode;

    /**
     * ALTER_CODE
     */
    @Size(min = 0, max = 64)
    @ApiModelProperty(value = "ALTER_CODE")
    @Column(name = "alter_type", length = 64)
    private String alterType;

    /**
     * 数据字典@
     */
    @Size(min = 0, max = 20)
    @ApiModelProperty(value = "数据字典@")
    @Column(name = "daily_no", length = 20)
    private String dailyNo;

    /**
     * DAILY_NO
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "DAILY_NO")
    @Column(name = "hardess_rec", length = 50)
    private String hardessRec;

    /**
     * HARDESS_REC
     */
    @Size(min = 0, max = 64)
    @ApiModelProperty(value = "HARDESS_REC")
    @Column(name = "heat_rec", length = 64)
    private String heatRec;

    /**
     * HEAT_REC
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "HEAT_REC")
    @Column(name = "rt_lot", length = 50)
    private String rtLot;

    /**
     * RT_LOT
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "RT_LOT")
    @Column(name = "rt_sample", length = 50)
    private String rtSample;

    /**
     * RT_SAMPLE
     */
    @Size(min = 0, max = 500)
    @ApiModelProperty(value = "RT_SAMPLE")
    @Column(name = "remark", length = 500)
    private String remark;

    /**
     * REMARK
     */
    @NotNull
    @ApiModelProperty(value = "REMARK", required = true)
    @Column(name = "create_time", nullable = false)
    private Instant createTime;

    /**
     * CREATE_TIME
     */
    @Min(value = 0)
    @Max(value = 10)
    @ApiModelProperty(value = "CREATE_TIME")
    @Column(name = "del_flag")
    private Integer delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPipeId() {
        return pipeId;
    }

    public PpLineWeld pipeId(String pipeId) {
        this.pipeId = pipeId;
        return this;
    }

    public void setPipeId(String pipeId) {
        this.pipeId = pipeId;
    }

    public String getPageCode() {
        return pageCode;
    }

    public PpLineWeld pageCode(String pageCode) {
        this.pageCode = pageCode;
        return this;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    public String getJiont() {
        return jiont;
    }

    public PpLineWeld jiont(String jiont) {
        this.jiont = jiont;
        return this;
    }

    public void setJiont(String jiont) {
        this.jiont = jiont;
    }

    public String getWpsno() {
        return wpsno;
    }

    public PpLineWeld wpsno(String wpsno) {
        this.wpsno = wpsno;
        return this;
    }

    public void setWpsno(String wpsno) {
        this.wpsno = wpsno;
    }

    public String getJlocation() {
        return jlocation;
    }

    public PpLineWeld jlocation(String jlocation) {
        this.jlocation = jlocation;
        return this;
    }

    public void setJlocation(String jlocation) {
        this.jlocation = jlocation;
    }

    public String getJclass() {
        return jclass;
    }

    public PpLineWeld jclass(String jclass) {
        this.jclass = jclass;
        return this;
    }

    public void setJclass(String jclass) {
        this.jclass = jclass;
    }

    public Instant getFinishDate() {
        return finishDate;
    }

    public PpLineWeld finishDate(Instant finishDate) {
        this.finishDate = finishDate;
        return this;
    }

    public void setFinishDate(Instant finishDate) {
        this.finishDate = finishDate;
    }

    public String getJsize() {
        return jsize;
    }

    public PpLineWeld jsize(String jsize) {
        this.jsize = jsize;
        return this;
    }

    public void setJsize(String jsize) {
        this.jsize = jsize;
    }

    public String getThickness() {
        return thickness;
    }

    public PpLineWeld thickness(String thickness) {
        this.thickness = thickness;
        return this;
    }

    public void setThickness(String thickness) {
        this.thickness = thickness;
    }

    public String getJtype() {
        return jtype;
    }

    public PpLineWeld jtype(String jtype) {
        this.jtype = jtype;
        return this;
    }

    public void setJtype(String jtype) {
        this.jtype = jtype;
    }

    public String getWeldingProcess() {
        return weldingProcess;
    }

    public PpLineWeld weldingProcess(String weldingProcess) {
        this.weldingProcess = weldingProcess;
        return this;
    }

    public void setWeldingProcess(String weldingProcess) {
        this.weldingProcess = weldingProcess;
    }

    public String getFixedRotat() {
        return fixedRotat;
    }

    public PpLineWeld fixedRotat(String fixedRotat) {
        this.fixedRotat = fixedRotat;
        return this;
    }

    public void setFixedRotat(String fixedRotat) {
        this.fixedRotat = fixedRotat;
    }

    public String getRootWelder() {
        return rootWelder;
    }

    public PpLineWeld rootWelder(String rootWelder) {
        this.rootWelder = rootWelder;
        return this;
    }

    public void setRootWelder(String rootWelder) {
        this.rootWelder = rootWelder;
    }

    public String getExamitem() {
        return examitem;
    }

    public PpLineWeld examitem(String examitem) {
        this.examitem = examitem;
        return this;
    }

    public void setExamitem(String examitem) {
        this.examitem = examitem;
    }

    public String getCoverWelder() {
        return coverWelder;
    }

    public PpLineWeld coverWelder(String coverWelder) {
        this.coverWelder = coverWelder;
        return this;
    }

    public void setCoverWelder(String coverWelder) {
        this.coverWelder = coverWelder;
    }

    public String getVisual() {
        return visual;
    }

    public PpLineWeld visual(String visual) {
        this.visual = visual;
        return this;
    }

    public void setVisual(String visual) {
        this.visual = visual;
    }

    public String getPieceNo1() {
        return pieceNo1;
    }

    public PpLineWeld pieceNo1(String pieceNo1) {
        this.pieceNo1 = pieceNo1;
        return this;
    }

    public void setPieceNo1(String pieceNo1) {
        this.pieceNo1 = pieceNo1;
    }

    public String getWeldingMatial() {
        return weldingMatial;
    }

    public PpLineWeld weldingMatial(String weldingMatial) {
        this.weldingMatial = weldingMatial;
        return this;
    }

    public void setWeldingMatial(String weldingMatial) {
        this.weldingMatial = weldingMatial;
    }

    public String getPieceNo2() {
        return pieceNo2;
    }

    public PpLineWeld pieceNo2(String pieceNo2) {
        this.pieceNo2 = pieceNo2;
        return this;
    }

    public void setPieceNo2(String pieceNo2) {
        this.pieceNo2 = pieceNo2;
    }

    public String getHeatNo1() {
        return heatNo1;
    }

    public PpLineWeld heatNo1(String heatNo1) {
        this.heatNo1 = heatNo1;
        return this;
    }

    public void setHeatNo1(String heatNo1) {
        this.heatNo1 = heatNo1;
    }

    public String getHeatNo2() {
        return heatNo2;
    }

    public PpLineWeld heatNo2(String heatNo2) {
        this.heatNo2 = heatNo2;
        return this;
    }

    public void setHeatNo2(String heatNo2) {
        this.heatNo2 = heatNo2;
    }

    public String getAlterCode() {
        return alterCode;
    }

    public PpLineWeld alterCode(String alterCode) {
        this.alterCode = alterCode;
        return this;
    }

    public void setAlterCode(String alterCode) {
        this.alterCode = alterCode;
    }

    public String getAlterType() {
        return alterType;
    }

    public PpLineWeld alterType(String alterType) {
        this.alterType = alterType;
        return this;
    }

    public void setAlterType(String alterType) {
        this.alterType = alterType;
    }

    public String getDailyNo() {
        return dailyNo;
    }

    public PpLineWeld dailyNo(String dailyNo) {
        this.dailyNo = dailyNo;
        return this;
    }

    public void setDailyNo(String dailyNo) {
        this.dailyNo = dailyNo;
    }

    public String getHardessRec() {
        return hardessRec;
    }

    public PpLineWeld hardessRec(String hardessRec) {
        this.hardessRec = hardessRec;
        return this;
    }

    public void setHardessRec(String hardessRec) {
        this.hardessRec = hardessRec;
    }

    public String getHeatRec() {
        return heatRec;
    }

    public PpLineWeld heatRec(String heatRec) {
        this.heatRec = heatRec;
        return this;
    }

    public void setHeatRec(String heatRec) {
        this.heatRec = heatRec;
    }

    public String getRtLot() {
        return rtLot;
    }

    public PpLineWeld rtLot(String rtLot) {
        this.rtLot = rtLot;
        return this;
    }

    public void setRtLot(String rtLot) {
        this.rtLot = rtLot;
    }

    public String getRtSample() {
        return rtSample;
    }

    public PpLineWeld rtSample(String rtSample) {
        this.rtSample = rtSample;
        return this;
    }

    public void setRtSample(String rtSample) {
        this.rtSample = rtSample;
    }

    public String getRemark() {
        return remark;
    }

    public PpLineWeld remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public PpLineWeld createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public PpLineWeld delFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PpLineWeld ppLineWeld = (PpLineWeld) o;
        if (ppLineWeld.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppLineWeld.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpLineWeld{" +
            "id=" + getId() +
            ", pipeId='" + getPipeId() + "'" +
            ", pageCode='" + getPageCode() + "'" +
            ", jiont='" + getJiont() + "'" +
            ", wpsno='" + getWpsno() + "'" +
            ", jlocation='" + getJlocation() + "'" +
            ", jclass='" + getJclass() + "'" +
            ", finishDate='" + getFinishDate() + "'" +
            ", jsize='" + getJsize() + "'" +
            ", thickness='" + getThickness() + "'" +
            ", jtype='" + getJtype() + "'" +
            ", weldingProcess='" + getWeldingProcess() + "'" +
            ", fixedRotat='" + getFixedRotat() + "'" +
            ", rootWelder='" + getRootWelder() + "'" +
            ", examitem='" + getExamitem() + "'" +
            ", coverWelder='" + getCoverWelder() + "'" +
            ", visual='" + getVisual() + "'" +
            ", pieceNo1='" + getPieceNo1() + "'" +
            ", weldingMatial='" + getWeldingMatial() + "'" +
            ", pieceNo2='" + getPieceNo2() + "'" +
            ", heatNo1='" + getHeatNo1() + "'" +
            ", heatNo2='" + getHeatNo2() + "'" +
            ", alterCode='" + getAlterCode() + "'" +
            ", alterType='" + getAlterType() + "'" +
            ", dailyNo='" + getDailyNo() + "'" +
            ", hardessRec='" + getHardessRec() + "'" +
            ", heatRec='" + getHeatRec() + "'" +
            ", rtLot='" + getRtLot() + "'" +
            ", rtSample='" + getRtSample() + "'" +
            ", remark='" + getRemark() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            "}";
    }
}
