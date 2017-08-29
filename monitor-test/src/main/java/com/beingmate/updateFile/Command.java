package com.beingmate.updateFile;

public interface Command<T,E> {
	public E execute(T t);
}
