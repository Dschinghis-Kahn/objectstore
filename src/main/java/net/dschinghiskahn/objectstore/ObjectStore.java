package net.dschinghiskahn.objectstore;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Stores objects in a cache.
 * 
 * @param <E> The object type to store.
 */
public class ObjectStore<E> {
	public static final long DEFAULT_MAX_SIZE = 1024;
	private final long maxMemSize;
	private Queue<E> objectCache;

	/**
	 * Creates a default ObjectStore.
	 */
	public ObjectStore() {
		this(ObjectStore.DEFAULT_MAX_SIZE);
	}

	/**
	 * Creates an ObjectStore with the given sizes.
	 * 
	 * @param maxMemSize The maximum number of elements to store in memory.
	 */
	public ObjectStore(long maxMemSize) {
		this(maxMemSize, false);
	}

	/**
	 * Creates an ObjectStore with the given sizes.
	 * 
	 * @param maxMemSize The maximum number of elements to store in memory.
	 * @param priorized  True if items are stored according to their natural order.
	 */
	public ObjectStore(long maxMemSize, boolean priorized) {
		this.maxMemSize = maxMemSize;
		if (priorized) {
			this.objectCache = new PriorityQueue<E>();
		} else {
			this.objectCache = new LinkedList<E>();
		}
	}

	/**
	 * Adds the object to the store.
	 * 
	 * @param object The object to add to the store.
	 */
	public void add(E object) {
		while (objectCache.size() >= maxMemSize) {
			hookWaitingToAddObject();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// Intentionally left empty.
			}
		}
		synchronized (objectCache) {
			objectCache.add(object);
			hookObjectAdded();
		}
	}

	protected void hookObjectAdded() {
	}

	protected void hookWaitingToAddObject() {
	}

	/**
	 * Returns and removes the oldest object from the store.
	 * 
	 * @return The oldest object in the store.
	 */
	public E get() {
		synchronized (objectCache) {
			return objectCache.poll();
		}
	}

	/**
	 * Returns the oldest object from the store without removing it.
	 * 
	 * @return The oldest object in the store.
	 */
	public E getNextObject() {
		synchronized (objectCache) {
			return objectCache.peek();
		}
	}

	/**
	 * Returns the total number of objects in the store.
	 * 
	 * @return The total number of objects in the store.
	 */
	public long getSize() {
		return objectCache.size();
	}

	/**
	 * Returns if the store is empty.
	 * 
	 * @return True if the store is empty, else otherwise.
	 */
	public boolean isEmpty() {
		return objectCache.isEmpty();
	}

	/**
	 * Returns the {@link String} representation of the object.
	 * 
	 * @return The {@link String} representation of the object.
	 */
	@Override
	public String toString() {
		return objectCache.toString();
	}
}
