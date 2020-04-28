package com.decagon.test;

import java.util.HashMap;

public class SocksSolution {

    public static int getMaximumPair(int noOfWashes, int[] cleanPile, int[] dirtyPile) {

        HashMap<Integer, Integer> cleanPileMap = new HashMap<>();
        HashMap<Integer, Integer> dirtyPileMap = new HashMap<>();

        int result = 0;

        for (int sock : cleanPile) {
            cleanPileMap.put(sock, cleanPileMap.getOrDefault(sock, 0) + 1);
        }

        for (int sock : dirtyPile) {
            dirtyPileMap.put(sock, dirtyPileMap.getOrDefault(sock, 0) + 1);
        }

        for (Integer sock : cleanPileMap.keySet()) {
            if (cleanPileMap.get(sock) % 2 == 1) {
                //get as much clean as possible
                result += cleanPileMap.get(sock) / 2;
                //if there is a pair that has dirty, wash
                if (noOfWashes > 0 && dirtyPileMap.containsKey(sock)) {
                    result++;
                    dirtyPileMap.put(sock, dirtyPileMap.get(sock) - 1);
                    noOfWashes--;
                }
            } else {
                result += cleanPileMap.get(sock) / 2;
            }
        }

        if (noOfWashes > 0) {
            //if we can still wash, and there are still dirty pair
            int rem = noOfWashes / 2;
            for (Integer sock : dirtyPileMap.keySet()) {
                if (rem > 0) {
                    int res = Math.min(dirtyPileMap.get(sock) / 2, rem);
                    result += res;
                    rem -= res;
                }
            }
        }

        return result;
    }
}