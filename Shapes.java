package com.rt.rx;

public class Shapes {
	public String name;
	int sides;
	
	public Shapes(String name, int side){
		this.name = name;
		this.sides =side;
	}
	public Shapes(String name){
		this.name = name;
	}
	public Shapes(){}
	
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
	 * @return the sides
	 */
	public int getSides() {
		return sides;
	}
	/**
	 * @param sides the sides to set
	 */
	public void setSides(int sides) {
		this.sides = sides;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sides;
		return result;
	}
	
	@Override
	public String toString() {
		return "Shapes [name=" + name + ", sides=" + sides + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shapes other = (Shapes) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sides != other.sides)
			return false;
		return true;
	}	
}
