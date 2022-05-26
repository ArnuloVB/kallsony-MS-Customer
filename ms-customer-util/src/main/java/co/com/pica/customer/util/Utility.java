package co.com.pica.customer.util;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Utility {
	
	public static void copyPropertiesIgnoreNull(Object source, Object target) {
		String[] nullPropertyNames = getNullPropertyNames(source);
		BeanUtils.copyProperties(source, target, nullPropertyNames);
	}

	private static String[] getNullPropertyNames(Object source) {
		final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
		return Stream.of(wrappedSource.getPropertyDescriptors()).map(FeatureDescriptor::getName)
		.filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null).toArray(String[]::new);
	}
}
