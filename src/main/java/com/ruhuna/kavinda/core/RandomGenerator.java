package com.ruhuna.kavinda.core;

import java.util.LinkedHashSet;
import java.util.Random;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/25/2018
 */
public abstract class RandomGenerator {

    protected Integer generateRandomNumber() {

        int transactionalId = 0;
        Random random = new Random();
        boolean isNotContain = true;
        LinkedHashSet<Integer> randomList = getTransactionalNoList();
        do {
            int nextInteger = random.nextInt();
            if (!randomList.contains(nextInteger) && nextInteger > 0) {
                transactionalId = nextInteger;
                isNotContain = false;
                randomList.add(transactionalId);
            }
        } while (isNotContain);

        return transactionalId;
    }

    protected abstract LinkedHashSet<Integer> getTransactionalNoList();
}
