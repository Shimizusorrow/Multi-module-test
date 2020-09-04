package shimizu.identity.utils;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.sun.org.apache.bcel.internal.generic.IFNULL;
import io.jsonwebtoken.lang.Strings;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/9/1 10:19
 */
@Component
public final class QueryMapperUtil {
    private Map<String, Object> params = new HashMap<>();
    private Map<String, String> condition = new HashMap<>();
    private StringBuilder sql;
    private EntityManager entityManager;
    private Query query;

    private volatile static QueryMapperUtil queryMapperUtil;

    private void putValues(String k, Object v) {
        if (!Strings.hasText(k)) {
            throw new RuntimeException("k 为null");
        }
        this.params.put(k, v);
    }

    private QueryMapperUtil() {
    }

    private QueryMapperUtil(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public static QueryMapperUtil getQueryMapper() {
        if (queryMapperUtil == null) {
            synchronized (QueryMapperUtil.class) {
                if (queryMapperUtil == null) {
                    queryMapperUtil = new QueryMapperUtil();
                }
            }
        }
        return queryMapperUtil;
    }

    public static QueryMapperUtil getQueryMapper(EntityManager entityManager) {
        if (queryMapperUtil == null || queryMapperUtil.entityManager != null) {
            synchronized (QueryMapperUtil.class) {
                if (queryMapperUtil == null) {
                    queryMapperUtil = new QueryMapperUtil(entityManager);
                } else {
                    queryMapperUtil.clear();
                    queryMapperUtil.entityManager = entityManager;
                }
            }
        }
        return queryMapperUtil;
    }

    private void clear() {
        queryMapperUtil.sql = null;
        queryMapperUtil.query = null;
        queryMapperUtil.condition = null;
        queryMapperUtil.params = null;
    }

    /**
     * 添加首部Sql
     *
     * @param sql
     * @return
     */
    public QueryMapperUtil createHeadSql(String sql) {
        ifNull();
        queryMapperUtil.sql = new StringBuilder(sql);
        return queryMapperUtil;
    }

    /**
     * 添加参数
     *
     * @param map
     * @return
     */
    public QueryMapperUtil addParams(Map<String, Object> map) {
        ifNull();
        queryMapperUtil.params.putAll(map);
        return queryMapperUtil;
    }

    /**
     * 添加中部查询
     *
     * @param map
     * @return
     */
    public QueryMapperUtil addCondition(Map<String, String> map) {
        ifNull();
        queryMapperUtil.condition.putAll(map);
        return queryMapperUtil;
    }

    public Query getQuery() {
        ifNull();
        List<String> keys = getKeys();
        if (!keys.isEmpty()) {
            fillSql(keys);
            queryMapperUtil.query = queryMapperUtil.entityManager
                    .createNativeQuery(queryMapperUtil.sql.toString());
            fillParams(keys);
        }
        return queryMapperUtil.query;
    }

    public List getResult() {
        ifNull();
        Query query = queryMapperUtil.query;
        if (query == null) {
            query = getQuery();
        }
        return query == null ? null : query.getResultList();
    }


    public String toSqlString() {
        ifNull();
        if (queryMapperUtil.query == null) {
            getQuery();
        }
        return queryMapperUtil.sql.toString();
    }

    private List<String> getKeys() {
        return queryMapperUtil.params.entrySet().stream()
                .filter(it -> !Objects.isNull(it.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    /**
     * 填充Sql
     *
     * @param keys
     */
    private void fillSql(List<String> keys) {
        for (String key : keys) {
            queryMapperUtil.sql.append(" " + queryMapperUtil.condition.get(key));
        }
    }

    /**
     * 填充Params
     *
     * @param keys
     */
    private void fillParams(List<String> keys) {
        Query query = queryMapperUtil.query;
        for (String key : keys) {
            query.setParameter(key, queryMapperUtil.params.get(key));
        }
    }

    private void ifNull() {
        if (Objects.isNull(queryMapperUtil)) {
            throw new RuntimeException("queryMapperUtil is null");
        }
        if (Objects.isNull(queryMapperUtil.entityManager)) {
            throw new RuntimeException("entityManager isnull");
        }
    }
}
