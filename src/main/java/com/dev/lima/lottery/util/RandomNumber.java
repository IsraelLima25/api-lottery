package com.dev.lima.lottery.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RandomNumber {

	public List<Integer> getNumberListSorty() {

		List<Integer> numbersSorty = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			Integer numberSorty = (int) (Math.random() * 100);
			if (!numbersSorty.contains(numberSorty)) {
				numbersSorty.add(numberSorty);
			}
		}
		return numbersSorty;
	}
}
