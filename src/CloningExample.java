
class Vehicle {
	
	private int wheels;

	/**
	 * @return the wheels
	 */
	public int getWheels() {
		return wheels;
	}

	/**
	 * @param wheels the wheels to set
	 */
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	
	
}

class Engine{
	
	private String type;

	
	public Engine(String type) {
		super();
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
}

class Car extends Vehicle implements Cloneable{
	
	private String name;
	
	private String color;

	private Engine engine;
	
	public Car(String name, String color, Engine engine) {
		this.name = name;
		this.color = color;
		this.engine = engine;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the engine
	 */
	public Engine getEngine() {
		return engine;
	}

	/**
	 * @param engine the engine to set
	 */
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", engine=" + engine.getType() + ", Wheels=" + this.getWheels() + "]";
	}
	
	
}
public class CloningExample {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Car car = new Car("Polo", "Copper Orange", new Engine("Petrol"));
		car.setWheels(4);
		
		System.out.println(car.toString());
		
		Car carClone = (Car)car.clone();
		
		System.out.println(carClone.toString());
		
		car.getEngine().setType("Diesel");
		
		System.out.println(carClone.toString());
	}
}
