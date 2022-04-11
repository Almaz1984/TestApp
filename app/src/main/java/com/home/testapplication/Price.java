package com.home.testapplication;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Price {

    private Price() {
    }

    /**
     * Метод "скидка". Применяет скидку discount к цене price, начиная с позиции offset
     * на количество позиций readLength. Новые цены округляем “вниз”,
     * до меньшего целого числа.
     *
     * @param price      - исходные цены.
     * @param discount   - % скидки, от 1 до 99.
     * @param offset     - номер позиции, с которой нужно применить скидку.
     * @param readLength - количество позиций, к которым нужно применить скидку.
     * @return - массив новых цен.
     */
    @Nullable
    public static int[] decryptData(@NonNull int[] price,
                                    @IntRange(from = 1) int discount,
                                    @IntRange(from = 0) int offset,
                                    @IntRange(from = 1) int readLength) {

        if ((price.length == 0)
                || (discount > 99)
                || (offset + readLength > price.length)
                || (offset < 0)
                || readLength < 1) {
            return null;
        }

        int[] newPrice = new int[readLength];
        for (int i = offset; i < offset + readLength; i++) {
            newPrice[i - offset] = getDiscountPrice(price[i], discount);
        }
        return newPrice;
    }

    private static int getDiscountPrice(int price, int discount) {
        final double MAX_PERCENT = 100.0;
        return (int) Math.floor(price - price * discount / MAX_PERCENT);
    }
}
