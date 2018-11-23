package com.el.designPatterns.singleTon;

/**
 * @author Danfeng
 * @since 2018/11/21
 */
public class ChocolateFactory {
    private boolean empty;
    private boolean boiled;
    private static ChocolateFactory uniqueChocolateFactory = null;

    private ChocolateFactory() {
        empty = true;
        boiled = false;
    }

    /**
     * 双重检查加锁
     *
     * @return
     */
    public static ChocolateFactory getInstance() {
        if (null == uniqueChocolateFactory) {
            synchronized (ChocolateFactory.class) {
                if (null == uniqueChocolateFactory) {
                    uniqueChocolateFactory = new ChocolateFactory();
                }
            }
        }
        return uniqueChocolateFactory;
    }

    public void fill() {
        if (empty) {
            empty = false;
            boiled = false;
        }
    }

    public void drain() {
        if (!empty && boiled) {
            empty = true;
        }
    }

    public void boil() {
        if (!empty && boiled) {
            boiled = true;
        }
    }
}
