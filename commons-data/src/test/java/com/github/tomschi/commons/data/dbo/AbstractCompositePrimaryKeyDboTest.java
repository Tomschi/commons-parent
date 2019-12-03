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

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AbstractCompositePrimaryKeyDboTest {

    @Test
    void testHashCode() {
        List<? extends Serializable> primaryKeyList1 = Arrays.asList(1L, "KEY");
        List<? extends Serializable> primaryKeyList2 = Arrays.asList(1L, "KEY");

        CompositePrimaryKeyDbo barCompositePrimaryKeyDbo = new BarCompositePrimaryKeyDbo(primaryKeyList1);
        CompositePrimaryKeyDbo fooCompositePrimaryKeyDbo = new FooCompositePrimaryKeyDbo(primaryKeyList2);

        int hashCode = BarCompositePrimaryKeyDbo.class.getName().hashCode() * 13 + primaryKeyList1.stream().mapToInt(Object::hashCode).sum();
        assertEquals(hashCode, barCompositePrimaryKeyDbo.hashCode());
        assertNotEquals(barCompositePrimaryKeyDbo.hashCode(), fooCompositePrimaryKeyDbo.hashCode());
        assertNotEquals(new BarCompositePrimaryKeyDbo(null).hashCode(), new BarCompositePrimaryKeyDbo(null).hashCode());
    }

    @Test
    void testEquals() {
        List<? extends Serializable> primaryKeyList1 = Arrays.asList(1L, "KEY");
        List<? extends Serializable> primaryKeyList2 = Arrays.asList(1L, "KEY");

        CompositePrimaryKeyDbo barCompositePrimaryKeyDbo1 = new BarCompositePrimaryKeyDbo(primaryKeyList1);
        CompositePrimaryKeyDbo barCompositePrimaryKeyDbo2 = new BarCompositePrimaryKeyDbo(primaryKeyList2);

        CompositePrimaryKeyDbo fooCompositePrimaryKeyDbo1 = new FooCompositePrimaryKeyDbo(primaryKeyList1);

        assertEquals(barCompositePrimaryKeyDbo1, barCompositePrimaryKeyDbo1);
        assertEquals(barCompositePrimaryKeyDbo1, barCompositePrimaryKeyDbo2);
        assertNotEquals(barCompositePrimaryKeyDbo1, fooCompositePrimaryKeyDbo1);
        assertNotEquals(new BarCompositePrimaryKeyDbo(null), new BarCompositePrimaryKeyDbo(null));
    }

    private class BarCompositePrimaryKeyDbo extends AbstractCompositePrimaryKeyDbo {

        private static final long serialVersionUID = -8211067700486693175L;

        List<? extends Serializable> primaryKeyValues;

        public BarCompositePrimaryKeyDbo(List<? extends Serializable> primaryKeyValues) {
            this.primaryKeyValues = primaryKeyValues;
        }

        @Override
        public List<? extends Serializable> getPrimaryKeyValues() {
            return this.primaryKeyValues;
        }

    }

    private class FooCompositePrimaryKeyDbo extends AbstractCompositePrimaryKeyDbo {

        private static final long serialVersionUID = -4128146155785214989L;

        List<? extends Serializable> primaryKeyValues;

        public FooCompositePrimaryKeyDbo(List<? extends Serializable> primaryKeyValues) {
            this.primaryKeyValues = primaryKeyValues;
        }

        @Override
        public List<? extends Serializable> getPrimaryKeyValues() {
            return this.primaryKeyValues;
        }

    }

}