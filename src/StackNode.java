
class StackNode {
	private final int value;
	private StackNode next;

	StackNode(final int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setNext(final StackNode next) {
		this.next = next;
	}

	public StackNode getNext() {
		return next;
	}
}