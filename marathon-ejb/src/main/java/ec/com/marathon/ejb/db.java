package ec.com.marathon.ejb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * Clase generica de la conexion de la Base de datos - MYSQL
 *
 * @param <T>
 * @since 2016-10-10
 */
public abstract class db<T> {

    private Class<T> entityClass;

    @PersistenceContext(unitName = "Marathon-ejbPU")
    private EntityManager entityManager;

    public db(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Método que permite crear un nuevo registro
     *
     * @param entity T Entidad mapeada de la base de datos
     * @throws java.lang.Exception
     */
    public void create(T entity) throws Exception {
        try {
            getEntityManager().persist(entity);
            getEntityManager().flush();
            System.out.println("Crear " + entity);

            //Limpiar la entidad
            cleanEntity(entity);
        } catch (ConstraintViolationException e) {
            for (ConstraintViolation actual : e.getConstraintViolations()) {
                System.out.println("ConstraintViolation - " + actual.toString());
            }
        }
    }

    /**
     * Método que permite editar un registro
     *
     * @param entity T Entidad mapeada de la base de datos
     */
    public void edit(T entity) throws Exception {
        try {
            getEntityManager().merge(entity);
            getEntityManager().flush();
            System.out.println("Editar " + entity);
            //Limpiar la entidad
            cleanEntity(entity);
        } catch (ConstraintViolationException e) {
            for (ConstraintViolation actual : e.getConstraintViolations()) {
                System.out.println("ConstraintViolation - " + actual.toString());
            }
        }
    }

    /**
     * Método que permite eliminar un registro
     *
     * @param entity T Entidad mapeada de la base de datos
     */
    public void remove(T entity) {
        System.out.println("Editar " + entity);
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Busqueda por ID un registro determinador por la clave primaria
     *
     * @param id Objecto que representa la clave primaria del registro a buscar
     * @return Retorna la entidad con los valores del registro
     */
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     * Obtiene un listado con todos los registro de la entidad requerida
     *
     * @return listado de registros
     */
    public List<T> findAll() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery cq = cb.createQuery(entityClass);
        Root<T> root = cq.from(entityClass);
        try {
            if (root.get("id") != null) {
                cq.orderBy(cb.asc(root.get("id")));
            }
        } catch (Exception e) {
        }
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void execute(String execute) {
        entityManager.createNativeQuery(execute)
                .executeUpdate();
    }

    /**
     * Método que permite limpiar la Entidad para que los nuevos registros
     * creados se actualicen
     *
     * @param entity
     */
    public void cleanEntity(T entity) {
        try {
            //Limpiar por Entidad, para que realice la consulta a la Base
            getEntityManager().getEntityManagerFactory().getCache().evict(entity.getClass());
        } catch (Exception e) {
            System.out.println("Error cleanEntity - " + e.getMessage());
        }
    }
}
