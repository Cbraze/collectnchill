package collectNChill.collectnchill.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FunkoPop {
		
		private Long id;
		private String name;
		private String genre;
		private String boxNumber;
		private String yearReleased;
		private String condition;
		private String unique;
		private String pictureUrl;
		private User user;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getBoxNumber() {
			return boxNumber;
		}
		public void setBoxNumber(String boxNumber) {
			this.boxNumber = boxNumber;
		}
		public String getYearReleased() {
			return yearReleased;
		}
		public void setYearReleased(String yearReleased) {
			this.yearReleased = yearReleased;
		}
		public String getCondition() {
			return condition;
		}
		public void setCondition(String condition) {
			this.condition = condition;
		}
		public String getUnique() {
			return unique;
		}
		public void setUnique(String unique) {
			this.unique = unique;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public String getPictureUrl() {
			return pictureUrl;
		}
		public void setPictureUrl(String pictureUrl) {
			this.pictureUrl = pictureUrl;
		}
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		@ManyToOne
		@JoinColumn(name = "userId")
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
}
