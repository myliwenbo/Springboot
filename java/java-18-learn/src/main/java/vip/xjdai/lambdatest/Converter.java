package vip.xjdai.lambdatest;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}