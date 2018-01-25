package com.github.tomschi.commons.data.dbo.jpa;

/**
 * The abstract class {@link AbstractJpaDatabaseObject} can be
 * used for database objects using a database sequence for generating
 * id. The id is of type {@link Long}.
 *
 * @author Tomschi
 * @see AbstractJpaDatabaseObject
 * @since 0.1.0
 */
@Deprecated
public abstract class AbstractJpaSequenceDbo extends AbstractJpaDatabaseObject<Long> implements JpaSequenceDbo {

    private static final long serialVersionUID = 1L;

}
