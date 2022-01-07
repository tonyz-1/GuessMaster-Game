//Tony Zheng 20187099

public class Singer extends Person {
	//these two instance variables were required
	private String debutAlbum;
	private Date debutAlbumReleaseDate;
	
	//this constructor was required, and needed to avoid privacy leaks
	public Singer(String name, Date birthday, String debutAlbum, Date debutAlbumReleaseDate) {
		super(name, birthday);
		this.debutAlbum = debutAlbum;
		this.debutAlbumReleaseDate = debutAlbumReleaseDate;
	}
	
	//better clone method
	public Singer clone() {
		Singer newSinger = (Singer) super.clone();
		return newSinger;
	}
	
	//this toString method was required
	public String toString() {
		return super.toString()+". Their debut album was "+this.debutAlbum+", and it was released on "+this.debutAlbumReleaseDate.getDay()+" "+this.debutAlbumReleaseDate.getMonth()+", "+this.debutAlbumReleaseDate.getYear();
	}
	
	//this method was required
	public String personType() {
		return "singer";
	}

}
