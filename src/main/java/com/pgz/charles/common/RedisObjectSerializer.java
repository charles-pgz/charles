package com.pgz.charles.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @author charles
 * @title: RedisObjectSerializer
 * @projectName charles
 * @description: 自定义序列化器，实现对象的序列化接口
 * @date 19/4/2216:41
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {

    private Converter<Object,byte[]> serializer = new SerializingConverter();
    private Converter<byte[],Object> deserializer = new DeserializingConverter();

    static final byte[] EMPTY_ARRAY = new byte[0];

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        if(o==null){
            return EMPTY_ARRAY;
        }
        return serializer.convert(o);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if(isEmpty(bytes)){
            return null;
        }
        return deserializer.convert(bytes);
    }

    private boolean isEmpty(byte[] data){
        return (data == null || data.length==0);
    }
}
