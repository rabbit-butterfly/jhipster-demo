package local.tux.app.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A Project.
 */
@Entity
@Table(name = "project")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "project")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_comp_id")
    private String projectCompId;

    @Column(name = "project_comp_name")
    private String projectCompName;

    @Column(name = "project_bame")
    private String projectBame;

    @Column(name = "project_desc")
    private String projectDesc;

    @Column(name = "project_status")
    private Integer projectStatus;

    @Column(name = "supervisor_comp_id")
    private Long supervisorCompId;

    @Column(name = "supervisor_comp_name")
    private String supervisorCompName;

    @Column(name = "contractor_comp_id")
    private Long contractorCompId;

    @Column(name = "contractor_comp_name")
    private String contractorCompName;

    @Column(name = "start_date")
    private Instant startDate;

    @Column(name = "end_date")
    private Instant endDate;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_time")
    private Instant createdTime;

    @Column(name = "modify_by")
    private Long modifyBy;

    @Column(name = "modify_time")
    private Instant modifyTime;

    @Column(name = "del_flag")
    private String delFlag;

    @Column(name = "remark")
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectCompId() {
        return projectCompId;
    }

    public Project projectCompId(String projectCompId) {
        this.projectCompId = projectCompId;
        return this;
    }

    public void setProjectCompId(String projectCompId) {
        this.projectCompId = projectCompId;
    }

    public String getProjectCompName() {
        return projectCompName;
    }

    public Project projectCompName(String projectCompName) {
        this.projectCompName = projectCompName;
        return this;
    }

    public void setProjectCompName(String projectCompName) {
        this.projectCompName = projectCompName;
    }

    public String getProjectBame() {
        return projectBame;
    }

    public Project projectBame(String projectBame) {
        this.projectBame = projectBame;
        return this;
    }

    public void setProjectBame(String projectBame) {
        this.projectBame = projectBame;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public Project projectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
        return this;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public Integer getProjectStatus() {
        return projectStatus;
    }

    public Project projectStatus(Integer projectStatus) {
        this.projectStatus = projectStatus;
        return this;
    }

    public void setProjectStatus(Integer projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Long getSupervisorCompId() {
        return supervisorCompId;
    }

    public Project supervisorCompId(Long supervisorCompId) {
        this.supervisorCompId = supervisorCompId;
        return this;
    }

    public void setSupervisorCompId(Long supervisorCompId) {
        this.supervisorCompId = supervisorCompId;
    }

    public String getSupervisorCompName() {
        return supervisorCompName;
    }

    public Project supervisorCompName(String supervisorCompName) {
        this.supervisorCompName = supervisorCompName;
        return this;
    }

    public void setSupervisorCompName(String supervisorCompName) {
        this.supervisorCompName = supervisorCompName;
    }

    public Long getContractorCompId() {
        return contractorCompId;
    }

    public Project contractorCompId(Long contractorCompId) {
        this.contractorCompId = contractorCompId;
        return this;
    }

    public void setContractorCompId(Long contractorCompId) {
        this.contractorCompId = contractorCompId;
    }

    public String getContractorCompName() {
        return contractorCompName;
    }

    public Project contractorCompName(String contractorCompName) {
        this.contractorCompName = contractorCompName;
        return this;
    }

    public void setContractorCompName(String contractorCompName) {
        this.contractorCompName = contractorCompName;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public Project startDate(Instant startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public Project endDate(Instant endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public Project createdBy(Long createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedTime() {
        return createdTime;
    }

    public Project createdTime(Instant createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public void setCreatedTime(Instant createdTime) {
        this.createdTime = createdTime;
    }

    public Long getModifyBy() {
        return modifyBy;
    }

    public Project modifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
        return this;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Instant getModifyTime() {
        return modifyTime;
    }

    public Project modifyTime(Instant modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public void setModifyTime(Instant modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public Project delFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemark() {
        return remark;
    }

    public Project remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Project project = (Project) o;
        if (project.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), project.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Project{" +
            "id=" + getId() +
            ", projectCompId='" + getProjectCompId() + "'" +
            ", projectCompName='" + getProjectCompName() + "'" +
            ", projectBame='" + getProjectBame() + "'" +
            ", projectDesc='" + getProjectDesc() + "'" +
            ", projectStatus='" + getProjectStatus() + "'" +
            ", supervisorCompId='" + getSupervisorCompId() + "'" +
            ", supervisorCompName='" + getSupervisorCompName() + "'" +
            ", contractorCompId='" + getContractorCompId() + "'" +
            ", contractorCompName='" + getContractorCompName() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdTime='" + getCreatedTime() + "'" +
            ", modifyBy='" + getModifyBy() + "'" +
            ", modifyTime='" + getModifyTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            ", remark='" + getRemark() + "'" +
            "}";
    }
}
