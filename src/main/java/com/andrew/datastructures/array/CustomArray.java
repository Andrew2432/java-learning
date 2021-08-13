package com.andrew.datastructures.array;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomArray {
	private ArrayList<Integer> items = null;

	public CustomArray() {
		this.items = new ArrayList<>();
	}

	public void showItems() {
		Iterator<Integer> iterator = items.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

	public void insertItem(int item) {
		try {
			this.items.add(item);
		} catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
			System.out.println("Cannot insert! Array is full");
		}
	}
}
