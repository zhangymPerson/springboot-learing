package cn.danao.annotation;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * date 2020/8/10 16:13 <br/>
 * description class <br/>
 * 自定义参数校验的实现
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class ValueAnnotationHandler implements ConstraintValidator<ValueAnnotation, String> {

    private String value;

    @Override
    public void initialize(ValueAnnotation constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (this.value != null && value != null) {
            List<String> list = Arrays.asList(this.value.split(","));
            if (list.contains(value)) {
                log.info("校验值[{}],存在在指定注解[{}]中", value, list);
                return true;
            }
        }
        return false;
    }
}
