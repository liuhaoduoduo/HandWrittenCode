package mutual_exclusion;

/**
 * 在多线程环境下交替的输出 A 和 B 两个字母。
 */
public class PringAB {

	/**
	 * 控制打印顺序的共享对象。
	 */
	private static class Printer {
		// 输出A或B的轮次标识，0为该输出A，1为该输出B
		private byte aMark = 0;

		public synchronized void printA() {
			// 当标识为0时，说明刚刚打印过B，应该轮到A
			while (aMark != 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					return;
				}
			}
			System.out.print("A");
			aMark|=1;
			notifyAll();
		}

		public synchronized void printB() {
			// 当 count 为偶数时，说明刚刚打印过 B（或还没打印），应该轮到 A
			while (aMark!=1) {
				try {
					wait();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					return;
				}
			}
			System.out.print("B");
			aMark&=0;
			notifyAll();
		}
	}

	public static void main(String[] args) {
		Printer printer = new Printer();
		int times = 10; // 控制打印次数：最终输出 10 对 "AB"

		Thread threadA = new Thread(() -> {
			for (int i = 0; i < times; i++) {
				printer.printA();
			}
		}, "Printer-A");

		Thread threadB = new Thread(() -> {
			for (int i = 0; i < times; i++) {
				printer.printB();
			}
		}, "Printer-B");

		threadA.start();
		threadB.start();

		try {
			threadA.join();
			threadB.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		System.out.println();
	}
}
