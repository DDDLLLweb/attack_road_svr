package com.el.udc;

import com.el.util.DevError;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author neo.pan
 * @since 17/8/4
 */
@Component
@RequiredArgsConstructor
public class UdcNameResolver<U extends UdcFace, I extends UdcItem> {

    private final UdcService<U, I> udcService;
    private final UdcResolver<U> udcResolver;

    /**
     * 将UDC名注入到@{@link UdcName}标注的属性中。
     *
     * @param obj 任何实例
     * @param <T> 任何类型
     * @return obj
     */
    public final <T> T resolveUdcNames(T obj) {
        try {
            val injectors = injectorsOf(obj.getClass());
            if (!injectors.isEmpty()) {
                injectUdcName(obj, injectors);
            }
            return obj;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw DevError.unexpected();
        }
    }

    /**
     * 将UDC名注入到@{@link UdcName}标注的属性中。
     *
     * @param objs 任何实例列表
     * @param <T>  任何类型
     * @return objs
     */
    public final <T> List<T> resolveUdcNames(List<T> objs) {
        try {
            if (!objs.isEmpty()) {
                val injectors = injectorsOf(objs.get(0).getClass());
                if (!injectors.isEmpty()) {
                    for (val obj : objs) {
                        injectUdcName(obj, injectors);
                    }
                }
            }
            return objs;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw DevError.unexpected();
        }
    }

    private List<UdcNameInjector> injectorsOf(Class<?> domainClazz) throws NoSuchMethodException {
        val injectors = new ArrayList<UdcNameInjector>();
        val fields = domainClazz.getDeclaredFields();
        for (val field : fields) {
            val udcName = field.getAnnotation(UdcName.class);
            if (udcName != null) {
                val codeGetter = domainClazz.getDeclaredMethod(fieldToGetter(udcName.codePropName()));
                val nameSetter = domainClazz.getDeclaredMethod(fieldToSetter(field.getName()), String.class);
                U udc;
                try {
                    udc = udcResolver.resolve(udcName.udcName());
                } catch (Exception ex) {
                    throw new DevError(String.format(
                        "Property `udcName` of @UdcName on %s#%s is wrong: %s",
                        domainClazz.getName(), field.getName(), ex.getMessage()));
                }
                val udcItems = udcService.udcItems(udc).stream()
                    .collect(Collectors.toMap(UdcItem::getCode, UdcItem::getName));
                injectors.add(UdcNameInjector.of(codeGetter, nameSetter, udcItems));

            }
        }
        return injectors;
    }

    private static <T> void injectUdcName(T obj, List<UdcNameInjector> injectors)
        throws IllegalAccessException, InvocationTargetException {
        for (val injector : injectors) {
            val udcCode = (String) injector.codeGetter.invoke(obj);
            if (udcCode != null) {
                injector.nameSetter.invoke(obj, injector.getUdcItems().get(udcCode));
            }
        }
    }

    private static String fieldToGetter(String fieldName) {
        return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }

    private static String fieldToSetter(String fieldName) {
        return "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }

}
