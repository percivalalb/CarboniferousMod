package carboniferous.core.helper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ProPercivalalb
 */
public class ReflectionHelper {

	public static Class getClassForName(String name) {
    	try {
			return Class.forName(name);
		}
    	catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
	
	public static void invokeMethod(Class class1, Object instance, String name, Class[] params, Object[] params1) {
		Method mtd = getMethod(class1, name, params);
		try {
			mtd.invoke(instance, params1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Method getMethod(Class class1, String name, Class... params) {
    	Method mtd = null;
		try {
			mtd = class1.getDeclaredMethod(name, params);
			mtd.setAccessible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return mtd;
    }
	
	public static Field getField(Class<?> class1, Object instance, int fieldIndex) {
		try {
			Field field = class1.getDeclaredFields()[fieldIndex];
	        field.setAccessible(true);
	        return field;
	    }
		catch(Exception e) {
		    e.printStackTrace();
		    return null;
		}
	}
	
	public static Field getField(Class<?> class1, Object instance, String fieldIndex) {
		try {
			Field field = class1.getDeclaredField(fieldIndex);
	        field.setAccessible(true);
	        return field;
	    }
		catch(Exception e) {
		    e.printStackTrace();
		    return null;
		}
	}
	
	/**
	 * Gets the object a field holds
	 * @param class1 The class the field is in
	 * @param fieldType The object the field contains
	 * @param instance The instance
	 * @param fieldName The field name
	 * @return The object that the class contains
	 */
	public static <T> T getField(Class<?> class1, Class<T> fieldType, Object instance, int fieldIndex) {
		try {
			Field field = getField(class1, instance, fieldIndex);
			return (T)field.get(instance);
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	/**
	 * Gets the object a field holds
	 * @param class1 The class the field is in
	 * @param fieldType The object the field contains
	 * @param instance The instance
	 * @param fieldName The field name
	 * @return The object that the class contains
	 */
	public static <T> T getField(Class<?> class1, Class<T> fieldType, Object instance, String fieldName) {
		try {
	         Field field = getField(class1, instance, fieldName);
	         return (T) field.get(instance);
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	/**
	 * Sets a field to the giving values.
	 * @param field The target field
	 * @param instance The instance
	 * @param value The value to set the field to
	 */
	public static void setField(Field field, Object instance, Object value) {
        try {
            field.set(instance, value);
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	public static void setField(Class<?> class1, Object instance, int fieldIndex, Object value) {
        try {
        	Field field = getField(class1, instance, fieldIndex);
            field.set(instance, value);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void setField(Class<?> class1, Object instance, String fieldName, Object value) {
        try {
        	Field field = getField(class1, instance, fieldName);
            field.set(instance, value);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
