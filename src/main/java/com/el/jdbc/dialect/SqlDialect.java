package com.el.jdbc.dialect;

import com.el.domain.Paging;

import java.util.Map;

/**
 * @author danfeng
 * @since 2018/1/25.
 */
public interface SqlDialect {

    Map<Character, String> escapeTable();

    String escapeClause();

    String validationQuery();

    String paging(String var1, Paging var2);
}
