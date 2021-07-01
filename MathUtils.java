package com.huawei.boot.demo.probability;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Math Utils
 *
 * @author h30003508
 * @version 1.0
 * @date 2021/06/22
 */
public final class MathUtils {

    /**
     * 私有化构造方法
     */
    private MathUtils() {}

    /**
     * 平方值
     * 
     * @param num
     * @return
     */
    public static BigDecimal square(int num) {
        return new BigDecimal(num * num);
    }

    /**
     * 平方值
     * 
     * @param num
     * @return
     */
    public static BigDecimal square(BigDecimal num) {
        return num.pow(2);
    }

    /**
     * 平均值
     * 
     * @param sum
     * @param size
     * @return
     */
    public static BigDecimal average(int sum, int size) {
        return average(new BigDecimal(sum), new BigDecimal(size));
    }

    /**
     * 平均值
     * 
     * @param sum
     * @param size
     * @return
     */
    public static BigDecimal average(BigDecimal sum, BigDecimal size) {
        return sum.divide(size, ProbabilityConstants.NEW_SCALE, ProbabilityConstants.ROUNDING_MODE);
    }

    /**
     * 求和
     * 
     * @param nums
     * @return
     */
    public static BigDecimal sum(int[] nums) {
        BigDecimal sum = BigDecimal.ZERO;
        for (int num : nums) {
            sum = sum.add(new BigDecimal(num));
        }

        return sum;
    }

    /**
     * 方差
     * 
     * @param samples 样本
     */
    public static BigDecimal variance(int[] samples) {
        if (Objects.isNull(samples) || samples.length <= 0) {
            throw new IllegalArgumentException("variance : samples can not be empty.");
        }

        BigDecimal size = new BigDecimal(samples.length);
        BigDecimal avg = average(sum(samples), size);
        BigDecimal sum = BigDecimal.ZERO;
        for (int sample : samples) {
            sum = sum.add(new BigDecimal(sample).subtract(avg).pow(2));
        }

        return sum.divide(size, ProbabilityConstants.NEW_SCALE, ProbabilityConstants.ROUNDING_MODE);
    }

    /**
     * 已知方差计算标准差
     * 
     * @param variance
     * @return
     */
    public static BigDecimal standardDeviation(BigDecimal variance) {
        return new BigDecimal(Math.pow(variance.doubleValue(), 0.5))
                .setScale(ProbabilityConstants.NEW_SCALE, ProbabilityConstants.ROUNDING_MODE);
    }
}
