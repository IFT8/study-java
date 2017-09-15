package com.comodin.basic.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import redis.clients.jedis.*;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Redis 工具类
 * Created by supeng on 2016-04-16 0016.
 */
@SuppressWarnings({"Duplicates", "WeakerAccess", "unused", "UnusedReturnValue"})
public class RedisUtils {
    private static Logger log = Logger.getLogger(RedisUtils.class);

    private static JedisPool jedisPool; // 池化管理jedis链接池

    static {
        //读取相关的配置
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc-redis");
        int maxActive = Integer.parseInt(resourceBundle.getString("redis.pool.maxActive"));
        int maxIdle = Integer.parseInt(resourceBundle.getString("redis.pool.maxIdle"));
        int maxWait = Integer.parseInt(resourceBundle.getString("redis.pool.maxWait"));

        String ip = resourceBundle.getString("redis.ip");
        int port = Integer.parseInt(resourceBundle.getString("redis.port"));
        int database = Integer.parseInt(resourceBundle.getString("redis.database"));
        String password = resourceBundle.getString("redis.password");
        password = "".equals(password.trim()) ? null : password;

        JedisPoolConfig config = new JedisPoolConfig();
        //设置最大连接数
        config.setMaxTotal(maxActive);
        //设置最大空闲数
        config.setMaxIdle(maxIdle);
        //设置超时时间
        config.setMaxWaitMillis(maxWait);

        //初始化连接池
        //jedisPool = new JedisPool(config, ip, port);
        jedisPool = new JedisPool(config, ip, port, Protocol.DEFAULT_TIMEOUT, password, database);

    }


