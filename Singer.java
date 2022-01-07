
public class Singer extends Person {
	private String debutAlbum;
	private Date debutAlbumReleaseDate;
	
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
	
	public String toString() {
		return super.toString()+". Their debut album was "+this.debutAlbum+", and it was released on "+this.debutAlbumReleaseDate.getDay()+" "+this.debutAlbumReleaseDate.getMonth()+", "+this.debutAlbumReleaseDate.getYear();
	}
	
	public String personType() {
		return "singer";
	}

}
