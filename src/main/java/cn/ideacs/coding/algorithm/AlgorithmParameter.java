package cn.ideacs.coding.algorithm;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 算法执行器的参数范型类
 * @param <T>
 */

@Data
@Accessors(chain = true)
public class AlgorithmParameter<T> {

    T param;

}
