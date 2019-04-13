import java.util.*;

public class MyLinkedList<E> implements List {
	private Node head;
	private Node end;
	private int size;
	private Class<E> classKind;
	
	private class Node {
		private E data;
		private Node next;
		private Node previous;
		
		public Node(){
			this.data = null;
			this.next = null;
			this.previous = null;
		}
		
		public Node(E e, Node next, Node previous) {
			this.data = e;
			this.next = next;
			this.previous = previous;
		}
		public E getData() {
			return this.data;
		}
		public void setData(E data) {
			this.data = data;
		}
		public Node getNext() {
			return this.next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getPrevious() {
			return this.previous;
		}
		public void setPrevious(Node previous) {
			this.previous = previous;
		}
	}

	public MyLinkedList(Class<E> classKind) {
		this.size = 0;
		this.classKind = classKind;
		this.head = new Node(null,null,null);
		this.end = new Node(null, null, null);
		this.head.next = this.end;
		this.end.previous = this.head;
	}
	
	public MyLinkedList(E e, Class<E> classKind) {
		Node n = new Node(e, this.end, this.head);
		this.head.next = n;
		this.head.previous = null;
		this.end.previous = n;
		this.end.next = null;
		this.size = 1;
		this.classKind = classKind;
	}
	
	public boolean add(Object e) {
		boolean flag = false;
		if(e!=null) {
			E item = null;
			if(e.getClass().equals(this.classKind)) {
				item = (E) e;
				Node before = this.end.previous;
				Node n = new Node(item, this.end, before);
				this.end.previous = n;
				before.next = n;
				this.size++;
				flag = true;
			}
		}
		return flag;
	}
	
	public void add(int index,Object element) {
		if(element!=null) {
			E item = null;
			if(element.getClass().equals(this.classKind)) {
				item = (E) element;
				if(index>this.size-1) {
					add(element);
				}
				else if(index==0) {
					Node after = this.head.next;
					Node n = new Node(item, after, this.head);
					after.previous = n;
					this.head.next = n;
					this.size++;
				}
				else {
					int count = 0;
					Node n = this.head.next;
					while(count!=index && count<this.size) {
						n = n.next;
						count++;
					}
					Node before = n.previous;
					Node m = new Node(item, n, before);
					before.next = m;
					n.previous = m;
					this.size++;
				}
			}
		}
	}
	
	public void clear() {
		this.head.next = this.end;
		this.end.previous = this.head;
		this.size = 0;
	}
	
	public E remove(int index) {
		Node item = new Node(null,null,null);
		if(this.size!=0 && index<=this.size-1) {
			if(index == 0) {
				Node oldSecondItem = this.head.getNext().getNext();
				this.head.next = oldSecondItem;
				oldSecondItem.previous = this.head;
				item.setNext(null);
				item.setPrevious(null);
				this.size--;
			}
			else if(index == this.size-1) {
				Node oldSecondItemRev = this.end.getPrevious().getPrevious();
				item = this.end.getPrevious();
				this.end.setPrevious(oldSecondItemRev);
				oldSecondItemRev.setNext(this.end);
				item.setNext(null);
				item.setPrevious(null);
				this.size--;
			}
			else {
				int count = 0;
				item = this.head.getNext();
				while(count<=index && item.getNext()!=this.end) {
					item = item.getNext();
					count++;
				}
				Node before = item.previous;
				Node after = item.next;
				before.next = after;
				after.previous = before;
				item.setNext(null);
				item.setPrevious(null);
				this.size--;
			}
		}
		return (E) item.data;
	}
	
	public boolean remove(Object o) {
		boolean flag = false;
		if(o!=null) {
			E item = null;
			if(o.getClass().equals(this.classKind)) {
				Node n = this.head.getNext();
				while(n.getNext()!=null) {
					item = (E) n.getData();
					if(item.equals(o)) {
						Node before = n.getPrevious();
						Node after = n.getNext();
						before.setNext(after);
						after.setPrevious(before);
						this.size--;
						n = null;
						flag = true;
						return flag;
					}
					n = n.getNext();
				}
			}
		}
		return flag;
	}
	
	public String toString() {
		String myString = "";
		if(this.size>0) {
			myString = "This linkedlist has " + this.size + " elements, and here are the elements of the linkedlist:\n";
			Node n = this.head.next;
			while(n!=this.end) {
				myString += n.data + "\n";
				n = n.next;
			}
		}
		else {
			myString = "There is no element in this arraylist now";
		}
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
