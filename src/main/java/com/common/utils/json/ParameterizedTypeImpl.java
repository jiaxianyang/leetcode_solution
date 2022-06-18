package com.common.utils.json;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * ParameterizedTypeImpl简介
 * 类型适配器
 *
 * @author lindong20
 * @date 2020-07-07 18:23
 */
class ParameterizedTypeImpl implements ParameterizedType {
    /**
     * actualTypeArguments
     */
    private final Type[] actualTypeArguments;
    /**
     * ownerType
     */
    private final Type ownerType;
    /**
     * rawType
     */
    private final Type rawType;

    /**
     * 类型适配器构造
     *
     * @param actualTypeArguments
     * @param ownerType
     * @param rawType
     */
    public ParameterizedTypeImpl(Type[] actualTypeArguments, Type ownerType, Type rawType) {
        this.actualTypeArguments = actualTypeArguments;
        this.ownerType = ownerType;
        this.rawType = rawType;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return this.actualTypeArguments;
    }

    @Override
    public Type getOwnerType() {
        return this.ownerType;
    }

    @Override
    public Type getRawType() {
        return this.rawType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            ParameterizedTypeImpl that = (ParameterizedTypeImpl) o;
            if (!Arrays.equals(this.actualTypeArguments, that.actualTypeArguments)) {
                return false;
            } else {
                if (this.ownerType != null) {
                    if (this.ownerType.equals(that.ownerType)) {
                        return this.rawType != null ? this.rawType.equals(that.rawType) : that.rawType == null;
                    }
                } else if (that.ownerType == null) {
                    return this.rawType != null ? this.rawType.equals(that.rawType) : that.rawType == null;
                }
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = this.actualTypeArguments != null ? Arrays.hashCode(this.actualTypeArguments) : 0;
        result = 31 * result + (this.ownerType != null ? this.ownerType.hashCode() : 0);
        result = 31 * result + (this.rawType != null ? this.rawType.hashCode() : 0);
        return result;
    }
}
