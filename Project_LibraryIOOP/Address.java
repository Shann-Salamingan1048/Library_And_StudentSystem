package Project_LibraryIOOP;

public class Address {
    private String City, Street;
    private int Zipcode;
    public void setCity(String city){this.City = city;}
    public String getCity(){return City;}
    public void setStreet(String street){this.Street = street;}
    public String getStreet(){return Street;}
    public void setZipcode(int zipcode){this.Zipcode = zipcode;}
    public int getZipcode(){return Zipcode;}
    Address(){
        this.City = "Unknown";
        this.Street = "Unknown";
        this.Zipcode = 0;
    }
    Address(String City, String Street, int Zipcode){
        this.City = City;
        this.Street = Street;
        this.Zipcode = Zipcode;

    }
}
