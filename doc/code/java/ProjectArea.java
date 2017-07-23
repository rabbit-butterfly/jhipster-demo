package java;

import java.io.Serializable;

/**
 * 分包项目：项目的子表
 * 
 * @author 菠萝大象
 * @version 1.0 2017-07-23
 */
public class ProjectArea implements Serializable {
    private Long id;

    private Long compId;

    private Long projId;

    private String name;

    private String enName;

    private String unitCode;

    private String subConstractor;

    private byte[] areaCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table project_area
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_area.ID
     *
     * @return the value of project_area.ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_area.ID
     *
     * @param id the value for project_area.ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_area.COMP_ID
     *
     * @return the value of project_area.COMP_ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Long getCompId() {
        return compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_area.COMP_ID
     *
     * @param compId the value for project_area.COMP_ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setCompId(Long compId) {
        this.compId = compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_area.PROJ_ID
     *
     * @return the value of project_area.PROJ_ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Long getProjId() {
        return projId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_area.PROJ_ID
     *
     * @param projId the value for project_area.PROJ_ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setProjId(Long projId) {
        this.projId = projId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_area.NAME
     *
     * @return the value of project_area.NAME
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_area.NAME
     *
     * @param name the value for project_area.NAME
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_area.EN_NAME
     *
     * @return the value of project_area.EN_NAME
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getEnName() {
        return enName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_area.EN_NAME
     *
     * @param enName the value for project_area.EN_NAME
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_area.UNIT_CODE
     *
     * @return the value of project_area.UNIT_CODE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getUnitCode() {
        return unitCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_area.UNIT_CODE
     *
     * @param unitCode the value for project_area.UNIT_CODE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode == null ? null : unitCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_area.SUB_CONSTRACTOR
     *
     * @return the value of project_area.SUB_CONSTRACTOR
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getSubConstractor() {
        return subConstractor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_area.SUB_CONSTRACTOR
     *
     * @param subConstractor the value for project_area.SUB_CONSTRACTOR
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setSubConstractor(String subConstractor) {
        this.subConstractor = subConstractor == null ? null : subConstractor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_area.AREA_CODE
     *
     * @return the value of project_area.AREA_CODE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public byte[] getAreaCode() {
        return areaCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_area.AREA_CODE
     *
     * @param areaCode the value for project_area.AREA_CODE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setAreaCode(byte[] areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_area
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
        ProjectArea other = (ProjectArea) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompId() == null ? other.getCompId() == null : this.getCompId().equals(other.getCompId()))
            && (this.getProjId() == null ? other.getProjId() == null : this.getProjId().equals(other.getProjId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getEnName() == null ? other.getEnName() == null : this.getEnName().equals(other.getEnName()))
            && (this.getUnitCode() == null ? other.getUnitCode() == null : this.getUnitCode().equals(other.getUnitCode()))
            && (this.getSubConstractor() == null ? other.getSubConstractor() == null : this.getSubConstractor().equals(other.getSubConstractor()))
            && (this.getAreaCode() == null ? other.getAreaCode() == null : this.getAreaCode().equals(other.getAreaCode()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_area
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompId() == null) ? 0 : getCompId().hashCode());
        result = prime * result + ((getProjId() == null) ? 0 : getProjId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getEnName() == null) ? 0 : getEnName().hashCode());
        result = prime * result + ((getUnitCode() == null) ? 0 : getUnitCode().hashCode());
        result = prime * result + ((getSubConstractor() == null) ? 0 : getSubConstractor().hashCode());
        result = prime * result + ((getAreaCode() == null) ? 0 : getAreaCode().hashCode());
        return result;
    }
}