package com.weyon.core.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "tb_core_field_info")
public class CoreFieldInfo implements Serializable {
    /**
     * 主键id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 所属学校
     */
    @Column(name = "ORG_ID")
    private String orgId;

    /**
     * 所属表名
     */
    @Column(name = "TABLE_NAME")
    private String tableName;

    /**
     * 实体类中字段名
     */
    @Column(name = "FIELD_NAME_OBJ")
    private String fieldNameObj;

    /**
     * 默认字段名
     */
    @Column(name = "FIELD_NAME_DEFAULT")
    private String fieldNameDefault;

    /**
     * 用户看到的字段名
     */
    @Column(name = "FIELD_NAME_USER")
    private String fieldNameUser;

    /**
     * 是否展示给教师 Y N
     */
    @Column(name = "TEACHER_SHOW")
    private String teacherShow;

    /**
     * 是否展示给学生 Y N
     */
    @Column(name = "STUDENT_SHOW")
    private String studentShow;

    /**
     * 教师是否能修改 Y N
     */
    @Column(name = "TEACHER_EDIT")
    private String teacherEdit;

    /**
     * 学生是否能修改 Y N
     */
    @Column(name = "STUDENT_EDIT")
    private String studentEdit;

    /**
     * 教师必填 Y N
     */
    @Column(name = "TEACHER_REQUIRED")
    private String teacherRequired;

    /**
     * 学生必填 Y N
     */
    @Column(name = "STUDENT_REQUIRED")
    private String studentRequired;

    /**
     * 字段类型 单选多选下拉
     */
    @Column(name = "FIELD_TYPE")
    private String fieldType;

    /**
     * 字段类型的选择项信息
     */
    @Column(name = "OPTIONS")
    private String options;

    /**
     * 是否可导出 Y N
     */
    @Column(name = "OUTPUT_FIELD")
    private String outputField;

    /**
     * 字段填写的提示
     */
    @Column(name = "PLACEHOLDER")
    private String placeholder;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键id
     *
     * @return ID - 主键id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取所属学校
     *
     * @return ORG_ID - 所属学校
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 设置所属学校
     *
     * @param orgId 所属学校
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    /**
     * 获取所属表名
     *
     * @return TABLE_NAME - 所属表名
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 设置所属表名
     *
     * @param tableName 所属表名
     */
    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    /**
     * 获取实体类中字段名
     *
     * @return FIELD_NAME_OBJ - 实体类中字段名
     */
    public String getFieldNameObj() {
        return fieldNameObj;
    }

    /**
     * 设置实体类中字段名
     *
     * @param fieldNameObj 实体类中字段名
     */
    public void setFieldNameObj(String fieldNameObj) {
        this.fieldNameObj = fieldNameObj == null ? null : fieldNameObj.trim();
    }

    /**
     * 获取默认字段名
     *
     * @return FIELD_NAME_DEFAULT - 默认字段名
     */
    public String getFieldNameDefault() {
        return fieldNameDefault;
    }

    /**
     * 设置默认字段名
     *
     * @param fieldNameDefault 默认字段名
     */
    public void setFieldNameDefault(String fieldNameDefault) {
        this.fieldNameDefault = fieldNameDefault == null ? null : fieldNameDefault.trim();
    }

    /**
     * 获取用户看到的字段名
     *
     * @return FIELD_NAME_USER - 用户看到的字段名
     */
    public String getFieldNameUser() {
        return fieldNameUser;
    }

    /**
     * 设置用户看到的字段名
     *
     * @param fieldNameUser 用户看到的字段名
     */
    public void setFieldNameUser(String fieldNameUser) {
        this.fieldNameUser = fieldNameUser == null ? null : fieldNameUser.trim();
    }

    /**
     * 获取是否展示给教师 Y N
     *
     * @return TEACHER_SHOW - 是否展示给教师 Y N
     */
    public String getTeacherShow() {
        return teacherShow;
    }

