package com.didispace.redis;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class RedisObjectSerializer implements RedisSerializer<Object> {

	private Converter<Object, byte[]> serializer = new SerializingConverter();
	private Converter<byte[], Object> deserializer = new DeserializingConverter();

	@Override
	public byte[] serialize(Object paramT) throws SerializationException {
		if (paramT==null) {
			return null;
		} else {
			try {
				return (byte[]) serializer.convert((byte[]) paramT);
			} catch (Exception e) {
				throw new SerializationException("Cannot deserialize", e);
			}
		}
	}

	@Override
	public Object deserialize(byte[] paramT) throws SerializationException {
		if (paramT==null) {
			return null;
		} else {
			try {
				return (byte[]) deserializer.convert((byte[]) paramT);
			} catch (Exception e) {
				throw new SerializationException("Cannot deserialize", e);
			}
		}
	}

	private boolean isEmpty(byte[] data) {
		return (data == null || data.length == 0);
	}

}
