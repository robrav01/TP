package tp.pr5.observers;

public interface Observable<T> {
	public void addObserver(T o);
	public void removeObserver(T o);
}
