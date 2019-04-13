import java.util.*;


public class MyArrayList <E> implements List {
	private int size;
	private int front;
	private int rear;
	private int capacity;
	private E[] myArrayList;
	
	public MyArrayList() {
		this.size = 0;
		this.front = 0;
		this.rear = 0;
		this.capacity = 0;
		this.myArrayList = null;
	}
	
	public MyArrayList (int capacity) {
		this.size = 0;
		this.front = 0;
		this.rear = 0;
		this.capacity = capacity;
		this.myArrayList = (E[]) new Object[capacity];
	}
	
	public int getFront() {
		return this.front;
	}
	
	public int getRear() {
		return this.rear;
	}
	
	/**
	 * @param the substive method add(E e) as an alternative solution for the problem of name clash
	 * @return
	 */
	public boolean add(Object e) {
		boolean flag = false;
		if(e!=null) {
			this.myArrayList[this.rear] = (E) e;
			this.rear++;
			this.size++;
			flag = true;
			copyArray();
		}
		return flag;
	}
	
	/**
	 * @param the substive method add(E e) as an alternative solution for the problem of name clash
	 * @return
	 */
	public void add(int index,Object element) {
		if(this.size == 0 || this.myArrayList==null) {
			this.add(element);
		}
		else {
			if(index > this.rear) {
				this.add(element);
			}
			else if(index < this.front && index>=0) {
				this.myArrayList[this.front--] = (E) element;
				this.size++;
				this.copyArray();
			}
			else {
				if(this.myArrayList[index]==null) {
					this.myArrayList[index] = (E) element;
				}
				else if(this.myArrayList[index+1]==null) {
					this.myArrayList[index+1] = this.myArrayList[index];
					this.myArrayList[index] = (E) element;
				}
				else {
					for(int i=this.rear; i>index; i--) {
						if(this.myArrayList[i-1]!=null) {
							this.myArrayList[i] = this.myArrayList[i-1];
						}
					}
					this.myArrayList[index] = (E) element;
				}
				this.size++;
				this.rear++;
				this.copyArray();
			}
		}
	}
	
	/**
	 * 
	 * @param copy the present array to an enlarged one when the size of present array exceeds 75% of the capacity.
	 * @return
	 */
	public boolean copyArray() {
		boolean flag = false;
		if((float) this.size/this.capacity>=0.75) {
			this.capacity = 2*this.capacity;
			E[] tempArray = (E[]) new Object[this.capacity];
			int length = this.front - this.rear;
			for(int i=0; i< length; i++) {
				tempArray[i] = this.myArrayList[i];
			}
			this.myArrayList = tempArray;
			flag = true;
		}
		return flag;
	}
	
	public void clear() {
		this.size = 0;
		this.front = 0;
		this.rear = 0;
		this.capacity = 1;
		this.myArrayList[0] = null;
	}
	
	public E removeStart() {
		E item = this.myArrayList[this.front];
		this.myArrayList[this.front] = null;
		this.size--;
		this.front++;
		this.copyArrayR();
		return item;
	}
	public E remove(int index) {
		E item = null;
		if(this.rear>index && this.front<index) {
			if(index==this.front) {
				item = this.removeStart();
				return item;
			}
			else {
				item = this.myArrayList[index];
				if(index == this.rear - 1) {
					this.myArrayList[index] = null;
					this.rear--;
					this.size--;
					this.copyArrayR();
				}
				else {
					for(int i=index; i<this.rear-1; i++) {
						this.myArrayList[i] = this.myArrayList[i+1];
						this.rear--;
						this.size--;
						
						this.copyArrayR();
					}
				}
			}
		}
		return item;
	}
	
	public boolean remove(Object o) {
		boolean flag = false;
		int index = -1;
		for(int i=this.front; i<this.rear; i++) {
			if(this.myArrayList[i]!=null && this.myArrayList[i].getClass().equals(o.getClass()) && this.myArrayList[i]==o) {
				index = i;
				break;
			}
		}
		if(index!=-1) {
			this.remove(index);
			flag = true;
		}
		return flag;
	}
	
	public boolean copyArrayR() {
		boolean flag = false;
		if((this.front!=this.rear && (float) this.size/this.capacity<=0.25)) {
			this.capacity = this.capacity / 2;
			E[] tempArray = (E[]) new Object[this.capacity];
			int length = this.rear - this.front;
			for(int i=0; i< length; i++) {
				tempArray[i] = this.myArrayList[i];
			}
			this.myArrayList = tempArray;
			this.front = 0;
			this.rear = length;
			this.size = length;
			flag = true;
		}
		return flag;
	}
	
	public String toString() {
		String myString = "";
		if(this.size>0) {
			myString = "This arraylist has " + this.size + " elements, and here are the elements of the arraylist:\n";
			for(int i=0; i<this.rear; i++) {
				myString += this.myArrayList[i] + "\n";
			}
		}
		else
			myString = "There is no element in this arraylist now";
		return myString;
	}
	
	public int size() {
		return this.size;
	}

	

	@Override
	public boolean addAll(Collection c) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method is not supported by this implementation.");
		
	}

	@Override
	public boolean addAll(int index, Collection c) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method is not supported by this implementation.");
	}

	@Override
	public boolean contains(Object o) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method is not supported by this implementation.");
	}

	@Override
	public boolean containsAll(Collection c) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method is not supported by this implementation.");
	}

	@Override
	public Object get(int index) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method is not supported by this implementation.");
	}

	@Override
	public int indexOf(Object o) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method is not supported by this implementation.");
	}

	@Override
	public boolean isEmpty() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method is not supported by this implementation.");
	}

	@Override
	public Iterator iterator() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method is not supported by this implementation.");
	}

	@Override
	public int lastIndexOf(Object o) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method is not supported by this implementation.");
	}

	@Override
	public ListIterator listIterator() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method is not supported by this implementation.");
	}

	@Override
	public ListIterator listIterator(int index) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method is not supported by this implementation.");
	}

	@Override
	public boolean removeAll(Collection c) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method is not supported by this implementation.");
	}

	@Override
	public boolean retainAll(Collection c) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method is not supported by this implementation.");
	}

	@Override
	public Object set(int index, Object element) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method is not supported by this implementation.");
	}

	@Override
	public List subList(int fromIndex, int toIndex) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method is not supported by this implementation.");
	}

	@Override
	public Object[] toArray() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method is not supported by this implementation.");
	}

	@Override
	public Object[] toArray(Object[] a) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method is not supported by this implementation.");
	}
}
