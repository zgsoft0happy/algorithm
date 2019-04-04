package cn.ideacs.coding.algorithm.stack;

import cn.ideacs.coding.algorithm.*;
import cn.ideacs.coding.algorithm.stack.struct.Stack;
import cn.ideacs.coding.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数学表达式计算
 * 暂时支持得失加减乘除算法，不支持开方，乘方，括号等高级的数学计算，数值大小也是有限制的，
 * 限制的大小就是Java平台Long类型的限制。
 */
public class MathExpressionProcessor implements AlgorithmProcessor<String, Number> {

    /** 加法符号 */
    private static final Character ADD = '+';

    /** 减法符号 */
    private static final Character MINUS = '-';

    /** 乘法备用符号，计算机中常用 */
    private static final Character MUL = '*';

    /** 乘法符号，标准乘法符号 */
    private static final Character MULI = '✖';

    /** 除法备用符号，计算机中常用 */
    private static final Character DEV = '/';

    /** 除法符号，标准除法符号 */
    private static final Character DEVI = '➗';

    /** 操作符的运算级别 */
    private static final Map<Character, Integer> cacuLevel = new HashMap<Character, Integer>();

    /** 标准操作符集合 */
    private static final List<Character> operators = new ArrayList<Character>();

    /** 初始化操作符的运算级别和标准操作符集合 */
    static {
        cacuLevel.put(ADD, 1);
        cacuLevel.put(MINUS, 1);
        cacuLevel.put(MULI, 2);
        cacuLevel.put(DEVI, 2);

        operators.add(ADD);
        operators.add(MINUS);
        operators.add(MULI);
        operators.add(DEVI);
    }

    /**
     * 计算进程
     * 首先判断参数是否正确
     * TODO 这里对于参数是否正确还需要加入正则来判断表达式是否正确
     * 清除掉表达式中的空格，然后将表达式中不标准的运算符替换为标准的运算符
     * 然后首先遍历第一个数值，
     * 然后每次遍历一个操作符和操作数，对于高级的运算符直接进行对应操作数的计算
     * 然后剩下的就是非高级的运算法，为了实现从左到右的计算顺序，将操作数和操作符
     * 的栈取出并放到另外一个对应栈中，然后对新的栈就行遍历计算，最后判断操作数数
     * 量和操作符数量是否一致
     * @param parameter
     * @return
     */
    public AlgorithmResult<Number> process(AlgorithmParameter<String> parameter) {
        if (parameter == null) {
            throw new ParamException("参数为空");
        }
        String paramData = parameter.getParam();
        if (StringUtils.isEmpty(paramData)) {
            throw new ParamException("表达式为空");
        }

        paramData.trim();
        paramData = StringUtils.replaceAll(paramData, MUL, MULI);
        paramData = StringUtils.replaceAll(paramData, DEV, DEVI);

        Stack<Long> operateNum = new Stack<Long>();
        Stack<Character> operator = new Stack<Character>();
        int i = 0;

        String start = "";
        while (i < paramData.length() && paramData.charAt(i) >= 48 && paramData.charAt(i) <= 57) {
            start += paramData.charAt(i);
            i++;
        }
        operateNum.push(Long.parseLong(start));
        while (i < paramData.length()) {

            Character currentOperator = paramData.charAt(i);
            i++;
            String tmp = "";
            while (i < paramData.length() && paramData.charAt(i) >= 48 && paramData.charAt(i) <= 57) {
                tmp += paramData.charAt(i);
                i++;
            }
            operateNum.push(Long.parseLong(tmp));

            if (cacuLevel.get(currentOperator) == 2) {
                Long second = operateNum.pull();
                Long first = operateNum.pull();
                operateNum.push(operate(first,second,currentOperator));
            } else {
                operator.push(currentOperator);
            }

        }

        Stack<Long> operateNum2 = new Stack<Long>();
        Stack<Character> operator2 = new Stack<Character>();
        while (!operateNum.isEmpty()) {
            operateNum2.push(operateNum.pull());
        }
        while (!operator.isEmpty()) {
            operator2.push(operator.pull());
        }

        while (!operator2.isEmpty()) {
            Long first = operateNum2.pull();
            Long second = operateNum2.pull();
            Character op = operator2.pull();
            operateNum2.push(operate(first, second, op));
        }

        Long result = operateNum2.pull();
        if (!operateNum2.isEmpty()) {
            throw new CaclException("计算过程异常");
        }
        return new AlgorithmResult<Number>().setData(result);
    }

    /**
     * 计算给定的操作数和操作符对应的数值结果。
     * 注意操作数的顺序。
     * @param first
     * @param second
     * @param operate
     * @return
     */
    private Long operate(Long first, Long second, Character operate) {
        if (ADD.equals(operate)) {
            return first + second;
        } else if (MINUS.equals(operate)) {
            return first - second;
        } else if (MULI.equals(operate)) {
            return first * second;
        } else if (DEVI.equals(operate)) {
            return first / second;
        }
        return first;
    }
}
