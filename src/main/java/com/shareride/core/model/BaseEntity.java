/**
 *
 */
package com.shareride.core.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

/**
 * @author sridhar.reddy
 */
@MappedSuperclass
@FilterDef(name = "isActive", parameters = @ParamDef(name = "isActive", type = "short"))
@Filters({@Filter(name = "isActive", condition = ":isActive = is_active")})
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Version
    @Column(name = "version")
    private int version;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private Date ts_created = new Date();
    @Column(nullable = true)
    private Date ts_updated;
    @Column(name = "is_active", columnDefinition = "tinyint(1) default 1", nullable = false)
    private short isActive = 1;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return ts_created;
    }

    public void setCreatedAt(Date ts_created) {
        this.ts_created = ts_created;
    }

    public Date getUpdatedAt() {
        return ts_updated;
    }

    public void setUpdatedAt(Date ts_updated) {
        this.ts_updated = ts_updated;
    }

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        if (isActive) {
            setIsActive((short) 1);
        } else {
            setIsActive((short) 0);
        }
    }

    void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    @PrePersist
    public void setDefaultFields() {
        Date date = getCurrentDate();
        ts_created = date;
        ts_updated = date;
    }

    @PreUpdate
    public void setUpdatedDate() {
        ts_updated = getCurrentDate();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((int) id ^ ((int) id >>> 31));
        result = prime * result + ((isActive == 1) ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof BaseEntity)) return false;
        BaseEntity other = (BaseEntity) obj;
        if (id != other.id) return false;
        return isActive == other.isActive;
    }

    public boolean isActive() {
        return isActive != 0;
    }

    @Override
    public String toString() {
        return "BaseEntity" + "{ id=" + id + ", isActive=" + isActive + " }\n";
    }

    private Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }
}