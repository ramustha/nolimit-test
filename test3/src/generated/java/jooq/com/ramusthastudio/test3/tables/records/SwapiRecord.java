/*
 * This file is generated by jOOQ.
*/
package com.ramusthastudio.test3.tables.records;


import com.ramusthastudio.test3.tables.Swapi;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;


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
public class SwapiRecord extends UpdatableRecordImpl<SwapiRecord> implements Record4<ULong, String, String, String> {

    private static final long serialVersionUID = 1328674274;

    /**
     * Setter for <code>swapidb.swapi.ID</code>.
     */
    public void setId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>swapidb.swapi.ID</code>.
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>swapidb.swapi.NAME</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>swapidb.swapi.NAME</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>swapidb.swapi.GENDER</code>.
     */
    public void setGender(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>swapidb.swapi.GENDER</code>.
     */
    public String getGender() {
        return (String) get(2);
    }

    /**
     * Setter for <code>swapidb.swapi.HOMEWORLD</code>.
     */
    public void setHomeworld(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>swapidb.swapi.HOMEWORLD</code>.
     */
    public String getHomeworld() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<ULong, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<ULong, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field1() {
        return Swapi.SWAPI.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Swapi.SWAPI.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Swapi.SWAPI.GENDER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Swapi.SWAPI.HOMEWORLD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getGender();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getHomeworld();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SwapiRecord value1(ULong value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SwapiRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SwapiRecord value3(String value) {
        setGender(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SwapiRecord value4(String value) {
        setHomeworld(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SwapiRecord values(ULong value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SwapiRecord
     */
    public SwapiRecord() {
        super(Swapi.SWAPI);
    }

    /**
     * Create a detached, initialised SwapiRecord
     */
    public SwapiRecord(ULong id, String name, String gender, String homeworld) {
        super(Swapi.SWAPI);

        set(0, id);
        set(1, name);
        set(2, gender);
        set(3, homeworld);
    }
}
