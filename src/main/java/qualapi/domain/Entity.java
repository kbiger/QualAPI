package qualapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by kbiger on 16/03/16.
 */
public abstract class Entity {

	@JsonProperty("id")
	private Long id;

	public Long getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || id == null || getClass() != o.getClass()) return false;

		Entity entity = (Entity) o;

		if (!id.equals(entity.id)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return (id == null) ? -1 : id.hashCode();
	}
}