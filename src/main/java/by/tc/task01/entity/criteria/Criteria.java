package by.tc.task01.entity.criteria;


import java.util.HashMap;
import java.util.Map;

public class Criteria<E> {

	private Map<E, Object> criteria = new HashMap<>();

	public void add(E searchCriteria, Object value) {
			criteria.put(searchCriteria, value);
	}
	// you may add your own code here


	public Map<E, Object> getCriteria() {
		return criteria;
	}

	public void setCriteria(Map<E, Object> criteria)
	{
		this.criteria = criteria;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Criteria<?> criteria1 = (Criteria<?>) o;

		return criteria.equals(criteria1.criteria);
	}

	@Override
	public int hashCode() {
		return criteria.hashCode();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Map.Entry<E, Object> entry : criteria.entrySet()) {
			stringBuilder.append("\t"+entry.getKey()+" : "+entry.getValue()+"\n");
		}
		return stringBuilder.toString();

		}
	}

