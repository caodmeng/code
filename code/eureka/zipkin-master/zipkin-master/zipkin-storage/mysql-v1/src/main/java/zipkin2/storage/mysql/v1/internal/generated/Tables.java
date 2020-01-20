/*
 * This file is generated by jOOQ.
 */
package zipkin2.storage.mysql.v1.internal.generated;


import javax.annotation.Generated;

import zipkin2.storage.mysql.v1.internal.generated.tables.ZipkinAnnotations;
import zipkin2.storage.mysql.v1.internal.generated.tables.ZipkinDependencies;
import zipkin2.storage.mysql.v1.internal.generated.tables.ZipkinSpans;


/**
 * Convenience access to all tables in zipkin
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>zipkin.zipkin_annotations</code>.
     */
    public static final ZipkinAnnotations ZIPKIN_ANNOTATIONS = ZipkinAnnotations.ZIPKIN_ANNOTATIONS;

    /**
     * The table <code>zipkin.zipkin_dependencies</code>.
     */
    public static final ZipkinDependencies ZIPKIN_DEPENDENCIES = ZipkinDependencies.ZIPKIN_DEPENDENCIES;

    /**
     * The table <code>zipkin.zipkin_spans</code>.
     */
    public static final ZipkinSpans ZIPKIN_SPANS = ZipkinSpans.ZIPKIN_SPANS;
}
