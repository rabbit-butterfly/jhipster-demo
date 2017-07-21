package java;

import java.io.Serializable;
import java.util.Date;

/**
 * 抽检比例设置表
 * 
 * @author 菠萝大象
 * @version 1.0 2017-07-18
 */
public class PpIinspectionTatio implements Serializable {
    private Long id;

    private Long compId;

    private Long projId;

    /**
     * I III IV
     */
    private String inspectionCode;

    private Long rtRate;

    private Long rtRateGd;

    private String rtStandard;

    /**
     * @ I III IV
     */
    private String rtGrade;

    private Long ptRate;

    private String ptStandard;

    private String ptGrade;

    private Long utRate;

    private String utStandard;

    private String utGrade;

    private Long mtRate;

    private String mtStandard;

    private String mtGrade;

    private Date createTime;

    private Integer delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pp_inspection_ratio
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_ratio.ID
     *
     * @return the value of pp_inspection_ratio.ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_ratio.ID
     *
     * @param id the value for pp_inspection_ratio.ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_ratio.COMP_ID
     *
     * @return the value of pp_inspection_ratio.COMP_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getCompId() {
        return compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_ratio.COMP_ID
     *
     * @param compId the value for pp_inspection_ratio.COMP_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setCompId(Long compId) {
        this.compId = compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_ratio.PROJ_ID
     *
     * @return the value of pp_inspection_ratio.PROJ_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getProjId() {
        return projId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_ratio.PROJ_ID
     *
     * @param projId the value for pp_inspection_ratio.PROJ_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setProjId(Long projId) {
        this.projId = projId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_ratio.INSPECTION_CODE
     *
     * @return the value of pp_inspection_ratio.INSPECTION_CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getInspectionCode() {
        return inspectionCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_ratio.INSPECTION_CODE
     *
     * @param inspectionCode the value for pp_inspection_ratio.INSPECTION_CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setInspectionCode(String inspectionCode) {
        this.inspectionCode = inspectionCode == null ? null : inspectionCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_ratio.RT_RATE
     *
     * @return the value of pp_inspection_ratio.RT_RATE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getRtRate() {
        return rtRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_ratio.RT_RATE
     *
     * @param rtRate the value for pp_inspection_ratio.RT_RATE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setRtRate(Long rtRate) {
        this.rtRate = rtRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_ratio.RT_RATE_GD
     *
     * @return the value of pp_inspection_ratio.RT_RATE_GD
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getRtRateGd() {
        return rtRateGd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_ratio.RT_RATE_GD
     *
     * @param rtRateGd the value for pp_inspection_ratio.RT_RATE_GD
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setRtRateGd(Long rtRateGd) {
        this.rtRateGd = rtRateGd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_ratio.RT_STANDARD
     *
     * @return the value of pp_inspection_ratio.RT_STANDARD
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getRtStandard() {
        return rtStandard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_ratio.RT_STANDARD
     *
     * @param rtStandard the value for pp_inspection_ratio.RT_STANDARD
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setRtStandard(String rtStandard) {
        this.rtStandard = rtStandard == null ? null : rtStandard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_ratio.RT_GRADE
     *
     * @return the value of pp_inspection_ratio.RT_GRADE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getRtGrade() {
        return rtGrade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_ratio.RT_GRADE
     *
     * @param rtGrade the value for pp_inspection_ratio.RT_GRADE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setRtGrade(String rtGrade) {
        this.rtGrade = rtGrade == null ? null : rtGrade.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_ratio.PT_RATE
     *
     * @return the value of pp_inspection_ratio.PT_RATE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getPtRate() {
        return ptRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_ratio.PT_RATE
     *
     * @param ptRate the value for pp_inspection_ratio.PT_RATE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setPtRate(Long ptRate) {
        this.ptRate = ptRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_ratio.PT_STANDARD
     *
     * @return the value of pp_inspection_ratio.PT_STANDARD
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getPtStandard() {
        return ptStandard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_ratio.PT_STANDARD
     *
     * @param ptStandard the value for pp_inspection_ratio.PT_STANDARD
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setPtStandard(String ptStandard) {
        this.ptStandard = ptStandard == null ? null : ptStandard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_ratio.PT_GRADE
     *
     * @return the value of pp_inspection_ratio.PT_GRADE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getPtGrade() {
        return ptGrade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_ratio.PT_GRADE
     *
     * @param ptGrade the value for pp_inspection_ratio.PT_GRADE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setPtGrade(String ptGrade) {
        this.ptGrade = ptGrade == null ? null : ptGrade.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_ratio.UT_RATE
     *
     * @return the value of pp_inspection_ratio.UT_RATE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getUtRate() {
        return utRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_ratio.UT_RATE
     *
     * @param utRate the value for pp_inspection_ratio.UT_RATE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setUtRate(Long utRate) {
        this.utRate = utRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_ratio.UT_STANDARD
     *
     * @return the value of pp_inspection_ratio.UT_STANDARD
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getUtStandard() {
        return utStandard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_ratio.UT_STANDARD
     *
     * @param utStandard the value for pp_inspection_ratio.UT_STANDARD
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setUtStandard(String utStandard) {
        this.utStandard = utStandard == null ? null : utStandard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_ratio.UT_GRADE
     *
     * @return the value of pp_inspection_ratio.UT_GRADE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getUtGrade() {
        return utGrade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_ratio.UT_GRADE
     *
     * @param utGrade the value for pp_inspection_ratio.UT_GRADE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setUtGrade(String utGrade) {
        this.utGrade = utGrade == null ? null : utGrade.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_ratio.MT_RATE
     *
     * @return the value of pp_inspection_ratio.MT_RATE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getMtRate() {
        return mtRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_ratio.MT_RATE
     *
     * @param mtRate the value for pp_inspection_ratio.MT_RATE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setMtRate(Long mtRate) {
        this.mtRate = mtRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_ratio.MT_STANDARD
     *
     * @return the value of pp_inspection_ratio.MT_STANDARD
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getMtStandard() {
        return mtStandard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_ratio.MT_STANDARD
     *
     * @param mtStandard the value for pp_inspection_ratio.MT_STANDARD
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setMtStandard(String mtStandard) {
        this.mtStandard = mtStandard == null ? null : mtStandard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_ratio.MT_GRADE
     *
     * @return the value of pp_inspection_ratio.MT_GRADE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getMtGrade() {
        return mtGrade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_ratio.MT_GRADE
     *
     * @param mtGrade the value for pp_inspection_ratio.MT_GRADE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setMtGrade(String mtGrade) {
        this.mtGrade = mtGrade == null ? null : mtGrade.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_ratio.CREATE_TIME
     *
     * @return the value of pp_inspection_ratio.CREATE_TIME
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_ratio.CREATE_TIME
     *
     * @param createTime the value for pp_inspection_ratio.CREATE_TIME
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_ratio.DEL_FLAG
     *
     * @return the value of pp_inspection_ratio.DEL_FLAG
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_ratio.DEL_FLAG
     *
     * @param delFlag the value for pp_inspection_ratio.DEL_FLAG
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_inspection_ratio
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
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
        PpIinspectionTatio other = (PpIinspectionTatio) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompId() == null ? other.getCompId() == null : this.getCompId().equals(other.getCompId()))
            && (this.getProjId() == null ? other.getProjId() == null : this.getProjId().equals(other.getProjId()))
            && (this.getInspectionCode() == null ? other.getInspectionCode() == null : this.getInspectionCode().equals(other.getInspectionCode()))
            && (this.getRtRate() == null ? other.getRtRate() == null : this.getRtRate().equals(other.getRtRate()))
            && (this.getRtRateGd() == null ? other.getRtRateGd() == null : this.getRtRateGd().equals(other.getRtRateGd()))
            && (this.getRtStandard() == null ? other.getRtStandard() == null : this.getRtStandard().equals(other.getRtStandard()))
            && (this.getRtGrade() == null ? other.getRtGrade() == null : this.getRtGrade().equals(other.getRtGrade()))
            && (this.getPtRate() == null ? other.getPtRate() == null : this.getPtRate().equals(other.getPtRate()))
            && (this.getPtStandard() == null ? other.getPtStandard() == null : this.getPtStandard().equals(other.getPtStandard()))
            && (this.getPtGrade() == null ? other.getPtGrade() == null : this.getPtGrade().equals(other.getPtGrade()))
            && (this.getUtRate() == null ? other.getUtRate() == null : this.getUtRate().equals(other.getUtRate()))
            && (this.getUtStandard() == null ? other.getUtStandard() == null : this.getUtStandard().equals(other.getUtStandard()))
            && (this.getUtGrade() == null ? other.getUtGrade() == null : this.getUtGrade().equals(other.getUtGrade()))
            && (this.getMtRate() == null ? other.getMtRate() == null : this.getMtRate().equals(other.getMtRate()))
            && (this.getMtStandard() == null ? other.getMtStandard() == null : this.getMtStandard().equals(other.getMtStandard()))
            && (this.getMtGrade() == null ? other.getMtGrade() == null : this.getMtGrade().equals(other.getMtGrade()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_inspection_ratio
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompId() == null) ? 0 : getCompId().hashCode());
        result = prime * result + ((getProjId() == null) ? 0 : getProjId().hashCode());
        result = prime * result + ((getInspectionCode() == null) ? 0 : getInspectionCode().hashCode());
        result = prime * result + ((getRtRate() == null) ? 0 : getRtRate().hashCode());
        result = prime * result + ((getRtRateGd() == null) ? 0 : getRtRateGd().hashCode());
        result = prime * result + ((getRtStandard() == null) ? 0 : getRtStandard().hashCode());
        result = prime * result + ((getRtGrade() == null) ? 0 : getRtGrade().hashCode());
        result = prime * result + ((getPtRate() == null) ? 0 : getPtRate().hashCode());
        result = prime * result + ((getPtStandard() == null) ? 0 : getPtStandard().hashCode());
        result = prime * result + ((getPtGrade() == null) ? 0 : getPtGrade().hashCode());
        result = prime * result + ((getUtRate() == null) ? 0 : getUtRate().hashCode());
        result = prime * result + ((getUtStandard() == null) ? 0 : getUtStandard().hashCode());
        result = prime * result + ((getUtGrade() == null) ? 0 : getUtGrade().hashCode());
        result = prime * result + ((getMtRate() == null) ? 0 : getMtRate().hashCode());
        result = prime * result + ((getMtStandard() == null) ? 0 : getMtStandard().hashCode());
        result = prime * result + ((getMtGrade() == null) ? 0 : getMtGrade().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }
}