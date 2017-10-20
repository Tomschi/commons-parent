package com.github.tomschi.commons.data.dbo.jpa;

/**
 * The interface {@link JpaSequenceDbo} is the base interface for
 * all JPA based database objects, where the id is generated by a
 * database sequence. The id is of type {@link Long}.
 *
 * @author Tomschi
 * @since 0.1.0
 */
public interface JpaSequenceDbo extends JpaDatabaseObject<Long> {
}
