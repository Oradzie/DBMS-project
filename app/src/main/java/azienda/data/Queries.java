package azienda.data;

public final class Queries {

    public static final String TAGS_FOR_PRODUCT =
        """
        SELECT  t.tag_name
        FORM    TAGGED t
        WHERE   t.product_code = ?
        """;

    public static final String LIST_PRODUCTS =
        """
        SELECT  p.code, p.name
        FROM    PRODUCT p
        """;

    public static final String PRODUCT_COMPOSITION =
        """
        """;

    public static final String FIND_PRODUCT =
        """
        SELECT  *
        FROM    PRODUCT p
        WHERE   p.code = ?
        """;
}
