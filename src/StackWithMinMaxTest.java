import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StackWithMinMaxTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	/**
	 * 1 -> 5 -> 2 -> 4
	 */
	@Test
	public void testMinStack() {
		final StackWithMinMax stack = new StackWithMinMax();
		stack.push(4);
		stack.push(2);
		stack.push(5);
		stack.push(1);

		assertEquals(1, stack.min());
		stack.pop();
		assertEquals(2, stack.min());
		stack.pop();
		assertEquals(2, stack.min());
		stack.pop();
		assertEquals(4, stack.min());
		stack.pop();

		expectedException.expect(IllegalStateException.class);
		expectedException.expectMessage("empty stack");
		stack.min();

	}

	/**
	 * 1 -> 5 -> 2 -> 4
	 */
	@Test
	public void testMaxStack() {
		final StackWithMinMax stack = new StackWithMinMax();
		stack.push(4);
		stack.push(2);
		stack.push(5);
		stack.push(1);

		assertEquals(5, stack.max());
		stack.pop();
		assertEquals(5, stack.max());
		stack.pop();
		assertEquals(4, stack.max());
		stack.pop();
		assertEquals(4, stack.max());
		stack.pop();

		expectedException.expect(IllegalStateException.class);
		expectedException.expectMessage("empty stack");
		stack.max();
	}
}