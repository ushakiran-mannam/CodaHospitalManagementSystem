package global.coda.hospitalmanagement.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Patient.
 */
public class Patient extends User {

	/** The age. */
	private int age;

	/** The name. */
	private String name;

	/** The area. */
	private String area;

	/** The state. */
	private String state;

	/** The city. */
	private String city;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the area.
	 *
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * Sets the area.
	 *
	 * @param area the new area
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/** The id. */
	private int id;

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return id + "," + name + "," + age + "," + area + "," + city + "," + state;

	}
}
