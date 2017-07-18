package com.rd.pcms.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the PpLineWeld entity.
 */
public class PpLineWeldDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    private String pipeId;

    @Size(min = 0, max = 20)
    private String pageCode;

    @Size(min = 0, max = 50)
    private String jiont;

    @Size(min = 0, max = 32)
    private String wpsno;

    @Size(min = 0, max = 50)
    private String jlocation;

    @Size(min = 0, max = 50)
    private String jclass;

    private Instant finishDate;

    @Size(min = 0, max = 5)
    private String jsize;

    @Size(min = 0, max = 50)
    private String thickness;

    @Size(min = 0, max = 20)
    private String jtype;

    @Size(min = 0, max = 50)
    private String weldingProcess;

    @Size(min = 0, max = 50)
    private String fixedRotat;

    @Size(min = 0, max = 50)
    private String rootWelder;

    @Size(min = 0, max = 32)
    private String examitem;

    @Size(min = 0, max = 50)
    private String coverWelder;

    @Size(min = 0, max = 19)
    private String visual;

    @Size(min = 0, max = 50)
    private String pieceNo1;

    @Size(min = 0, max = 50)
    private String weldingMatial;

    @Size(min = 0, max = 50)
    private String pieceNo2;

    @Size(min = 0, max = 64)
    private String heatNo1;

    @Size(min = 0, max = 64)
    private String heatNo2;

    @Size(min = 0, max = 64)
    private String alterCode;

    @Size(min = 0, max = 64)
    private String alterType;

    @Size(min = 0, max = 20)
    private String dailyNo;

    @Size(min = 0, max = 50)
    private String hardessRec;

    @Size(min = 0, max = 64)
    private String heatRec;

    @Size(min = 0, max = 50)
    private String rtLot;

    @Size(min = 0, max = 50)
    private String rtSample;

    @Size(min = 0, max = 500)
    private String remark;

    @NotNull
    private Instant createTime;

    @Min(value = 0)
    @Max(value = 10)
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

    public void setPipeId(String pipeId) {
        this.pipeId = pipeId;
    }

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    public String getJiont() {
        return jiont;
    }

    public void setJiont(String jiont) {
        this.jiont = jiont;
    }

    public String getWpsno() {
        return wpsno;
    }

    public void setWpsno(String wpsno) {
        this.wpsno = wpsno;
    }

    public String getJlocation() {
        return jlocation;
    }

    public void setJlocation(String jlocation) {
        this.jlocation = jlocation;
    }

    public String getJclass() {
        return jclass;
    }

    public void setJclass(String jclass) {
        this.jclass = jclass;
    }

    public Instant getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Instant finishDate) {
        this.finishDate = finishDate;
    }

    public String getJsize() {
        return jsize;
    }

    public void setJsize(String jsize) {
        this.jsize = jsize;
    }

    public String getThickness() {
        return thickness;
    }

    public void setThickness(String thickness) {
        this.thickness = thickness;
    }

    public String getJtype() {
        return jtype;
    }

    public void setJtype(String jtype) {
        this.jtype = jtype;
    }

    public String getWeldingProcess() {
        return weldingProcess;
    }

    public void setWeldingProcess(String weldingProcess) {
        this.weldingProcess = weldingProcess;
    }

    public String getFixedRotat() {
        return fixedRotat;
    }

    public void setFixedRotat(String fixedRotat) {
        this.fixedRotat = fixedRotat;
    }

    public String getRootWelder() {
        return rootWelder;
    }

    public void setRootWelder(String rootWelder) {
        this.rootWelder = rootWelder;
    }

    public String getExamitem() {
        return examitem;
    }

    public void setExamitem(String examitem) {
        this.examitem = examitem;
    }

    public String getCoverWelder() {
        return coverWelder;
    }

    public void setCoverWelder(String coverWelder) {
        this.coverWelder = coverWelder;
    }

    public String getVisual() {
        return visual;
    }

    public void setVisual(String visual) {
        this.visual = visual;
    }

    public String getPieceNo1() {
        return pieceNo1;
    }

    public void setPieceNo1(String pieceNo1) {
        this.pieceNo1 = pieceNo1;
    }

    public String getWeldingMatial() {
        return weldingMatial;
    }

    public void setWeldingMatial(String weldingMatial) {
        this.weldingMatial = weldingMatial;
    }

    public String getPieceNo2() {
        return pieceNo2;
    }

    public void setPieceNo2(String pieceNo2) {
        this.pieceNo2 = pieceNo2;
    }

    public String getHeatNo1() {
        return heatNo1;
    }

    public void setHeatNo1(String heatNo1) {
        this.heatNo1 = heatNo1;
    }

    public String getHeatNo2() {
        return heatNo2;
    }

    public void setHeatNo2(String heatNo2) {
        this.heatNo2 = heatNo2;
    }

    public String getAlterCode() {
        return alterCode;
    }

    public void setAlterCode(String alterCode) {
        this.alterCode = alterCode;
    }

    public String getAlterType() {
        return alterType;
    }

    public void setAlterType(String alterType) {
        this.alterType = alterType;
    }

    public String getDailyNo() {
        return dailyNo;
    }

    public void setDailyNo(String dailyNo) {
        this.dailyNo = dailyNo;
    }

    public String getHardessRec() {
        return hardessRec;
    }

    public void setHardessRec(String hardessRec) {
        this.hardessRec = hardessRec;
    }

    public String getHeatRec() {
        return heatRec;
    }

    public void setHeatRec(String heatRec) {
        this.heatRec = heatRec;
    }

    public String getRtLot() {
        return rtLot;
    }

    public void setRtLot(String rtLot) {
        this.rtLot = rtLot;
    }

    public String getRtSample() {
        return rtSample;
    }

    public void setRtSample(String rtSample) {
        this.rtSample = rtSample;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
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

        PpLineWeldDTO ppLineWeldDTO = (PpLineWeldDTO) o;
        if(ppLineWeldDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppLineWeldDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpLineWeldDTO{" +
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
