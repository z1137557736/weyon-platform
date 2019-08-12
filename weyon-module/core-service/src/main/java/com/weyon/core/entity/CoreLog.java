package com.weyon.core.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_core_log")
public class CoreLog implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "OPERATOR")
    private String operator;

    @Column(name = "OPERATOR_ID")
    private String operatorId;

    @Column(name = "OPERATE_TYPE")
    private String operateType;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "NEW_DATA_ID")
    private String newDataId;

    @Column(name = "OLD_DATA_ID")
    private String oldDataId;

    @Column(name = "STUDENT_ID")
    private String studentId;

    private static final long serialVersionUID = 1L;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return OPERATOR
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * @return OPERATOR_ID
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * @param operatorId
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    /**
     * @return OPERATE_TYPE
     */
    public String getOperateType() {
        return operateType;
    }

    /**
     * @param operateType
     */
    public void setOperateType(String operateType) {
        this.operateType = operateType == null ? null : operateType.trim();
    }

    /**
     * @return NOTE
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return NEW_DATA_ID
     */
    public String getNewDataId() {
        return newDataId;
    }

    /**
     * @param newDataId
     */
    public void setNewDataId(String newDataId) {
        this.newDataId = newDataId == null ? null : newDataId.trim();
    }

    /**
     * @return OLD_DATA_ID
     */
    public String getOldDataId() {
        return oldDataId;
    }

    /**
     * @param oldDataId
     */
    public void setOldDataId(String oldDataId) {
        this.oldDataId = oldDataId == null ? null : oldDataId.trim();
    }

    /**
     * @return STUDENT_ID
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }
}