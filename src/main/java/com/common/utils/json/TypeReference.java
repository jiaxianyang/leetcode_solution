package com.common.utils.json;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * TypeReference简介
 * 泛型工具类
 *
 * @author lindong20
 * @date 2020-07-07 18:24
 */
public class TypeReference<T> {
    /**
     * classTypeCache
     */
    private static ConcurrentMap<Type, Type> classTypeCache = new ConcurrentHashMap(16, 0.75F, 1);
    /**
     * type
     */
    protected Type type;
    /**
     * LIST_STRING
     */
    public static final Type LIST_STRING = (new TypeReference<List<String>>() {
    }).getType();

    /**
     * 泛型工具类构造
     */
    protected TypeReference() {
        Type superClass = this.getClass().getGenericSuperclass();
        if (superClass instanceof ParameterizedType) {
            Type type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
            Type cachedType = null;
            Object obj = classTypeCache.get(type);
            if (obj instanceof Type) {
                cachedType = (Type) obj;
            }
            if (cachedType == null) {
                classTypeCache.putIfAbsent(type, type);
                obj = classTypeCache.get(type);
                if (obj instanceof Type) {
                    cachedType = (Type) obj;
                }
            }

            this.type = cachedType;
        }
    }

    /**
     * 泛型工具类构造
     *
     * @param actualTypeArguments
     * @throws ClassNotFoundException
     */
    protected TypeReference(Type... actualTypeArguments) throws ClassNotFoundException {
        Class<?> thisClass = this.getClass();
        Type superClass = thisClass.getGenericSuperclass();
        if (superClass instanceof ParameterizedType) {
            Object obj = ((ParameterizedType) superClass).getActualTypeArguments()[0];
            if (obj instanceof ParameterizedType) {
                ParameterizedType argType = (ParameterizedType) obj;

                Type rawType = argType.getRawType();
                Type[] argTypes = argType.getActualTypeArguments();
                int actualIndex = 0;

                for (int i = 0; i < argTypes.length; ++i) {
                    if (argTypes[i] instanceof TypeVariable && actualIndex < actualTypeArguments.length) {
                        argTypes[i] = actualTypeArguments[actualIndex++];
                    }

                    if (argTypes[i] instanceof GenericArrayType) {
                        argTypes[i] = checkPrimitiveArray((GenericArrayType) argTypes[i]);
                    }
                }

                Type key = new ParameterizedTypeImpl(argTypes, thisClass, rawType);
                Object objt = classTypeCache.get(key);
                if (objt instanceof Type) {
                    Type cachedType = (Type) objt;
                    if (cachedType == null) {
                        classTypeCache.putIfAbsent(key, key);
                        objt = classTypeCache.get(key);
                        if (objt instanceof Type) {
                            cachedType = (Type) objt;
                        }
                    }
                    this.type = cachedType;
                }

            }
        }
    }

    /**
     * 泛型检查
     *
     * @param genericArrayType
     * @return
     * @throws ClassNotFoundException
     */
    private Type checkPrimitiveArray(GenericArrayType genericArrayType) throws ClassNotFoundException {
        Type clz = genericArrayType;
        Type genericComponentType = genericArrayType.getGenericComponentType();

        StringBuffer prefix = new StringBuffer("[");
        for (prefix.append(""); genericComponentType instanceof GenericArrayType; prefix.append(prefix)) {
            genericComponentType = ((GenericArrayType) genericComponentType).getGenericComponentType();
        }

        if (genericComponentType instanceof Class) {
            Class<?> ck = (Class) genericComponentType;
            if (ck.isPrimitive()) {
                try {
                    if (ck == Boolean.TYPE) {
                        clz = Class.forName(prefix + "Z");
                    } else if (ck == Character.TYPE) {
                        clz = Class.forName(prefix + "C");
                    } else if (ck == Byte.TYPE) {
                        clz = Class.forName(prefix + "B");
                    } else if (ck == Short.TYPE) {
                        clz = Class.forName(prefix + "S");
                    } else if (ck == Integer.TYPE) {
                        clz = Class.forName(prefix + "I");
                    } else if (ck == Long.TYPE) {
                        clz = Class.forName(prefix + "J");
                    } else if (ck == Float.TYPE) {
                        clz = Class.forName(prefix + "F");
                    } else if (ck == Double.TYPE) {
                        clz = Class.forName(prefix + "D");
                    }
                } catch (ClassNotFoundException var6) {
                    throw var6;
                }
            }
        }

        return clz;
    }

    /**
     * 获取类型
     *
     * @return
     */
    public Type getType() {
        return this.type;
    }
}
