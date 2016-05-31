package dg.concurrency.courseware.ch04;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo {
	static AtomicStampedReference<Integer> money = new AtomicStampedReference<Integer>(19, 0);

	public static void main(String[] args) {
		// ģ�����߳�ͬʱ���º�̨���ݿ⣬Ϊ�û���ֵ
		for (int i = 0; i < 3; i++) {
			final int timestamp = money.getStamp();
			new Thread() {
				public void run() {
					while (true) {
						while (true) {
							Integer m = money.getReference();
							if (m < 20) {
								if (money.compareAndSet(m, m + 20, timestamp, timestamp + 1)) {
									System.out.println("���С��20Ԫ����ֵ�ɹ������:" 
											+ money.getReference()+ "Ԫ");
									break;
								}
							} else {
								// System.out.println("������20Ԫ�������ֵ");
								break;
							}
						}
					}
				}
			}.start();
		}

		// �û������̣߳�ģ��������Ϊ
		new Thread() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					while (true) {
						int timestamp = money.getStamp();
						Integer m = money.getReference();
						if (m > 10) {
							System.out.println("����10Ԫ");
							if (money.compareAndSet(m, m - 10, timestamp, timestamp + 1)) {
								System.out.println("�ɹ�����10Ԫ�����:" + money.getReference());
								break;
							}
						} else {
							System.out.println("û���㹻�Ľ��");
							break;
						}
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			}
		}.start();
	}
}
