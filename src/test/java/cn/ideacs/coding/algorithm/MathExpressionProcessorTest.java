package cn.ideacs.coding.algorithm;

import cn.ideacs.coding.algorithm.stack.MathExpressionProcessor;
import static org.junit.Assert.*;
import org.junit.Test;

public class MathExpressionProcessorTest {

    @Test
    public void should_get_the_result() {
        String str = "12+36*2+18-2";
        AlgorithmParameter<String> param = new AlgorithmParameter<String>().setParam(str);
        AlgorithmProcessor<String, Number> processor = new MathExpressionProcessor();
        AlgorithmResult<Number> result = processor.process(param);
        assertEquals(result.getData().longValue(), 100);
    }

    @Test
    public void should_get_result_from_long_param() {
        String str =  "2*3*6/4+23-45+98+372*234+3487/34+3434-981+34454/23+2424";

        AlgorithmParameter<String> param = new AlgorithmParameter<String>().setParam(str);
        AlgorithmProcessor<String, Number> processor = new MathExpressionProcessor();
        AlgorithmResult<Number> result = processor.process(param);
        assertTrue(result.getData().longValue() == 93610L);
    }

}
