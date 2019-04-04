package cn.ideacs.coding.algorithm;

/**
 * 算法的执行器接口
 * @param <K>
 * @param <R>
 */
public interface AlgorithmProcessor<K,R> {

    /**
     * 执行器的执行接口。
     * @param parameter
     * @return
     */
    AlgorithmResult<R> process(AlgorithmParameter<K> parameter);

}
