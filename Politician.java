
public class Politician extends Person{
	private String party;
	
		public Politician(String name, Date birthday, String party) {
			super(name, birthday);
			this.party = party;
		}

		//better clone method
		public Politician clone() {
			Politician newPolitician = (Politician) super.clone();
			return newPolitician;
		}
		
		public String toString() {
			return super.toString()+". They are a member of the "+this.party+" party.";
		}
		
		public String personType() {
			return "politician";
		}
}
