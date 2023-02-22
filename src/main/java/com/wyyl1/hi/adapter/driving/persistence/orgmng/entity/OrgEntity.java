package com.wyyl1.hi.adapter.driving.persistence.orgmng.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * OrgEntity: 数据映射实体定义
 *
 * @author Powered By Fluent Mybatis
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Data
@Accessors(
    chain = true
)
@EqualsAndHashCode(
    callSuper = false
)
@AllArgsConstructor
@NoArgsConstructor
@FluentMybatis(
    table = "org",
    schema = "geektime-ddd",
    useDao = false,
    desc = "组织"
)
public class OrgEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  @TableId(
      value = "id",
      auto = false
  )
  private Integer id;

  @TableField("tenant_id")
  private Integer tenantId;

  @TableField(
      value = "superior_id",
      desc = "上级 id"
  )
  private Integer superiorId;

  @TableField(
      value = "org_type_code",
      desc = "组织类别代号"
  )
  private String orgTypeCode;

  @TableField(
      value = "leader_id",
      desc = "负责人 id"
  )
  private Integer leaderId;

  @TableField("name")
  private String name;

  @TableField("create_at")
  private Date createAt;

  @TableField("create_by")
  private Integer createBy;

  @TableField("last_updated_at")
  private Date lastUpdatedAt;

  @TableField("last_updated_by")
  private Integer lastUpdatedBy;

  @Override
  public final Class entityClass() {
    return OrgEntity.class;
  }
}
