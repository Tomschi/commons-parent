/*-
 * #%L
 * commons-data
 * %%
 * Copyright (C) 2018 - 2019 Tomschi
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.github.tomschi.commons.data.dbo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @since 0.2.1
 * @author Tomschi
 */
public abstract class AbstractCompositePrimaryKeyDbo implements CompositePrimaryKeyDbo {

    private static final long serialVersionUID = 1L;

    private boolean isPrimaryKeyValuesValid(List<? extends Serializable> idList) {
        return idList != null && !idList.isEmpty() && !idList.contains(null);
    }

    /**
     * Returns a hash code value for the object. The value
     * is generated with the hash code of the class name and
     * the hash code of the primary key's. If the {@link List}
     * of the primary key's contains <code>null</code>,
     * {@link Object#hashCode()} is called.
     *
     * @return A hash code value for the object.
     */
    @Override
    public int hashCode() {
        if (isPrimaryKeyValuesValid(getPrimaryKeyValues())) {
            Stream<Object> stream = Stream.concat(
                    Stream.of(this.getClass().getName()),
                    Stream.of(getPrimaryKeyValues().toArray()));
            return Objects.hash(stream.toArray());
        }

        return super.hashCode();
    }

    /**
     * Indicates if this object is equals to another object.
     * For checking this equality the {@link List} of primary key's
     * is used. Two objects are equal, if the given object
     * is this object (<code>this == obj</code>) or the given
     * object has the same class like this and both {@link List}
     * of primary key's are equal. If the {@link List} of primary key's
     * contains <code>null</code>, the method only check if the given
     * object is this object.
     *
     * @param obj The reference object with which to compare.
     * @return <code>True</code>, if obj equals <code>this</code>, else <code>false</code>.
     */
    @Override
    public boolean equals(Object obj) {
        List<? extends Serializable> primaryKeyList = getPrimaryKeyValues();
        if (isPrimaryKeyValuesValid(primaryKeyList)) {
            return (this.getClass() == obj.getClass())
                    && primaryKeyList.equals(((CompositePrimaryKeyDbo) obj).getPrimaryKeyValues());
        }

        return super.equals(obj);
    }

}