    /**
     * EXISTS key [key ...]
     * <p>
     * 起始版本：1.0.0
     * 时间复杂度：O(M)
     * 返回key是否存在。
     * 返回值
     * integer-reply，如下的整数结果
     * 1 如果key存在
     * 0 如果key不存在
     * <p>
     * del这个命令的时间复杂度翻译的有问题，翻译说删除list, set, sorted set等非string类型的key的时间复杂度也是O(1)，这有错误，应该是O(M)，M是key中包含的元素数量。
     *
     * @param key the key
     * @return boolean
     */
    public static boolean exists(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.exists(key);
        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", key), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 为key 设置有效时间
     *
     * @param key        the key
     * @param expiration the expiration
     */
    public static void expire(String key, int expiration) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.expire(key, expiration);

        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s; expiration = %s", key, expiration), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * DEL key [key ...]
     * 起始版本：1.0.0
     * 时间复杂度：O(N) 将要被删除的key的数量，当删除的key是字符串以外的复杂数据类型时比如List,Set,Hash删除这个key的时间复杂度是O(1)。
     * 删除指定的一批keys，如果删除中的某些key不存在，则直接忽略。
     * 返回值
     * integer-reply： 被删除的keys的数量
     *
     * @param keys //
     * @return long
     */
    public static Long del(String... keys) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();

            return jedis.del(keys);

        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", Arrays.toString(keys)), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 字符串操作，Key 模糊查找
     *
     * @param pattern the key
     * @return string
     */
    public static Set<String> keys(String pattern) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();

            return jedis.keys(pattern);

        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", pattern), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    //字符串操作=================================================================================================
    //字符串操作             start
    //字符串操作=================================================================================================

    /**
     * 字符串操作，get
     *
     * @param redisSetKey the key
     * @return string
     */
    public static String stringGet(String redisSetKey) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();

            return jedis.get(redisSetKey);

        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", redisSetKey), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 字符串操作，get 【返回对象】
     *
     * @param <T>         要卖传递的clazz类型，返回
     * @param redisSetKey 对应的redis中的key
     * @param clazz       需要转换对象的类型，class
     * @return t
     */
    public static <T> T stringGet(String redisSetKey, Class<T> clazz) {
        String result = stringGet(redisSetKey);
        return StringUtils.isNotBlank(result) ? JSON.parseObject(result, clazz) : null;
    }


    /**
     * by supeng
     * <pre>
     *     功能：批量查询，所指定keys中的key对应的value
     * </pre>
     *
     * @param redisSetKeys 要查找的keys 集合
     * @return 返回若key对应的key - value
     */
    public static Map<String, String> stringGetByKeys(String... redisSetKeys) {
        Map<String, String> result = new HashMap<>();
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Pipeline pl = jedis.pipelined();

            for (String redisSetKey : redisSetKeys) {
                result.put(redisSetKey, jedis.get(redisSetKey));
            }

            pl.sync();
        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", Arrays.toString(redisSetKeys)), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    public static Map<String, String> stringGetByKeys(Set<String> keys) {
        return stringGetByKeys(keys.toArray(new String[keys.size()]));
    }

    /**
     * by supeng
     * <pre>
     *     功能：批量查询，key的模糊匹配，所有符合的key对应的value
     * </pre>
     *
     * @param redisSetKeyPattern key模糊匹配
     * @return 返回若key对应的key - value
     */
    public static Map<String, String> stringGetByKeysLike(String redisSetKeyPattern) {
        return stringGetByKeys(keys(redisSetKeyPattern));
    }

    /**
     * by supeng
     * <pre>
     *     功能：批量查询，所指定keys中的key对应的value，并将value进行JSON反组装成bean对象
     * </pre>
     *
     * @param clazz        需要将value转换对应的Bean的class
     * @param redisSetKeys 要查找的keys 集合
     * @param <T>          需要将value转换对应的Bean的class
     * @return 返回若key对应的key - value 对应的Bean
     */
    public static <T> Map<String, T> stringGetByKeys(Class<T> clazz, String... redisSetKeys) {
        HashMap<String, T> result = new HashMap<>();
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Pipeline pl = jedis.pipelined();

            for (String redisSetKey : redisSetKeys) {
                String redisSetKeyValue = jedis.get(redisSetKey);
                if (StringUtils.isNotBlank(redisSetKeyValue)) {
                    result.put(redisSetKey, JSON.parseObject(redisSetKeyValue, clazz));
                }
            }

            pl.sync();
        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", Arrays.toString(redisSetKeys)), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    public static <T> Map<String, T> stringGetByKeys(Class<T> clazz, Set<String> redisSetKeys) {
        return stringGetByKeys(clazz, redisSetKeys.toArray(new String[redisSetKeys.size()]));
    }


    /**
     * by supeng
     * <pre>
     *     功能：批量查询，key的模糊匹配，所有符合的key对应的value
     * </pre>
     *
     * @param clazz              需要将value转换对应的Bean的class
     * @param redisSetKeyPattern 要查找的keys 集合
     * @param <T>                需要将value转换对应的Bean的class
     * @return 返回若key对应的key - value 对应的Bean
     */
    public static <T> Map<String, T> stringGetByKeysLike(Class<T> clazz, String redisSetKeyPattern) {
        return stringGetByKeys(clazz, keys(redisSetKeyPattern));
    }


    /**
     * 字符串操作，set
     * 向缓存中设置字符串内容
     *
     * @param redisSetKey key     对应Redis的字符串，key
     * @param value       value   为字符串形式
     * @param expiration  the expiration
     * @return string
     */
    public static String stringSet(String redisSetKey, String value, int expiration) {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String status = jedis.set(redisSetKey, value);
            if (expiration > 0) {
                jedis.expire(redisSetKey, expiration);
            }
            return status;
        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s value = %s; expiration = %s", redisSetKey, value, expiration), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 字符串操作，set 【Value 为对象， 内部会将对象转换为JSON格式的字符串形式，存在到Redis中】
     *
     * @param redisSetKey the key
     * @param value       the value
     * @param expiration  小于0时不设置过期时间
     * @return string
     */
    public static String stringSet(String redisSetKey, Object value, int expiration) {
        String valueJsonString = JSON.toJSONString(value);
        return stringSet(redisSetKey, valueJsonString, expiration);
    }


    /**
     * 功能：批量写入Redis.String（字符串），通过Redis.pipelined
     * 业务场景：
     *
     * @param redisSetKeyValueMap 需要写入到Redis.String（字符串），对应的key value
     * @param expiration          设置时长
     */
    public static void stringSet(Map<String, String> redisSetKeyValueMap, int expiration) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Pipeline pl = jedis.pipelined();

            redisSetKeyValueMap.forEach((redisSetKey, valueStr) -> {
                pl.set(redisSetKey, valueStr);

                if (expiration > 0) {
                    pl.expire(redisSetKey, expiration);
                }
            });

            pl.sync();
        } catch (Throwable t) {
            log.error(String.format("jedis error %s", t.getMessage()), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    /**
     * <pre>
     * 功能：批量写入Redis.String（字符串），通过Redis.pipelined
     * 业务场景：
     * </pre>
     *
     * @param redisSetKeyValueMap 需要写入到Redis.String（字符串），对应的key value
     * @param expiration          设置时长
     */
    public static void stringSetByBean(Map<String, ?> redisSetKeyValueMap, int expiration) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Pipeline pl = jedis.pipelined();

            redisSetKeyValueMap.forEach((redisSetKey, valueO) -> {
                pl.set(redisSetKey, JSON.toJSONString(valueO));

                if (expiration > 0) {
                    pl.expire(redisSetKey, expiration);
                }
            });

            pl.sync();
        } catch (Throwable t) {
            log.error(String.format("jedis error %s", t.getMessage()), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    //字符串操作=================================================================================================
    //字符串操作             end
    //字符串操作=================================================================================================


    /**
     * hget
     *
     * @param redisHsetKey the key
     * @param field        the field
     * @return string
     */
    public static String hget(String redisHsetKey, String field) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hget(redisHsetKey, field);
        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", redisHsetKey), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * Hget t.
     *
     * @param <T>          the type parameter
     * @param redisHsetKey the key
     * @param field        the field
     * @param clazz        the clazz
     * @return the t
     */
    public static <T> T hget(String redisHsetKey, String field, Class<T> clazz) {
        String result = hget(redisHsetKey, field);
        return (result == null || "".equals(result.trim())) ? null : JSON.parseObject(result, clazz);
    }


    /**
     * 获取指定key下的指定fields数组对应的值.
     *
     * @param <T>   the type parameter
     * @param key   the key
     * @param clazz the clazz
     * @return the t
     */
    public static <T> List<T> hmget(String key, Class<T> clazz, String... fields) {
        List<T> list = new ArrayList<>();

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            List<String> fieldValueStringList = jedis.hmget(key, fields);
            fieldValueStringList.forEach(fieldValue -> {
                if (StringUtils.isNotBlank(fieldValue)) {
                    list.add(JSON.parseObject(fieldValue, clazz));
                }
            });

        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", key), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return list;
    }

    /**
     * by supeng
     * 业务功能：获取 hset类型数据，且各key中的set元素都有相同的字段数据
     *
     * @param field         所有key中都包含该字段的数据
     * @param redisHsetKeys 指定 key集合
     * @return 返回 各个key中对应字段的数据，Map<key field>
     */
    public static Map<String, String> hgetSingleFieldByKeys(String field, String... redisHsetKeys) {
        Map<String, String> result = new HashMap<>();

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Pipeline pl = jedis.pipelined();

            for (String redisHsetKey : redisHsetKeys) {
                String fieldValue = jedis.hget(redisHsetKey, field);
                if (StringUtils.isNotBlank(fieldValue)) {
                    result.put(redisHsetKey, fieldValue);
                }
            }

            pl.sync();
        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", Arrays.toString(redisHsetKeys)), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    /**
     * by supeng
     * 业务功能：获取 hset类型数据，且各key中的set元素都有相同的字段数据
     *
     * @param field         所有key中都包含该字段的数据
     * @param redisHsetKeys 指定 key集合
     * @return 返回 各个key中对应字段的数据，Map<key,field>
     */
    public static Map<String, String> hgetSingleFieldByKeys(String field, Set<String> redisHsetKeys) {
        return hgetSingleFieldByKeys(field, redisHsetKeys.toArray(new String[redisHsetKeys.size()]));
    }

    public static <T> Map<String, T> hgetSingleFieldByKeys(String field, Class<T> clazz, String... redisHsetKeys) {
        Map<String, T> result = new HashMap<>();

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Pipeline pl = jedis.pipelined();

            for (String redisHsetKey : redisHsetKeys) {
                String fieldValue = jedis.hget(redisHsetKey, field);
                if (StringUtils.isNotBlank(fieldValue)) {
                    result.put(redisHsetKey, JSON.parseObject(fieldValue, clazz));
                }
            }
            pl.sync();
        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", Arrays.toString(redisHsetKeys)), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    public static <T> Map<String, T> hgetSingleFieldByKeys(String field, Class<T> clazz, Set<String> redisHsetKeys) {
        return hgetSingleFieldByKeys(field, clazz, redisHsetKeys.toArray(new String[redisHsetKeys.size()]));
    }


    /**
     * by supeng
     * 业务功能：获取hset类型数据，且各key中的set元素都有相同的字段数据【支持，key模糊匹配，所有获取符合的Keys，再进行查询】
     *
     * @param redisHsetKeyPattern 模拟匹配key
     * @param field               所有key中都包含该字段的数据
     * @return 返回 各个key中对应字段的数据，Map<key field>
     */
    public static Map<String, String> hgetSingleFieldByKeysLike(String field, String redisHsetKeyPattern) {
        return hgetSingleFieldByKeys(field, keys(redisHsetKeyPattern));
    }

    /**
     * hgetAll
     *
     * @param redisHsetKey the key
     * @return map
     */
    public static Map<String, String> hgetAll(String redisHsetKey) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hgetAll(redisHsetKey);
        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", redisHsetKey), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * by supeng
     * 业务功能：用于hset集合中，指定key的所有字段对应的值，都是同一种JAVABean进行JSON转换字符串数据，然后进行序列化为JavaBean对象
     *
     * @param redisHsetKey 指定 hset集合的key
     * @param clazz        各hset集合中 field字段的JSON，对应的JAVABean的class
     * @param <T>          各hset集合中 field字段的JSON，对应的JAVABean
     * @return 返回，指定的hset.key 中所有字段被序列化后的JavaBean对象
     */
    public static <T> Map<String, T> hgetAll(Class<T> clazz, String redisHsetKey) {
        HashMap<String, T> result = new HashMap<>();

        Map<String, String> stringStringMap = hgetAll(redisHsetKey);
        if (stringStringMap != null && !stringStringMap.isEmpty()) {
            stringStringMap.forEach((field, fieldValue) -> {
                if (StringUtils.isNotBlank(fieldValue)) {
                    result.put(field, JSON.parseObject(fieldValue, clazz));
                }
            });
        }

        return result;
    }

    /**
     * by supeng
     * 业务功能：用于批量获取，指定keys中所有的字段数据。一般于批量操作
     *
     * @param redisHsetKeys 指定的keys集合
     * @return 返回，所有keys中的所有字的段数据。以Map<keys,Map<field,fieldValue>>
     */
    public static Map<String, Map<String, String>> hgetAllByKeys(String... redisHsetKeys) {
        Map<String, Map<String, String>> result = new HashMap<>();

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Pipeline pl = jedis.pipelined();

            for (String key : redisHsetKeys) {
                Map<String, String> stringStringMap = jedis.hgetAll(key);
                if (stringStringMap != null && !stringStringMap.isEmpty()) {
                    result.put(key, stringStringMap);
                }
            }

            pl.sync();
        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", Arrays.toString(redisHsetKeys)), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    /**
     * by supeng
     * 业务功能：用于批量获取，指定keys中所有的字段数据。一般于批量操作
     *
     * @param redisHsetKeys 指定的keys集合
     * @return 返回，所有keys中的所有字的段数据。以Map<keys,Map<field,fieldValue>>
     */
    public static Map<String, Map<String, String>> hgetAllByKeys(Set<String> redisHsetKeys) {
        return hgetAllByKeys(redisHsetKeys.toArray(new String[redisHsetKeys.size()]));
    }

    /**
     * by supeng
     * 业务功能：用于批量获取，指定keys中所有的字段数据。一般于批量操作【支持，key模糊匹配，所有获取符合的Keys，再进行查询】
     *
     * @param redisHsetKeyPattern 模拟匹配key
     * @return 返回，所有keys中的所有字的段数据。以Map<keys,Map<field,fieldValue>>
     */
    public static Map<String, Map<String, String>> hgetAllByKeysLike(String redisHsetKeyPattern) {
        return hgetAllByKeys(keys(redisHsetKeyPattern));
    }


    public <T> Map<String, T> hgetAllToBeanByKeys(Class<T> clazz, String... redisHsetKeys) {
        Map<String, T> result = new HashMap<>();

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Pipeline pl = jedis.pipelined();

            for (String redisHsetKey : redisHsetKeys) {

                Map<String, String> hgetAllFieldDataMap = jedis.hgetAll(redisHsetKey);
                if (hgetAllFieldDataMap != null && !hgetAllFieldDataMap.isEmpty()) {

                    try {
                        T t = clazz.newInstance();
                        BeanUtils.populate(t, hgetAllFieldDataMap);
                        result.put(redisHsetKey, t);
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        log.error(String.format("jedis error key = %s", Arrays.toString(redisHsetKeys)), e);
                    }
                }
            }
            pl.sync();
        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", Arrays.toString(redisHsetKeys)), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    public <T> Map<String, T> hgetAllToBeanByKeys(Class<T> clazz, Set<String> redisHsetKeys) {
        return hgetAllToBeanByKeys(clazz, redisHsetKeys.toArray(new String[redisHsetKeys.size()]));
    }

    public <T> Map<String, T> hgetAllToBeanByKeysLike(Class<T> clazz, String redisHsetKeyPattern) {
        return hgetAllToBeanByKeys(clazz, keys(redisHsetKeyPattern));
    }

    /**
     * Hset long.
     *
     * @param redisHsetKey the key
     * @param field        the field
     * @param value        the value
     * @param expiration   the expiration
     * @return the long
     */
    public static Long hset(String redisHsetKey, String field, String value, int expiration) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Long l = jedis.hset(redisHsetKey, field, value);
            if (expiration > 0) {
                jedis.expire(redisHsetKey, expiration);
            }
            return l;
        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", redisHsetKey), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * Hset long.
     *
     * @param redisHsetKey the key
     * @param field        the field
     * @param value        the value
     * @param expiration   the expiration
     * @return the long
     */
    public static Long hset(String redisHsetKey, String field, Object value, int expiration) {
        String valueJsonString = JSON.toJSONString(value);
        return RedisUtils.hset(redisHsetKey, field, valueJsonString, expiration);
    }

    /**
     * by supeng
     * 功能：针对 Redis数据类型为 hset；且每个Key都具有相同字段名，需要批量设置值，或者更新值
     *
     * @param expiration the expiration
     */
    public static void hsetBigBatch(String singleFieldName, Map<String, String> redisHsetKeysAndFieldValuesMap, int expiration) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Pipeline pl = jedis.pipelined();

            redisHsetKeysAndFieldValuesMap.forEach((redisHsetKey, fieldValue) -> {
                if (StringUtils.isBlank(redisHsetKey) || StringUtils.isBlank(fieldValue)) {
                    return;
                }
                pl.hset(redisHsetKey, singleFieldName, fieldValue);

                if (expiration > 0) {
                    pl.expire(redisHsetKey, expiration);
                }
            });
            pl.sync();
        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", redisHsetKeysAndFieldValuesMap.keySet().toString()), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    /**
     * <pre>
     * 功能：批量写入Redis.hset集合中，通过Redis.pipelined
     * 业务场景：
     *      1、将所有部门，缓存到Redis中
     *      2、将所有角色，缓存到Redis中
     * </pre>
     *
     * @param redisHsetKey  redis.hset 中的Key
     * @param mapFieldValue 需要写入到Redis.hase，对应的key value
     * @param expiration    设置时长
     */
    public static void hmset(String redisHsetKey, Map<String, String> mapFieldValue, int expiration) {
        HashMap<String, Map<String, String>> stringMapHashMap = new HashMap<>();
        stringMapHashMap.put(redisHsetKey, mapFieldValue);
        hmsetBigBatch(stringMapHashMap, expiration);
    }

    public static <T> void hmset(String redisHsetKey, Class<T> clazz, int expiration) {
        Map<String, String> allFieldsValuesMap = null;
        try {
            allFieldsValuesMap = BeanUtils.describe(clazz);
        } catch (Exception e) {
            log.error(String.format(" bean describe Map error key = %s", redisHsetKey), e);
        }
        hmset(redisHsetKey, allFieldsValuesMap, expiration);
    }


    public static void set(String key, List<String> value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Pipeline pl = jedis.pipelined();

            String[] strings = new String[value.size()];
            value.toArray(strings);

            pl.sadd(key, strings);

            pl.sync();
        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", key), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    public static Set<String> smembers(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();

            return jedis.smembers(key);

        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", key), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * by supeng
     * 功能：大批量，为多个keys，进行每个key，写入以Map集合包含的所有，字段名，字段值
     *
     * @param stringMapMap //
     * @param expiration   //
     */
    public static void hmsetBigBatch(Map<String, Map<String, String>> stringMapMap, int expiration) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Pipeline pl = jedis.pipelined();

            stringMapMap.forEach((redisHsetKey, allFieldsValuesMap) -> {
                if (StringUtils.isBlank(redisHsetKey)) {
                    return;
                }

                pl.hmset(redisHsetKey, allFieldsValuesMap);

                if (expiration > 0) {
                    pl.expire(redisHsetKey, expiration);
                }
            });
            pl.sync();
        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", stringMapMap.keySet().toString()), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 递增key的整数值
     *
     * @param redisKey //
     * @return //
     */
    public static Long incr(String redisKey) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.incr(redisKey);
        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", redisKey), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * @param keys 所有ke
     * @return key->redis中的key，value->可以对应的列表值
     */
    public static Map<String, List<String>> getAllByKeys(Set<String> keys) {

        Map<String, List<String>> map = new HashMap<>();

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Pipeline pl = jedis.pipelined();

            for (String key : keys) {
                Set<String> smembers = jedis.smembers(key);
                map.put(key, new ArrayList<>(smembers));
            }

            pl.sync();
        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", keys), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

        return map;
    }

    /**
     * 在key 对应 list的头部添加字符串元素(可用于消息队列)
     *
     * @param key    //
     * @param values //
     */
    public static void lpush(String key, String... values) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();

            jedis.lpush(key, values);

        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", key), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 在key 对应 list 的尾部添加字符串元素(可用于消息队列)
     *
     * @param key    //
     * @param values //
     */
    public static void rpush(String key, String... values) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();

            jedis.rpush(key, values);

        } catch (Throwable t) {
            log.error(String.format("jedis error key = %s", key), t);
            throw t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    /**
     * 在list头部获取消息(阻塞接口，可用于消息队列)
     *
     * @param key        //
     * @param timeout（s） 若过了timeout后未读到，则直接返回Null
     */
    public static List<String> blpop(int timeout, String key) {

        List<String> list;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            list = jedis.blpop(timeout, key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

        return list;
    }

    /**
     * 在list头部获取消息(阻塞接口，可用于消息队列)
     *
     * @param keys       //
     * @param timeout（s） 若过了timeout后未读到，则直接返回Null
     */
    public static List<String> blpop(int timeout, String... keys) {

        List<String> list;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();

            list = jedis.blpop(timeout, keys);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return list;
    }


    /**
     * RPOPLPUSH source destination
     * 起始版本：1.2.0
     * 时间复杂度：O(1)
     * 原子性地返回并移除存储在 source 的列表的最后一个元素（列表尾部元素）， 并把该元素放入存储在 destination 的列表的第一个元素位置（列表头部）。
     * 例如：假设 source 存储着列表 a,b,c， destination存储着列表 x,y,z。 执行 RPOPLPUSH 得到的结果是 source 保存着列表 a,b ，而 destination 保存着列表 c,x,y,z。
     * 如果 source 不存在，那么会返回 nil 值，并且不会执行任何操作。 如果 source 和 destination 是同样的，那么这个操作等同于移除列表最后一个元素并且把该元素放在列表头部， 所以这个命令也可以当作是一个旋转列表的命令。
     * 返回值
     * bulk-string-reply: 被移除和放入的元素
     *
     * @param srckey //
     * @param dstkey //
     * @return //
     */
    public static String rpoplpush(String srckey, String dstkey) {
        String result;

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();

            result = jedis.rpoplpush(srckey, dstkey);

        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    public static String rpop(String key) {
        String result;

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();

            result = jedis.rpop(key);

        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }
}