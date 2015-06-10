/**
 *
 */
package com.shareride.core.dao;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.shareride.core.model.BaseEntity;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sridhar.reddy
 *
 */
@Repository("baseDao")
@Transactional(readOnly=true)
public class BaseDao {

    private static final Logger log = LoggerFactory.getLogger(BaseDao.class);

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManagerForNonActiveEntities() {
        Session session = getSession();
        session.enableFilter("isActive").setParameter("isActive", (short) 0);
        return entityManager;
    }

    public EntityManager getEntityManagerForActiveEntities() {
        Session session = getSession();
        session.enableFilter("isActive").setParameter("isActive", (short) 1);
        return entityManager;
    }

    public EntityManager getEntityManagerWithoutFilter() {
        Session session = getSession();
        session.disableFilter("isActive");
        return entityManager;
    }

    private Session getSession() {
        Session session = entityManager.unwrap(Session.class);
        return session;
    }

    public void create(BaseEntity entity) {
        getEntityManagerForActiveEntities().persist(entity);
    }

    public void createAll(final Collection entities){
        for (Iterator it = entities.iterator(); it.hasNext();) {
            create((BaseEntity) it.next());
        }
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> list(Class<T> entityClass) {
        Session session = (Session) getEntityManagerForActiveEntities().getDelegate();
        List<T> list = session.createCriteria(entityClass).list();
        return list;
    }

    public <T> T find(Class<T> entityClass, long primaryKey) {
        return find(entityClass, primaryKey, true);
    }

    public <T> T find(Class<T> entityClass, long primaryKey, boolean forActiveEntities) {
        log.trace("BaseDao.find for Entity {} primaryKey {} forActive {}", entityClass, primaryKey, forActiveEntities);
        T result = getEntityManagerForActiveEntities().find(entityClass, primaryKey);
        if (result == null) {
            return result;
        }
        BaseEntity baseEntity = (BaseEntity) result;
        log.trace("BaseDao.find result={}", baseEntity);
        if (forActiveEntities) {
            if (baseEntity.isActive()) {
                return result;
            } else {
                return null;
            }
        } else {
            if (!baseEntity.isActive()) {
                return result;
            } else {
                return null;
            }
        }
    }

    public <T> T findAny(Class<T> entityClass, long primaryKey) {
        log.trace("BaseDao.findAny(): Class={} , Primary Key={}", entityClass.getName(), primaryKey);
        return getEntityManagerForActiveEntities().find(entityClass, primaryKey);
    }

    public <T> T update(T entity) {
        return getEntityManagerForActiveEntities().merge(entity);
    }

    public void remove(BaseEntity entity) {
        getEntityManagerWithoutFilter().remove(entity);
    }

    public void removeAll(final Collection entities){
        for (Iterator iterator = entities.iterator(); iterator.hasNext();) {
            remove((BaseEntity) iterator.next());
        }
    }

    public void remove(Class<? extends BaseEntity> entityClass, long primaryKey) {
        log.debug("BaseDao.remove(): {} primary key={}", entityClass.getName(), primaryKey);
        BaseEntity entity = getEntityManagerWithoutFilter().find(entityClass, primaryKey);
        if (entity != null) {
            getEntityManagerWithoutFilter().remove(entity);
        }
    }

    public BaseEntity markEntityAsDisabled(BaseEntity baseEntity) {
        baseEntity.setIsActive(false);
        return update(baseEntity);
    }

    public BaseEntity markEntityAsEnabled(BaseEntity baseEntity) {
        baseEntity.setIsActive(true);
        return update(baseEntity);
    }
}
