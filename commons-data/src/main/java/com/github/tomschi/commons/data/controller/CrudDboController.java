package com.github.tomschi.commons.data.controller;

import com.github.tomschi.commons.data.dbo.DatabaseObject;
import com.github.tomschi.commons.data.service.CrudDboService;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * The interface {@link CrudDboController} defines methods for all CRUD operations.
 * The methods are the same as in {@link CrudDboService}.
 *
 * @param <T> The type of the {@link DatabaseObject}.
 * @param <ID> The id of the {@link DatabaseObject}.
 *
 * @author Tomschi
 * @since 0.1.2
 */
public interface CrudDboController<T extends DatabaseObject<ID>, ID extends Serializable> extends CrudController<T> {

    /**
     * Returns a {@link List} of all entities of type {@link T} of the given ids.
     * In case no entity was found an empty {@link List} is returned.
     *
     * @param ids An {@link Iterable} of the ids. Cannot be @{literal null}.
     * @return A {@link List} of entities.
     * @throws IllegalArgumentException in case the given {@link Iterable} is {@literal null}.
     */
    List<T> findAll(Iterable<ID> ids);

    /**
     * Returns the entity of type {@link T} with the given {@code id} of type {@link ID}.
     *
     * @param id The id of an entity. Cannot be {@literal null}.
     * @return An {@link Optional} of the entity.
     * @throws IllegalArgumentException in case the given {@code id} is {@literal null}.
     */
    Optional<T> findOne(ID id);

    /**
     * Checks if a entity of type {@link T} with the given {@code id} of type {@link ID} exists.
     *
     * @param id The id of an entity. Cannot be {@literal null}.
     * @return {@literal true} if the entity exists, else {@literal false}.
     * @throws IllegalArgumentException in case the given {@code id} is {@literal null}.
     */
    boolean exists(ID id);

    /**
     * Deletes the entity of type {@link T} with the given {@code id} of type {@link ID}.
     *
     * @param id The id of an entity. Cannot be {@literal null}.
     * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
     */
    void delete(ID id);

}
