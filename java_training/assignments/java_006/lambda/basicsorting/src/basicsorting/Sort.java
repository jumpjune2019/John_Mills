package basicsorting;

interface Sort<T> {
	T[] sort(T[] arr, boolean upOrDown, boolean caseSensitive);
}