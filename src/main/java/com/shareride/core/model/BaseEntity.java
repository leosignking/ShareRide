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
 *
 */
@MappedSuperclass
@FilterDef(name = "isActive", parameters = @ParamDef(name = "isActive", type = "short"))
@Filters({ @Filter(name = "isActive", condition = ":isActive = is_active") })
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id 
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private Date ts_created = new Date();

    @Column(nullable = true)
    private Date ts_updated;

	@Version
	@Column(name = "version")
	public int version;

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
        result = prime * result +  ((int)id ^ ((int)id >>> 32));
        result = prime * result ;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof BaseEntity)) return false;
        BaseEntity other = (BaseEntity) obj;
        if (id != other.id) return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BaseEntity");
        sb.append("{ id=").append(id);
        sb.append(" }\n");
        return sb.toString();
    }

    private Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }
}