    /**
     * 设置是否展示给教师 Y N
     *
     * @param teacherShow 是否展示给教师 Y N
     */
    public void setTeacherShow(String teacherShow) {
        this.teacherShow = teacherShow == null ? null : teacherShow.trim();
    }

    /**
     * 获取是否展示给学生 Y N
     *
     * @return STUDENT_SHOW - 是否展示给学生 Y N
     */
    public String getStudentShow() {
        return studentShow;
    }

    /**
     * 设置是否展示给学生 Y N
     *
     * @param studentShow 是否展示给学生 Y N
     */
    public void setStudentShow(String studentShow) {
        this.studentShow = studentShow == null ? null : studentShow.trim();
    }

    /**
     * 获取教师是否能修改 Y N
     *
     * @return TEACHER_EDIT - 教师是否能修改 Y N
     */
    public String getTeacherEdit() {
        return teacherEdit;
    }

    /**
     * 设置教师是否能修改 Y N
     *
     * @param teacherEdit 教师是否能修改 Y N
     */
    public void setTeacherEdit(String teacherEdit) {
        this.teacherEdit = teacherEdit == null ? null : teacherEdit.trim();
    }

    /**
     * 获取学生是否能修改 Y N
     *
     * @return STUDENT_EDIT - 学生是否能修改 Y N
     */
    public String getStudentEdit() {
        return studentEdit;
    }

    /**
     * 设置学生是否能修改 Y N
     *
     * @param studentEdit 学生是否能修改 Y N
     */
    public void setStudentEdit(String studentEdit) {
        this.studentEdit = studentEdit == null ? null : studentEdit.trim();
    }

    /**
     * 获取教师必填 Y N
     *
     * @return TEACHER_REQUIRED - 教师必填 Y N
     */
    public String getTeacherRequired() {
        return teacherRequired;
    }

    /**
     * 设置教师必填 Y N
     *
     * @param teacherRequired 教师必填 Y N
     */
    public void setTeacherRequired(String teacherRequired) {
        this.teacherRequired = teacherRequired == null ? null : teacherRequired.trim();
    }

    /**
     * 获取学生必填 Y N
     *
     * @return STUDENT_REQUIRED - 学生必填 Y N
     */
    public String getStudentRequired() {
        return studentRequired;
    }

    /**
     * 设置学生必填 Y N
     *
     * @param studentRequired 学生必填 Y N
     */
    public void setStudentRequired(String studentRequired) {
        this.studentRequired = studentRequired == null ? null : studentRequired.trim();
    }

    /**
     * 获取字段类型 单选多选下拉
     *
     * @return FIELD_TYPE - 字段类型 单选多选下拉
     */
    public String getFieldType() {
        return fieldType;
    }

    /**
     * 设置字段类型 单选多选下拉
     *
     * @param fieldType 字段类型 单选多选下拉
     */
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType == null ? null : fieldType.trim();
    }

    /**
     * 获取字段类型的选择项信息
     *
     * @return OPTIONS - 字段类型的选择项信息
     */
    public String getOptions() {
        return options;
    }

    /**
     * 设置字段类型的选择项信息
     *
     * @param options 字段类型的选择项信息
     */
    public void setOptions(String options) {
        this.options = options == null ? null : options.trim();
    }

    /**
     * 获取是否可导出 Y N
     *
     * @return OUTPUT_FIELD - 是否可导出 Y N
     */
    public String getOutputField() {
        return outputField;
    }

    /**
     * 设置是否可导出 Y N
     *
     * @param outputField 是否可导出 Y N
     */
    public void setOutputField(String outputField) {
        this.outputField = outputField == null ? null : outputField.trim();
    }

    /**
     * 获取字段填写的提示
     *
     * @return PLACEHOLDER - 字段填写的提示
     */
    public String getPlaceholder() {
        return placeholder;
    }

    /**
     * 设置字段填写的提示
     *
     * @param placeholder 字段填写的提示
     */
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder == null ? null : placeholder.trim();
    }
}
