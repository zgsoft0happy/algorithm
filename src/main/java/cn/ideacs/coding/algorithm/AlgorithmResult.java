package cn.ideacs.coding.algorithm;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 算法的执行结果范型类。
 * @param <T>
 */
@Data
@Accessors(chain = true)
public class AlgorithmResult<T> {

    T data;

}
