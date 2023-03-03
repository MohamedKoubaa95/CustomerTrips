package model;

import java.util.List;

public class Station {
    private String name;
    private List<Integer> zones;
    
	public Station(String name, List<Integer> zones) {
		this.name = name;
		this.zones = zones;
	}
	
    public String getName() {
		return name;
	}



	public List<Integer> getZones() {
		return zones;
	}

	@Override
	public String toString() {
		return "Station [name=" + name + ", zones=" + zones + "]";
	}



	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null) {
	        return false;
	    }
	    if (getClass() != obj.getClass()) {
	        return false;
	    }
	    Station other = (Station) obj;
	    if (name == null) {
	        if (other.name != null) {
	            return false;
	        }
	    } else if (!name.equals(other.name)) {
	        return false;
	    }
	    if (zones == null) {
	        if (other.zones != null) {
	            return false;
	        }
	    } else if (!zones.equals(other.zones)) {
	        return false;
	    }
	    return true;
	}

    
	
    
}
