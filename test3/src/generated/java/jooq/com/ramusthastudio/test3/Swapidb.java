/*
 * This file is generated by jOOQ.
*/
package com.ramusthastudio.test3;


import com.ramusthastudio.test3.tables.SchemaVersion;
import com.ramusthastudio.test3.tables.Swapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Swapidb extends SchemaImpl {

    private static final long serialVersionUID = -427894955;

    /**
     * The reference instance of <code>swapidb</code>
     */
    public static final Swapidb SWAPIDB = new Swapidb();

    /**
     * The table <code>swapidb.schema_version</code>.
     */
    public final SchemaVersion SCHEMA_VERSION = com.ramusthastudio.test3.tables.SchemaVersion.SCHEMA_VERSION;

    /**
     * The table <code>swapidb.swapi</code>.
     */
    public final Swapi SWAPI = com.ramusthastudio.test3.tables.Swapi.SWAPI;

    /**
     * No further instances allowed
     */
    private Swapidb() {
        super("swapidb", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            SchemaVersion.SCHEMA_VERSION,
            Swapi.SWAPI);
    }
}