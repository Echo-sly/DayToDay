package designPatterns.prototypePattern.deep;

import lombok.SneakyThrows;

import java.io.*;
import java.util.Date;

/**
 * Demo SuperMonkey
 *
 * @author sunlianyu
 * @date 2021/8/18 18:33
 */
public class SuperMonkey extends Money implements Cloneable, Serializable {

	public GoldenCudgel goldenCudgel;

	public SuperMonkey() {
		this.birthday = new Date();
		this.goldenCudgel = new GoldenCudgel();
	}

	@SneakyThrows
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return deepClone();

	}

	public Object deepClone() {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			//FileOutputStream
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(this);
			//生成新的孙悟空
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());

			ObjectInputStream ois = new ObjectInputStream(bis);
			SuperMonkey dasheng = (SuperMonkey) ois.readObject();
			dasheng.birthday = new Date();

			oos.flush();
			oos.close();
			bos.close();
			return dasheng;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}

