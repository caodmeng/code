/*
 * This file is generated by jOOQ.
 */
package zipkin2.storage.mysql.v1.internal.generated;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import zipkin2.storage.mysql.v1.internal.generated.tables.ZipkinAnnotations;
import zipkin2.storage.mysql.v1.internal.generated.tables.ZipkinDependencies;
import zipkin2.storage.mysql.v1.internal.generated.tables.ZipkinSpans;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Zipkin extends SchemaImpl {

    private static final long serialVersionUID = 597767543;

    /**
     * The reference instance of <code>zipkin</code>
     */
    public static final Zipkin ZIPKIN = new Zipkin();

    /**
     * The table <code>zipkin.zipkin_annotations</code>.
     */
    public final ZipkinAnnotations ZIPKIN_ANNOTATIONS = zipkin2.storage.mysql.v1.internal.generated.tables.ZipkinAnnotations.ZIPKIN_ANNOTATIONS;

    /**
     * The table <code>zipkin.zipkin_dependencies</code>.
     */
    public final ZipkinDependencies ZIPKIN_DEPENDENCIES = zipkin2.storage.mysql.v1.internal.generated.tables.ZipkinDependencies.ZIPKIN_DEPENDENCIES;

    /**
     * The table <code>zipkin.zipkin_spans</code>.
     */
    public final ZipkinSpans ZIPKIN_SPANS = zipkin2.storage.mysql.v1.internal.generated.tables.ZipkinSpans.ZIPKIN_SPANS;

    /**
     * No further instances allowed
     */
    private Zipkin() {
        super("zipkin", null);
    }


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
            ZipkinAnnotations.ZIPKIN_ANNOTATIONS,
            ZipkinDependencies.ZIPKIN_DEPENDENCIES,
            ZipkinSpans.ZIPKIN_SPANS);
    }
}