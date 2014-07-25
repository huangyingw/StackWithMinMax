public class StackWithMinMax {
	private StackNode min;
	private StackNode max;
	private StackNode stack;

	public void push(final int value) {
		final StackNode node = new StackNode(value);
		if (stack == null) {
			stack = node;
		} else {
			node.setNext(stack);
			stack = node;
		}
		pushMax(value);
		pushMin(value);
	}

	private void pushMax(final int value) {
		final int maxValue = max == null ? value : value > max.getValue() ? value
				: max.getValue();
		final StackNode node = new StackNode(maxValue);
		node.setNext(max);
		max = node;
	}

	private void pushMin(final int value) {
		final int minValue = min == null ? value : value < min.getValue() ? value
				: min.getValue();
		final StackNode node = new StackNode(minValue);
		node.setNext(min);
		min = node;
	}

	public int pop() {
		if (stack == null) {
			throw new IllegalStateException("empty stack");
		}

		final StackNode poppedElement = stack;
		stack = stack.getNext();

		popMax();
		popMin();

		return poppedElement.getValue();
	}

	private void popMax() {
		max = max.getNext();
	}

	private void popMin() {
		min = min.getNext();
	}

	public int max() {
		if (max == null) {
			throw new IllegalStateException("empty stack");
		}
		return max.getValue();
	}

	public int min() {
		if (min == null) {
			throw new IllegalStateException("empty stack");
		}
		return min.getValue();
	}

	public void printStack() {
		StackNode node = min;
		while (node != null) {
			System.out.print(node.getValue() + " -> ");
			node = node.getNext();
		}
		System.out.println("NULL");
	}
}